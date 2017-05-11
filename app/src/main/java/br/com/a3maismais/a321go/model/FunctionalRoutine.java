package br.com.a3maismais.a321go.model;

import android.media.MediaPlayer;
import android.widget.TextView;

import br.com.a3maismais.a321go.R;
import br.com.a3maismais.a321go.activity.ActivityPrincipal;

/**
 * Created by fred on 04/05/17.
 */

public class FunctionalRoutine implements CountDownChronOwner {


    ActivityPrincipal principal;
    MediaPlayer mp;

    private int actualNumberOfLoops = 0;
    private int actualNumberOfExercises = 0;
    private Status status = Status.STOPPED;

    private CountDown cd;

    private boolean isPaused = false;

    public FunctionalRoutine(ActivityPrincipal principal) {
        this.principal = principal;
    }

    @Override
    public TextView getMinutesText() {
        return principal.getMinutesText();
    }

    @Override
    public TextView getSecondsText() {
        return principal.getSecondsText();
    }

    @Override
    public TextView getCentisecondsText() {
        return principal.getCentisecondsText();
    }

    @Override
    public RoutineConfig getRoutineConfig() {
        return principal.getRoutineConfig();
    }

    @Override
    public void onFinish() {
        if (status == Status.EXERCISE) {
            MediaPlayer mp = MediaPlayer.create(principal, R.raw.bell);
            mp.start();
        }

        onStart();
    }

    public void onStart() {
        switch (status) {
            case STOPPED:
                actualNumberOfLoops++;
                actualNumberOfExercises++;

                principal.setNumberOfLoops(actualNumberOfLoops);
                principal.setNumberOfExercies(actualNumberOfExercises);

                status = Status.EXERCISE;

                principal.setBackgroundColor(status.getCor());

                mp = MediaPlayer.create(principal, R.raw.whistle);
                mp.start();

                cd = new CountDown(this, principal.getExerciseTime(), 10);
                cd.start();

                break;
            case EXERCISE:
                if (isPaused) {
                    cd = new CountDown(this, getCurrentChronInMillis(), 10);

                    isPaused = false;
                } else {
                    if (actualNumberOfExercises == principal.getNumberOfExercises()) {
                        if (actualNumberOfLoops == principal.getNumberOfLoops()) {
                            getCentisecondsText().setText("00");
                            break;
                        }

                        status = Status.REST;

                        principal.setBackgroundColor(status.getCor());

                        cd = new CountDown(this, principal.getRestTime(), 10);

                    } else {
                        status = Status.PREPARE;

                        principal.setBackgroundColor(status.getCor());

                        cd = new CountDown(this, principal.getPrepareTime(), 10);
                    }
                }

                cd.start();

                break;
            case PREPARE:
                if (isPaused) {
                    cd = new CountDown(this, getCurrentChronInMillis(), 10);

                    isPaused = false;
                } else {
                    actualNumberOfExercises++;

                    principal.setNumberOfExercies(actualNumberOfExercises);

                    status = Status.EXERCISE;

                    principal.setBackgroundColor(status.getCor());

                    mp = MediaPlayer.create(principal, R.raw.whistle);
                    mp.start();

                    cd = new CountDown(this, principal.getExerciseTime(), 10);
                }

                cd.start();

                break;
            case REST:
                if (isPaused) {
                    cd = new CountDown(this, getCurrentChronInMillis(), 10);

                    isPaused = false;
                } else {
                    actualNumberOfLoops++;
                    actualNumberOfExercises = 1;

                    principal.setNumberOfLoops(actualNumberOfLoops);
                    principal.setNumberOfExercies(actualNumberOfExercises);

                    status = Status.EXERCISE;

                    principal.setBackgroundColor(status.getCor());

                    mp = MediaPlayer.create(principal, R.raw.whistle);
                    mp.start();

                    cd = new CountDown(this, principal.getExerciseTime(), 10);
                }

                cd.start();

                break;
            default:
                break;

        }
    }

    public void onPause() {
        if (cd != null) {
            if (isPaused) {
                onStart();
            } else {
                cd.cancel();

                isPaused = true;
            }
        }
    }

    private Long getCurrentChronInMillis() {
        long actualMinutesInMillis = Long.parseLong(getMinutesText().getText().toString()) * 60 * 1000;
        long actualSecondsInMillis = Long.parseLong(getSecondsText().getText().toString()) * 1000;
        long actualCeentisecondsInMillis = Long.parseLong(getCentisecondsText().getText().toString()) * 10;

        return actualCeentisecondsInMillis + actualMinutesInMillis + actualSecondsInMillis;
    }
}

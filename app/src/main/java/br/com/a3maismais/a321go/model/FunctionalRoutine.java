package br.com.a3maismais.a321go.model;

import android.widget.TextView;

import br.com.a3maismais.a321go.activity.ActivityPrincipal;

/**
 * Created by fred on 04/05/17.
 */

public class FunctionalRoutine implements CountDownChronOwner {


    ActivityPrincipal principal;

    private int actualNumberOfLoops = 0;
    private int actualNumberOfExercises = 0;
    private Status status = Status.STOPPED;

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
        onStart();
    }

    public void onStart() {
        CountDown cd;

        switch (status) {
            case STOPPED:
                actualNumberOfLoops++;
                actualNumberOfExercises++;
                status = Status.EXERCISE;

                principal.setBackgroundColor(status.getCor());

                cd = new CountDown(this, principal.getExerciseTime(), 10);
                cd.start();

                break;
            case EXERCISE:
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

                cd.start();

                break;
            case PREPARE:
                actualNumberOfExercises++;
                status = Status.EXERCISE;

                principal.setBackgroundColor(status.getCor());

                cd = new CountDown(this, principal.getExerciseTime(), 10);
                cd.start();

                break;
            case REST:
                actualNumberOfLoops++;
                actualNumberOfExercises = 1;
                status = Status.EXERCISE;

                principal.setBackgroundColor(status.getCor());

                cd = new CountDown(this, principal.getExerciseTime(), 10);
                cd.start();

                break;
            default:
                break;

        }
    }
}

package br.com.a3maismais.a321go.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import br.com.a3maismais.a321go.R;
import br.com.a3maismais.a321go.model.CountDownChronOwner;
import br.com.a3maismais.a321go.model.CountDownLogo;
import br.com.a3maismais.a321go.model.FunctionalRoutine;
import br.com.a3maismais.a321go.model.RoutineConfig;
import br.com.a3maismais.a321go.model.Status;

public class ActivityPrincipal extends AppCompatActivity implements CountDownChronOwner {

    final static String START = "START";
    final static String PAUSE = "PAUSE";

    RoutineConfig config;

    TextView numberExecutedCicles;
    TextView numberExecutedExercises;

    TextView minutesText;
    TextView secondText;
    TextView centisecondsText;

    GridLayout background;

    final FunctionalRoutine fr = new FunctionalRoutine(ActivityPrincipal.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_3_2_1_go);

        final Button startButton = (Button) findViewById(R.id.start_pause_button);
        Button settingButton = (Button) findViewById(R.id.settings_stop_button);

        numberExecutedCicles = (TextView) findViewById(R.id.number_executed_cicles);
        numberExecutedExercises = (TextView) findViewById(R.id.number_executed_exercises);

        minutesText = (TextView) findViewById(R.id.minutes_text);
        secondText = (TextView) findViewById(R.id.second_text);
        centisecondsText = (TextView) findViewById(R.id.centisecond_text);

        background = (GridLayout) findViewById(R.id.background_chron);
        background.setBackgroundColor(Status.STOPPED.getCor());

        config = (RoutineConfig) getIntent().getSerializableExtra(RoutineConfig.CONFIG_NAME);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startButton.getText().equals(START)) {

                    CountDownLogo cdl = new CountDownLogo(ActivityPrincipal.this, fr, 5000l, 1000l);

                    cdl.start();
                    startButton.setText(PAUSE);
                } else {
                    fr.onPause();
                    startButton.setText(START);
                }

            }
        });

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public int getNumberOfLoops() {
        if (config == null) {
            return 0;
        } else {
            return config.getNumberOfLoops();
        }
    }

    public void setNumberOfLoops(int loopNumber) {
        numberExecutedCicles. setText(String.valueOf(loopNumber));
    }

    public void setNumberOfExercies(int numberOfExercies) {
        numberExecutedExercises.setText(String.valueOf(numberOfExercies));
    }

    public int getNumberOfExercises() {
        if (config == null) {
            return 0;
        } else {
            return config.getNumberOfExercises();
        }
    }

    public Long getExerciseTime() {
        return config.getExerciseTime();
    }

    public Long getPrepareTime() {
        return config.getPrepareTime();
    }

    public Long getRestTime() {
        return config.getRestTime();
    }

    public void setBackgroundColor(int backgroundColor) {
        this.background.setBackgroundColor(backgroundColor);
    }

    @Override
    public TextView getMinutesText() {
        return minutesText;
    }

    @Override
    public TextView getSecondsText() {
        return secondText;
    }

    @Override
    public TextView getCentisecondsText() {
        return centisecondsText;
    }

    @Override
    public RoutineConfig getRoutineConfig() {
        return null;
    }

    @Override
    public void onFinish() {

    }
}

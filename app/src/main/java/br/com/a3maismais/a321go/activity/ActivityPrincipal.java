package br.com.a3maismais.a321go.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import br.com.a3maismais.a321go.R;
import br.com.a3maismais.a321go.model.CountDown;
import br.com.a3maismais.a321go.model.CountDownChronOwner;
import br.com.a3maismais.a321go.model.RoutineConfig;

public class ActivityPrincipal extends AppCompatActivity implements CountDownChronOwner {

    RoutineConfig config;

    TextView numberExecutedCicles;
    TextView numberExecutedExercises;
    TextView executedExerciseTime;
    TextView executedRestTime;

    TextView minutesText;
    TextView secondText;
    TextView centisecondsText;

    GridLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        Button startButton = (Button) findViewById(R.id.start_button);
        Button settingButton = (Button) findViewById(R.id.settings_button);
        Button pauseButton = (Button) findViewById(R.id.pause_button);

        numberExecutedCicles = (TextView) findViewById(R.id.number_executed_cicles);
        numberExecutedExercises = (TextView) findViewById(R.id.number_executed_exercises);
        executedExerciseTime = (TextView) findViewById(R.id.executed_exercise_time);
        executedRestTime = (TextView) findViewById(R.id.executed_rest_time);

        minutesText = (TextView) findViewById(R.id.minutes_text);
        secondText = (TextView) findViewById(R.id.second_text);
        centisecondsText = (TextView) findViewById(R.id.centisecond_text);

        background = (GridLayout) findViewById(R.id.background_chron);

        config = (RoutineConfig) getIntent().getSerializableExtra(RoutineConfig.CONFIG_NAME);

        final CountDown cd = new CountDown(this, config.getExerciseTime(), 10);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cd.start();
            }
        });

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

    public void setNumberOfExercies(int numberOfExercies) {
        numberExecutedExercises.setText(String.valueOf(numberOfExercies));
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

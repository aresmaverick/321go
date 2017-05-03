package br.com.a3maismais.a321go.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.a3maismais.a321go.R;
import br.com.a3maismais.a321go.model.RoutineConfig;

/**
 * Created by fred on 02/05/17.
 */

public class ActivitySettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        Button nextButton = (Button) findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoutineConfig config = getConfigFromScreen(ActivitySettings.this);

                Intent intent = new Intent(ActivitySettings.this, ActivityPrincipal.class);

                intent.putExtra(RoutineConfig.CONFIG_NAME, config);

                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private RoutineConfig getConfigFromScreen(Activity activity) {
        EditText numberCicles = (EditText) findViewById(R.id.number_cicles);
        EditText numberActivity = (EditText) findViewById(R.id.number_activity);
        EditText timeActivity = (EditText) findViewById(R.id.time_activity);
        EditText timePrepare = (EditText) findViewById(R.id.time_prepare);
        EditText timeRest = (EditText) findViewById(R.id.time_rest);


        Integer numberLoops = Integer.parseInt(numberCicles.getText().toString());
        Integer numberExercises = Integer.parseInt(numberActivity.getText().toString());
        Long exerciseTime = Long.parseLong(timeActivity.getText().toString());
        Long prepareTime = Long.parseLong(timePrepare.getText().toString());
        Long restTime = Long.parseLong(timeRest.getText().toString());

        return new RoutineConfig(numberLoops, numberExercises, exerciseTime, prepareTime, restTime);
    }
}

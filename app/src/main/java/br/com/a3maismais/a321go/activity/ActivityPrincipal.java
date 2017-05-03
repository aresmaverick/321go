package br.com.a3maismais.a321go.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.a3maismais.a321go.R;
import br.com.a3maismais.a321go.model.RoutineConfig;

public class ActivityPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        Button startButton = (Button) findViewById(R.id.start_button);
        Button settingButton = (Button) findViewById(R.id.settings_button);
        Button pauseButton = (Button) findViewById(R.id.pause_button);

        RoutineConfig config = (RoutineConfig) getIntent().getSerializableExtra(RoutineConfig.CONFIG_NAME);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
}

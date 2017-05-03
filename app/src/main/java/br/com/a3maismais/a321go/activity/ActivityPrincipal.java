package br.com.a3maismais.a321go.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.a3maismais.a321go.R;
import br.com.a3maismais.a321go.model.RoutineConfig;

public class ActivityPrincipal extends AppCompatActivity {



    //TODO
    RoutineConfig config = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        Button settingButton = (Button) findViewById(R.id.settings_button);

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityPrincipal.this, ActivitySettings.class);
                intent.putExtra(RoutineConfig.CONFIG_NAME, config);
                startActivity(intent);
            }
        });
    }
}

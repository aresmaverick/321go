package br.com.a3maismais.a321go.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import br.com.a3maismais.a321go.R;

public class LoopNumberAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loop_number_acitivity);

        Spinner loopNumberSpinner = (Spinner) findViewById(R.id.loop_number_spinner);

        List<String> conteudo = new ArrayList<String>();
        conteudo.add("00");
        conteudo.add("01");
        conteudo.add("02");
        conteudo.add("03");
        conteudo.add("04");
        conteudo.add("05");
        conteudo.add("06");
        conteudo.add("07");
        conteudo.add("08");
        conteudo.add("09");
        conteudo.add("10");

        ArrayAdapter<String> spinnerData = new ArrayAdapter<String>(this, R.layout.spinner_content_line, conteudo);

        loopNumberSpinner.setAdapter(spinnerData);

        Button nextButton = (Button) findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoopNumberAcitivity.this, ExerciseNumberActivity.class);
                startActivity(intent);
            }
        });
    }
}

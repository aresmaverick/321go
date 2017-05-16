package br.com.a3maismais.a321go.activity;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.NumberPicker;
import android.widget.Toast;

import br.com.a3maismais.a321go.R;
import br.com.a3maismais.a321go.br.com.a3maismais.components.OnSwipeTouchListener;
import br.com.a3maismais.a321go.br.com.a3maismais.components.SwipeableElement;

public class ExerciseNumberActivity extends AppCompatActivity implements SwipeableElement {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_number_activity);

        NumberPicker np = (NumberPicker) findViewById(R.id.number_picker);

        //Populate NumberPicker values from minimum and maximum value range
        //Set the minimum value of NumberPicker
        np.setMinValue(0);
        //Specify the maximum value/number of NumberPicker
        np.setMaxValue(10);

        //Gets whether the selector wheel wraps when reaching the min/max value.
        np.setWrapSelectorWheel(true);

        //Set a value change listener for NumberPicker
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                Log.i("tag", "Number picker value: " + newVal);
            }
        });

        GridLayout body = (GridLayout) findViewById(R.id.body);

        body.setOnTouchListener(new OnSwipeTouchListener(this));
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onSwipeRight() {
        Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSwipeLeft() {
        Toast.makeText(this, "Left", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSwipeBottom() {
        Toast.makeText(this, "Bottom", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSwipeTop() {
        Toast.makeText(this, "top", Toast.LENGTH_SHORT).show();
    }
}

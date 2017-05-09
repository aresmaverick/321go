package br.com.a3maismais.a321go.model;

import android.widget.TextView;

/**
 * Created by fred on 09/05/17.
 */

public interface CountDownChronOwner {

    TextView getMinutesText();
    TextView getSecondsText();
    TextView getCentisecondsText();

    RoutineConfig getRoutineConfig();
    void onFinish();

}

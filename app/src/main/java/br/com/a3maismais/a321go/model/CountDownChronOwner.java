package br.com.a3maismais.a321go.model;

import android.widget.TextView;

/**
 * Created by fred on 09/05/17.
 */

public interface CountDownChronOwner {

    public TextView getMinutesText();
    public TextView getSecondsText();
    public TextView getCentisecondsText();

    public RoutineConfig getRoutineConfig();
}

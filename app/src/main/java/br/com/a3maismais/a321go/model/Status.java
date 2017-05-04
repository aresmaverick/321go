package br.com.a3maismais.a321go.model;

import android.graphics.Color;

/**
 * Created by fred on 27/04/17.
 */

public enum Status {

    STOPPED(Color.BLACK),
    EXERCISE(Color.GREEN),
    PREPARE(Color.YELLOW),
    REST(Color.RED);

    private final int color;

    Status(int cor) {

        this.color = cor;

    }

    public int getCor() {
        return color;
    }


}

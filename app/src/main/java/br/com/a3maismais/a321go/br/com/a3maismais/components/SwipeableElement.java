package br.com.a3maismais.a321go.br.com.a3maismais.components;

import android.content.Context;

/**
 * Created by fred on 16/05/17.
 */

public interface SwipeableElement {

    Context getContext();
    void onSwipeRight();
    void onSwipeLeft();
    void onSwipeBottom();
    void onSwipeTop();

}

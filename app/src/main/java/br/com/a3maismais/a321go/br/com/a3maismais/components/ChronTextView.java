package br.com.a3maismais.a321go.br.com.a3maismais.components;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by fred on 15/05/17.
 */

public class ChronTextView extends android.support.v7.widget.AppCompatTextView {

    private static String FONT_NAME = "fonts/led.real-regular.ttf";

    public ChronTextView(Context context) {
        super(context);
        init();
    }

    public ChronTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ChronTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), FONT_NAME);
        setTypeface(tf, 1);
    }
}

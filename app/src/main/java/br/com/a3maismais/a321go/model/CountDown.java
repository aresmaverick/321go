package br.com.a3maismais.a321go.model;

import android.os.CountDownTimer;

import br.com.a3maismais.a321go.activity.ActivityPrincipal;

/**
 * Created by fred on 08/05/17.
 */

public class CountDown extends CountDownTimer {

    ActivityPrincipal principal;

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public CountDown(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    public CountDown(ActivityPrincipal principal, long millisInFuture, long countDownInterval) {
        this(millisInFuture, countDownInterval);
        this.principal = principal;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        this.principal.secondText.setText(String.valueOf(millisUntilFinished));
    }

    @Override
    public void onFinish() {

    }
}

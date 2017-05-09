package br.com.a3maismais.a321go.model;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by fred on 08/05/17.
 */

public class CountDown extends CountDownTimer {

    private static final int MILLIS_TO_CENTISECONDS = 10;
    private static final int MILLIS_TO_SECONDS = 1000;
    private static final int MILLIS_TO_MINUTES = 60000;

    CountDownChronOwner owner;

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

    public CountDown(CountDownChronOwner owner, long millisInFuture, long countDownInterval) {
        this(millisInFuture, countDownInterval);
        this.owner = owner;
    }

    //TODO - First implementation will re-calculate all chronometer's field.
    @Override
    public void onTick(long millisUntilFinished) {
        long minutes = millisUntilFinished / MILLIS_TO_MINUTES;
        long seconds = (millisUntilFinished % MILLIS_TO_MINUTES) / MILLIS_TO_SECONDS;
        long centiseconds = ((millisUntilFinished % MILLIS_TO_MINUTES) % MILLIS_TO_SECONDS) / MILLIS_TO_CENTISECONDS;

        TextView minutesText = owner.getMinutesText();
        TextView secondsText = owner.getSecondsText();
        TextView centisecondsText = owner.getCentisecondsText();

        minutesText.setText(String.valueOf(minutes));
        secondsText.setText(String.valueOf(seconds));
        centisecondsText.setText(String.valueOf(centiseconds));
    }

    @Override
    public void onFinish() {
        owner.onFinish();
    }
}

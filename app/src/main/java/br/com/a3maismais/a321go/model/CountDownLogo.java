package br.com.a3maismais.a321go.model;

import android.os.CountDownTimer;
import android.view.View;

import br.com.a3maismais.a321go.R;
import br.com.a3maismais.a321go.activity.ActivityPrincipal;

/**
 * Created by fred on 11/05/17.
 */

public class CountDownLogo extends CountDownTimer {

    private FunctionalRoutine fr;
    private ActivityPrincipal principal;

    View threeView;
    View twoView;
    View oneView;
    View goView;


    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public CountDownLogo(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    public CountDownLogo(ActivityPrincipal principal, FunctionalRoutine fr, long millisInFuture, long countDownInterval) {
        this(millisInFuture, countDownInterval);

        this.principal = principal;
        this.fr = fr;

        threeView = principal.findViewById(R.id.three);
        twoView = principal.findViewById(R.id.two);
        oneView = principal.findViewById(R.id.one);
        goView = principal.findViewById(R.id.go);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        if (millisUntilFinished >= 4000) {
            threeView.setVisibility(View.VISIBLE);
        } else if (millisUntilFinished <= 4000 && millisUntilFinished >= 3000) {
            threeView.setVisibility(View.GONE);
            twoView.setVisibility(View.VISIBLE);
        } else if (millisUntilFinished <= 3000 && millisUntilFinished >= 2000) {
            twoView.setVisibility(View.GONE);
            oneView.setVisibility(View.VISIBLE);
        } else if (millisUntilFinished <= 2000 && millisUntilFinished >= 1000) {
            oneView.setVisibility(View.GONE);
            goView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onFinish() {
        goView.setVisibility(View.GONE);

        fr.onStart();
    }
}

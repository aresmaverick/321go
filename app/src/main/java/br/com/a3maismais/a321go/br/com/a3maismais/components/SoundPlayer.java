package br.com.a3maismais.a321go.br.com.a3maismais.components;

import android.app.Activity;
import android.media.MediaPlayer;

import br.com.a3maismais.a321go.R;

/**
 * Created by fred on 15/05/17.
 */

public class SoundPlayer {

    public static void playBell(Activity activity) {
        MediaPlayer mp = MediaPlayer.create(activity, R.raw.bell);
        mp.start();
    }

    public static void playWhistle(Activity activity) {
        MediaPlayer mp = MediaPlayer.create(activity, R.raw.whistle);
        mp.start();
    }
}

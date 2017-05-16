package br.com.a3maismais.a321go.br.com.a3maismais.components;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by fred on 15/05/17.
 */

public class OnSwipeTouchListener implements View.OnTouchListener {

    private final GestureDetector gestureDetector;
    private final SwipeableElement swipeableElement;

    public OnSwipeTouchListener (SwipeableElement sElement) {
        this.swipeableElement = sElement;
        gestureDetector = new GestureDetector(this.swipeableElement.getContext(), new GestureListener());
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;

            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();

                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            swipeableElement.onSwipeRight();
                        } else {
                            swipeableElement.onSwipeLeft();
                        }

                        result = true;
                    }
                } else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        swipeableElement.onSwipeBottom();
                    } else {
                        swipeableElement.onSwipeTop();
                    }

                    return true;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            return result;
        }
    }
}

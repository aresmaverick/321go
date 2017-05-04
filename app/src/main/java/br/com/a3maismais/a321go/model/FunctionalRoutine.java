package br.com.a3maismais.a321go.model;

import br.com.a3maismais.a321go.activity.ActivityPrincipal;

/**
 * Created by fred on 04/05/17.
 */

public class FunctionalRoutine implements ScheduledTask {

    private ActivityPrincipal principal;
    private Chron chron;

    private int numberOfLoops;
    private int numberOfExercises;
    private Status status = Status.STOPPED;

    public FunctionalRoutine(ActivityPrincipal principal) {
        this.principal = principal;
    }

    public void start() {

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    chron = new ChronImpl();

                    for (int loopCount = 1; loopCount <= principal.getNumberOfLoops(); loopCount++) {
                        numberOfLoops = loopCount;

                        for (int exerciseCount = 1; exerciseCount <= principal.getNumberOfExercises(); exerciseCount++) {
                            numberOfExercises = exerciseCount;

                            updateActivity();

                            startExercise();

                            boolean isExerciseListCompleted = exerciseCount == principal.getNumberOfExercises();

                            if (!isExerciseListCompleted) {
                                startPrepare();
                            }
                        }

                        boolean isLoopListCompleted = loopCount == principal.getNumberOfLoops();

                        if (!isLoopListCompleted) {
                            startRest();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }

    @Override
    public void executeScheduled() {
        updateActivity();
    }

    private void updateActivity() {
        principal.setNumberOfLoops(numberOfLoops);
        principal.setNumberOfExercies(numberOfExercises);
        principal.setBackgroundColor(status.getCor());
    }

    private void startExercise() {
        this.setStatus(Status.EXERCISE);
        chron.countDown(this, principal.getExerciseTime());
    }

    private void startPrepare() {
        this.setStatus(Status.PREPARE);
        chron.countDown(this, principal.getPrepareTime());
    }

    private void startRest() {
        this.setStatus(Status.REST);
        chron.countDown(this, principal.getRestTime());
    }

    private void setStatus(Status status) {
        this.status = status;
    }
}

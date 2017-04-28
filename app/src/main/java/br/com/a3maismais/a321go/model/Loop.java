package br.com.a3maismais.a321go.model;

/**
 * Created by fred on 27/04/17.
 */

public class Loop {

    Long numberOfLoops;
    Long numberOfExercises;

    Long exerciseTime;
    Long prepareTime;
    Long restTime;

    Status status;

    Chron chron;

    public Loop(Chron chron) {
        this.chron = chron;
    }

    public Long getNumberOfLoops() {
        return numberOfLoops;
    }

    public Long getNumberOfExercises() {
        return numberOfExercises;
    }

    public Long getExerciseTime() {
        return exerciseTime;
    }

    public Long getPrepareTime() {
        return prepareTime;
    }

    public Long getRestTime() {
        return restTime;
    }

    public Status getStatus() {
        return status;
    }

    public void startExercise() {
        setStatus(Status.Exercise);
        chron.countDown(exerciseTime);
    }

    public void startPrepare() {
        setStatus(Status.Prepare);
        chron.countDown(prepareTime);
    }

    public void startRest() {
        setStatus(Status.Rest);
        chron.countDown(restTime);
    }

    public void startLoop() {
        for (int i = 0; i < numberOfExercises; i++) {
            startPrepare();
            startExercise();
            startRest();
        }
    }

    private void setStatus(Status status) {
        this.status = status;
    }
}

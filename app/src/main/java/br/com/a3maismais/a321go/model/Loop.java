package br.com.a3maismais.a321go.model;

/**
 * Created by fred on 27/04/17.
 */

public class Loop {

    private Integer numberOfExercises;
    private Long exerciseTime;
    private Long prepareTime;
    private Long restTime;
    private Status status;
    private Chron chron;

    public Loop(RoutineConfig config, Chron cronometro) {
        this.numberOfExercises = config.getNumberOfExercises();
        this.exerciseTime = config.getExerciseTime();
        this.prepareTime = config.getPrepareTime();
        this.restTime = config.getRestTime();
        this.chron = cronometro;
    }

    public void startLoop() {
        System.err.println(">>>>Starting a new Loop");

        for (int i = 0; i < this.getNumberOfExercises(); i++) {
            startExercise();
        }
        System.err.println("<<<<Finished!");

        startRest();

    }

    public void startExercise() {
        System.out.println("Starting a new exercise!");
        System.out.println("Chron launched: " + this.getExerciseTime());

        this.setStatus(Status.EXERCISE);
        System.out.println(this.status.getCor());

        chron.countDown(this.getExerciseTime());

        startPrepare();
    }

    public void startPrepare() {
        System.out.println("Changing exercise");

        this.setStatus(Status.PREPARE);
        System.out.println(this.status.getCor());

        System.out.println("Chron launched: " + this.getPrepareTime() );

        chron.countDown(prepareTime);
    }

    public void startRest() {

        System.out.println("It's time to some rest");

        this.setStatus(Status.REST);
        System.out.println(this.status.getCor());

        System.out.println("Chron launched: " + this.getRestTime() );
        chron.countDown(this.getRestTime() );
    }

    public Integer getNumberOfExercises() {
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

    private void setStatus(Status status) {
        System.out.println("Status alterado de " + this.status + " para " + status);
        this.status = status;
    }
}


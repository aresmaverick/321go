package br.com.a3maismais.a321go.model;

/**
 * Created by fred on 27/04/17.
 */

public class Loop {

    Integer numberOfExercises;
    Long exerciseTime;
    Long prepareTime;
    Long restTime;
    Status status;
    Chron chron;

    public Loop(RotineConfig config, Chron cronometro) {
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
        System.err.println("<<<<Ciclo finalizado!");

        startRest();

    }

    public void startExercise() {
        System.out.println("Comecei a atividade!");
        System.out.println("Cronometro iniciado: " + this.getExerciseTime());

        this.setStatus(Status.EXERCISE);
        System.out.println(this.status.getCor());

        chron.countDown(this.getExerciseTime());

        startPrepare();
    }

    public void startPrepare() {
        System.out.println("Comecei a troca!");

        this.setStatus(Status.PREPARE);
        System.out.println(this.status.getCor());

        System.out.println("Cronometro iniciado: " + this.getPrepareTime() );

        chron.countDown(prepareTime);
    }

    public void startRest() {
        this.setStatus(Status.REST);
        System.out.println(this.status.getCor());
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


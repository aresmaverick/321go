package br.com.a3maismais.a321go.model;

import java.io.Serializable;

/**
 * Created by ricardo on 5/2/17.
 */

public class RoutineConfig implements Serializable {

    public static final String CONFIG_NAME="br.com.a3maismais.a321go.model.RoutineConfig";

    private Integer numberOfLoops;
    private Integer numberOfExercises;
    private Long exerciseTime;
    private Long prepareTime;
    private Long restTime;
    private Status status;

    public RoutineConfig () {
        this.numberOfLoops = 1;
        this.numberOfExercises = 2;
        this.exerciseTime = 60000L;
        this.prepareTime = 30000L;
        this.restTime = 180000L;
    }

    public RoutineConfig(Integer numberOfLoops, Integer numberOfExercises, Long exerciseTime, Long prepareTime,
                         Long restTime) {

        this.numberOfLoops = numberOfLoops;
        this.numberOfExercises = numberOfExercises;
        this.exerciseTime = exerciseTime;
        this.prepareTime = prepareTime;
        this.restTime = restTime;
    }

    public Integer getNumberOfLoops() {
        return numberOfLoops;
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

}

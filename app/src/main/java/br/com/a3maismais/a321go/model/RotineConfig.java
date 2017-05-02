package br.com.a3maismais.a321go.model;

/**
 * Created by ricardo on 5/2/17.
 */

public class RotineConfig {

    private Integer numberOfLoops;
    private Integer numberOfExercises;
    private Long exerciseTime;
    private Long prepareTime;
    private Long restTime;
    private Status status;

    public RotineConfig(Integer numberOfLoops, Integer numberOfExercises, Long exerciseTime, Long prepareTime,
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

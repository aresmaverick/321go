package br.com.a3maismais.a321go.model;

/**
 * Created by fred on 27/04/17.
 */

public interface Chron {
    public void countDown(Long millis);
    public void countDown(ScheduledTask scheduledTask, Long millis);
}

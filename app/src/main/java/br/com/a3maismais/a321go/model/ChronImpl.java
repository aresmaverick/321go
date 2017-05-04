package br.com.a3maismais.a321go.model;

/**
 * Created by ricardo on 5/2/17.
 */

public class ChronImpl implements Chron {

    @Override
    public void countDown(Long millis) {

        long tempoEmSegundos = millis / 1000;

        while (tempoEmSegundos > 0) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tempoEmSegundos--);
        }



    }

    @Override
    public void countDown(ScheduledTask scheduledTask, Long millis) {
        try {
            Thread.sleep(millis);
            scheduledTask.executeScheduled();
        } catch (Exception e) {
            throw new RuntimeException("Could not run the task from " + scheduledTask.getClass());
        }
    }
}

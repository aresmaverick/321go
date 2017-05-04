package br.com.a3maismais.a321go.model;

/**
 * Created by ricardo on 5/2/17.
 */

public class FunctionalRotine implements ScheduledTask {

    public FunctionalRotine(RoutineConfig config) {

        Chron cronometro = new ChronImpl();

        System.out.println(Status.STOPPED.getCor());

        int ciclos = config.getNumberOfLoops();
        while (ciclos > 0) {
            Loop ciclo = new Loop(config, cronometro);
            ciclo.startLoop();
            ciclos--;
        }

        System.out.println(Status.STOPPED.getCor());

    }

    @Override
    public void executeScheduled() {

    }
}

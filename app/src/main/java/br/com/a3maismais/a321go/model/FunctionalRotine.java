package br.com.a3maismais.a321go.model;

/**
 * Created by ricardo on 5/2/17.
 */

public class FunctionalRotine {

    public FunctionalRotine(RotineConfig config) {

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

    public static void main(String[] args) {

        RotineConfig config = new RotineConfig(2, 4, 5000L, 3000L, 10000L);
        new FunctionalRotine(config);

    }

}

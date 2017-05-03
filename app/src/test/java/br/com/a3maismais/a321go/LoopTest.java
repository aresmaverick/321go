package br.com.a3maismais.a321go;

import org.junit.Test;

import br.com.a3maismais.a321go.model.ChronImpl;
import br.com.a3maismais.a321go.model.Loop;
import br.com.a3maismais.a321go.model.RoutineConfig;

/**
 * Created by ricardo on 5/3/17.
 */

public class LoopTest {

    @Test
    public void completeRunTest(){

        Loop loop = new Loop(new RoutineConfig(), new ChronImpl());

        loop.startLoop();

    }

}

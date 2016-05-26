package org.academiadecodigo.spaceimpact;

/**
 * Created by codecadet on 25/05/16.
 */
public class Test {

    public static void main(String[] args) {
        //TEST STUFF HERE

        Game g = new Game();
        g.init();

        try {

            g.start();

        } catch (InterruptedException ex){

            System.out.println("vai po caralho");
        }
    }
}

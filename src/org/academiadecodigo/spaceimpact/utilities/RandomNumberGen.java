package org.academiadecodigo.spaceimpact.utilities;

/**
 * Created by codecadet on 06/05/16.
 */
public class RandomNumberGen {

    public static int generate(int max){
        return generate(0, max);
    }

    public static int generate(int min, int max){
        return (int) Math.floor((Math.random() * (max - min)) + min);
    }

}


package org.academiadecodigo.spaceimpact.utilities;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by codecadet on 05/06/16.
 */
public class SoundHandler {

    private static InputStream in;
    private static AudioStream as;

    public static void playShootingSound(){

        try {

            in = new FileInputStream("resources/sounds/shoot.wav");
            as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }

    }

    public static void playDestroyEnemyShipSound(){

        try {

            in = new FileInputStream("resources/sounds/destroy.wav");
            as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }

    }

    public static void playGameSound(){

        try {

            in = new FileInputStream("resources/sounds/game.wav");
            as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }

    }

    public static void playPlayerHitSound(){

        try {

            in = new FileInputStream("resources/sounds/playerhit.wav");
            as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }

    }

    public static void playSpiderDeathSound(){

        try {

            in = new FileInputStream("resources/sounds/deadspider.wav");
            as = new AudioStream(in);

            AudioPlayer.player.start(as);

        } catch (Exception e) {
            System.out.println("file not found.");
        }

    }

}

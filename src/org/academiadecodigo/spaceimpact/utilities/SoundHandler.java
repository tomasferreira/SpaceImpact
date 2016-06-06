package org.academiadecodigo.spaceimpact.utilities;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by codecadet on 05/06/16.
 */
public class SoundHandler {

    private static InputStream in;
    private static AudioStream as;

    public static void playShootingSound() {

//        try {
//
//            in = new FileInputStream("resources/sounds/shoot.wav");
//            as = new AudioStream(in);
//
//            AudioPlayer.player.start(as);
//
//        } catch (Exception e) {
//            System.out.println("file not found.");
//        }

        Sound.play("resources/sounds/shoot.wav");

    }

    public static void playDestroyEnemyShipSound() {

//        try {
//
//            in = new FileInputStream("resources/sounds/destroy.wav");
//            as = new AudioStream(in);
//
//            AudioPlayer.player.start(as);
//
//        } catch (Exception e) {
//            System.out.println("file not found.");
//        }

        Sound.play("resources/sounds/destroy.wav");

    }

    public static void playGameSound() {

//        try {
//
//            in = new FileInputStream("resources/sounds/game.wav");
//            as = new AudioStream(in);
//
//            AudioPlayer.player.start(as);
//
//        } catch (Exception e) {
//            System.out.println("file not found.");
//        }

        Sound.play("resources/sounds/game.wav");

    }

    public static void playPlayerHitSound() {

//        try {
//
//            in = new FileInputStream("resources/sounds/playerhit.wav");
//            as = new AudioStream(in);
//
//            AudioPlayer.player.start(as);
//
//        } catch (Exception e) {
//            System.out.println("file not found.");
//        }

        Sound.play("resources/sounds/playerhit.wav");

    }

    public static void playSpiderDeathSound() {

//        String pathStr = "resources/sounds/deadspider.wav";
//        URL soundURL = SoundHandler.class.getResource(pathStr);
//
//
//        try {
//            if (soundURL == null) {
//                // load sound from source code
//
//            File file = new File(pathStr);
//            soundURL = file.toURI().toURL();
//            InputStream inputStream = AudioSystem.getAudioInputStream(soundURL);
//            file.open(inputStream);
//            }
//
//            AudioPlayer.player.start(as);
//
//        } catch (Exception e) {
//            System.out.println("file not found.");
//        }

        Sound.play("resources/sounds/deadspider.wav");
    }

    // load sound from jar


}

package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.spaceimpact.gameobjects.KeyToDirectionMapper;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileType;
import org.academiadecodigo.spaceimpact.representable.Representable;
import org.academiadecodigo.spaceimpact.utilities.SoundHandler;

import java.util.*;


/**
 * @author Tomás Ferreira
 * @author Ana Tomás
 * @author Rodolfo Matos
 */

public class PlayerShip extends Spaceship implements KeyboardHandler {


    private Keyboard k;
    private Direction[] directions;
    private Map<Integer, Boolean> keysPressed = new HashMap<>(5);
    private boolean isPaused = true;
    private boolean shootPressed;

    public boolean isPaused() {
        return isPaused;
    }

    /**
     * Constructor that calls the keyEvents method, method that initializes keyboard input
     *
     * @param representation   - his representation
     * @param speed            - speed of the spaceship
     * @param shootPeriodicity - frequency of shooting
     */

    public PlayerShip(Representable representation, int speed, int shootPeriodicity, int lives) {

        super(representation, speed, shootPeriodicity, lives);
        keyEvents();
    }


    /**
     * Method that shoots two projectiles, can only shoot is canShoot() returns true
     */

    @Override
    public void shoot() {

        if (isPaused){
            return;
        }

        if(!shootPressed){
            return;
        }

        if (!canShoot()) {
            setShootCounter(getShootCounter() + 1);
            return;
        }

        getProjectileHandler().getNewPlayerProjectile(getRepresentation().getMaxX(), getRepresentation().getY());
        getProjectileHandler().getNewPlayerProjectile(getRepresentation().getMaxX(), getRepresentation().getMaxY() - ProjectileType.PLAYER.getProjectileHeight());
        setShootCounter(0);
        SoundHandler.playShootingSound();
        shootPressed = false;
    }

    /**
     * Method that moves the spaceship, can only move if canMove() returns true
     */

    @Override
    public void move() {

        if (isPaused){
            return;
        }

        if (!canMove()) {
            setCounter(getCounter() + 1);
            return;
        }

        accelerate(directions);
        setCounter(0);
    }

    /**
     * Method that handles the pressed keys based on the user input
     */

    public void keyMapHandler() {

        List<Integer> keys = new ArrayList<>(keysPressed.keySet());

        directions = new Direction[keys.size()];
        int n = 0;

        for (Integer key : keys) {

            if (!keysPressed.get(key)) {
                continue;
            }

            if (key == KeyboardEvent.KEY_E) {
                System.exit(0);
            }

            if (key == KeyboardEvent.KEY_P){
                if (!isPaused){
                    isPaused = true;
                    continue;
                }
            }

            if (key == KeyboardEvent.KEY_S){
                if(isPaused){
                    isPaused = false;
                    continue;
                }
            }

            if (key == KeyboardEvent.KEY_SPACE) {
                shootPressed = true;
                continue;
            }

            directions[n] = KeyToDirectionMapper.getDirection(key);
            n++;

        }
        move();
        shoot();

    }


    @Override
    public void keyReleased(KeyboardEvent e) {

        if (e.getKey() == KeyboardEvent.KEY_SPACE) {
            keysPressed.put(e.getKey(), false);
            return;
        }

        keysPressed.put(e.getKey(), false);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        if (!keysPressed.containsKey(e.getKey())) {
            return;
        }
        keysPressed.put(e.getKey(), true);
    }

    public void keyEvents() {

        k = new Keyboard(this);

        //KEY PRESSED EVENTS

        KeyboardEvent keyUp = new KeyboardEvent();
        keyUp.setKey(KeyboardEvent.KEY_UP);
        keyUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(keyUp);


        KeyboardEvent keyDown = new KeyboardEvent();
        keyDown.setKey(KeyboardEvent.KEY_DOWN);
        keyDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(keyDown);

        KeyboardEvent keyLeft = new KeyboardEvent();
        keyLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(keyLeft);

        KeyboardEvent keyRight = new KeyboardEvent();
        keyRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(keyRight);

        KeyboardEvent keySpace = new KeyboardEvent();
        keySpace.setKey(KeyboardEvent.KEY_SPACE);
        keySpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(keySpace);

        KeyboardEvent keyP = new KeyboardEvent();
        keyP.setKey(KeyboardEvent.KEY_P);
        keyP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(keyP);

        KeyboardEvent keyS = new KeyboardEvent();
        keyS.setKey(KeyboardEvent.KEY_S);
        keyS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(keyS);

        KeyboardEvent keyE = new KeyboardEvent();
        keyE.setKey(KeyboardEvent.KEY_E);
        keyE.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(keyE);

        //KEY RELEASED EVENT

        KeyboardEvent keyUpR = new KeyboardEvent();
        keyUpR.setKey(KeyboardEvent.KEY_UP);
        keyUpR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        k.addEventListener(keyUpR);

        KeyboardEvent keyDownR = new KeyboardEvent();
        keyDownR.setKey(KeyboardEvent.KEY_DOWN);
        keyDownR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        k.addEventListener(keyDownR);

        KeyboardEvent keyLeftR = new KeyboardEvent();
        keyLeftR.setKey(KeyboardEvent.KEY_LEFT);
        keyLeftR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        k.addEventListener(keyLeftR);

        KeyboardEvent keyRightR = new KeyboardEvent();
        keyRightR.setKey(KeyboardEvent.KEY_RIGHT);
        keyRightR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        k.addEventListener(keyRightR);

        KeyboardEvent keySpaceR = new KeyboardEvent();
        keySpaceR.setKey(KeyboardEvent.KEY_SPACE);
        keySpaceR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        k.addEventListener(keySpaceR);

        KeyboardEvent keyPR = new KeyboardEvent();
        keyPR.setKey(KeyboardEvent.KEY_P);
        keyPR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        k.addEventListener(keyPR);

        KeyboardEvent keySR = new KeyboardEvent();
        keySR.setKey(KeyboardEvent.KEY_S);
        keySR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        k.addEventListener(keySR);

        keysPressed.put(KeyboardEvent.KEY_LEFT, false);
        keysPressed.put(KeyboardEvent.KEY_RIGHT, false);
        keysPressed.put(KeyboardEvent.KEY_UP, false);
        keysPressed.put(KeyboardEvent.KEY_DOWN, false);
        keysPressed.put(KeyboardEvent.KEY_SPACE, false);
        keysPressed.put(KeyboardEvent.KEY_P, false);
        keysPressed.put(KeyboardEvent.KEY_S, false);
        keysPressed.put(KeyboardEvent.KEY_E, false);

    }



}

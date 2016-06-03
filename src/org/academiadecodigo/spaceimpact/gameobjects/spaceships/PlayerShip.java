package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.spaceimpact.gameobjects.KeyToDirectionMapper;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileType;
import org.academiadecodigo.spaceimpact.representable.Representable;

import java.util.*;


/**
 * Created by codecadet on 23/05/16.
 */
public class PlayerShip extends Spaceship implements KeyboardHandler {

    private Keyboard k;
    private Direction[] directions;
    private Map<Integer, Boolean> keysPressed = new HashMap<>(5);
    private int lives = 3;

    public PlayerShip(Representable representation, int speed, int shootPeriodicity) {

        super(representation, speed, shootPeriodicity);
        keyEvents();
    }

    @Override
    public void destroy() {

        if (lives == 0) {
            super.destroy();
        }
        lives--;
    }

    @Override
    public void shoot() {


        if(!canShoot()) {
            setShootCounter(getShootCounter() + 1);
            return;
        }

        getProjectileHandler().getNewPlayerProjectile(getRepresentation().getMaxX(), getRepresentation().getY());
        getProjectileHandler().getNewPlayerProjectile(getRepresentation().getMaxX(), getRepresentation().getMaxY() - ProjectileType.PLAYER.getProjectileHeight());
        setShootCounter(0);

    }

    @Override
    public void move() {

        if (!canMove()) {
            setCounter(getCounter() + 1);
            return;
        }

        accelerate(directions);
        setCounter(0);
    }

    public void keyMapHandler() {

        List<Integer> keys = new ArrayList<>(keysPressed.keySet());

        directions = new Direction[keys.size()];
        int n = 0;

        for (Integer key : keys) {

            if (!keysPressed.get(key)) {
                continue;
            }

            if (key == KeyboardEvent.KEY_SPACE) {
                shoot();
                continue;
            }

            directions[n] = KeyToDirectionMapper.getDirection(key);
            n++;

        }
        move();

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

        keysPressed.put(KeyboardEvent.KEY_LEFT, false);
        keysPressed.put(KeyboardEvent.KEY_RIGHT, false);
        keysPressed.put(KeyboardEvent.KEY_UP, false);
        keysPressed.put(KeyboardEvent.KEY_DOWN, false);
        keysPressed.put(KeyboardEvent.KEY_SPACE, false);

    }

    public int getLives() {
        return lives;
    }

}

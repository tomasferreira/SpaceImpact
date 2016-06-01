package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.KeyToDirectionMapper;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ShootingDirection;
import org.academiadecodigo.spaceimpact.representable.Representable;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by codecadet on 23/05/16.
 */
public class PlayerShip extends Spaceship implements KeyboardHandler {


    private Keyboard k;
    private Queue<KeyboardEvent> eventQueue;
    private Projectile p;


    private boolean shooting;


    public PlayerShip(Representable representation, int maxSpeed) {

        super(representation, maxSpeed);
        keyEvents();
        setCurrentDirection(Direction.WEST);
        eventQueue = new LinkedList<>();
    }

    @Override
    public void shoot() {

        getProjectileHandler().getNewPlayerProjectile(getRepresentation().getMaxX(), getRepresentation().getY() + ((getRepresentation().getMaxY() - getRepresentation().getY()) / 2));

    }

    @Override
    public void move() {

        accelerate(getCurrentDirection());



        setCounter(0);
    }

    public void queueHandler() {
        if (isShooting()) {

            shoot();
        }

        for (KeyboardEvent keyboardEvent : eventQueue) {

            setCounter(getCounter() + 1);

            if (canMove()) {

                setCurrentDirection(KeyToDirectionMapper.getDirection(keyboardEvent));
                move();
            }

        }
    }


    public boolean canMove() {
        return getCounter() == getSpeed();
    }

    public boolean isShooting() {
        return shooting;
    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

        if (e.getKey() == KeyboardEvent.KEY_SPACE) {
            setShooting(false);
            return;
        }

        for (KeyboardEvent keyboardEvent : eventQueue) {
            if (keyboardEvent.getKey() == e.getKey()) {
                eventQueue.remove(keyboardEvent);
            }
        }

    }

    @Override
    public void keyPressed(KeyboardEvent e) {


        if (e.getKey() == KeyboardEvent.KEY_SPACE) {
            setShooting(true);
            return;
        }


        for (KeyboardEvent keyboardEvent : eventQueue) {
            if (keyboardEvent.getKey() == e.getKey()) {
                return;
            }
        }

        eventQueue.add(e);

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

    }
}

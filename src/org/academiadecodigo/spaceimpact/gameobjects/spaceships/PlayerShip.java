package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ShootingDirection;
import org.academiadecodigo.spaceimpact.representable.Representable;


/**
 * Created by codecadet on 23/05/16.
 */
public class PlayerShip extends Spaceship implements KeyboardHandler {


    private Keyboard k;
    private Projectile p;
    private KeyboardEvent previousEvent;


    public PlayerShip(Representable representation, int maxSpeed) {
        super(representation, maxSpeed);
        setSpeed(0);
        keyEvents();
        setCurrentDirection(Direction.WEST);
    }

    @Override
    public void shoot() {
        getProjectilelist().add((Projectile) getFactory().createProjectile(ShootingDirection.WEST, getRepresentation().getX() + getRepresentation().getWidth(), getRepresentation().getY() + (getRepresentation().getHeight() / 2)));
    }

    @Override
    public void move() {

        if(getCounter() == getSpeed()) {

            accelerate(getCurrentDirection());

            getCollisionDetector().checkCollision(this);

            for (int i = 0; i < getProjectilelist().size(); i++) {
                getProjectilelist().get(i).move();

            }

            setCounter(0);
        }

        setCounter(getCounter() + 1);
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        previousEvent = null;
        setSpeed(0);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        if (previousEvent == null) {
            previousEvent = e;
        }

        switch (e.getKey()) {

            case KeyboardEvent.KEY_DOWN:

                if (previousEvent.getKey() == KeyboardEvent.KEY_LEFT) {

                    setCurrentDirection(Direction.SOUTHWEST);

                } else if (previousEvent.getKey() == KeyboardEvent.KEY_RIGHT) {

                    setCurrentDirection(Direction.SOUTHEAST);

                } else {

                    setCurrentDirection(Direction.SOUTH);

                }

                break;

            case KeyboardEvent.KEY_UP:

                if (previousEvent.getKey() == KeyboardEvent.KEY_LEFT) {

                    setCurrentDirection(Direction.NORTHWEST);

                } else if (previousEvent.getKey() == KeyboardEvent.KEY_RIGHT) {


                    setCurrentDirection(Direction.NORTHEAST);

                } else {


                    setCurrentDirection(Direction.NORTH);

                }


                break;

            case KeyboardEvent.KEY_LEFT:

                if (previousEvent.getKey() == KeyboardEvent.KEY_UP) {

                    setCurrentDirection(Direction.SOUTHWEST);


                } else if (previousEvent.getKey() == KeyboardEvent.KEY_DOWN) {


                    setCurrentDirection(Direction.NORTHWEST);

                } else {

                    setCurrentDirection(Direction.WEST);

                }

                break;

            case KeyboardEvent.KEY_RIGHT:

                if (previousEvent.getKey() == KeyboardEvent.KEY_UP) {

                    setCurrentDirection(Direction.SOUTHEAST);

                } else if (previousEvent.getKey() == KeyboardEvent.KEY_DOWN) {

                    setCurrentDirection(Direction.NORTHEAST);

                } else {

                    setCurrentDirection(Direction.EAST);

                }
                break;

            case KeyboardEvent.KEY_SPACE:

                shoot();
                return;

        }

        previousEvent = e;
        setSpeed(getMaxSpeed());

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

    }
}

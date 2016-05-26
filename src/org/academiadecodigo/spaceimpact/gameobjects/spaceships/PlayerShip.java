package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public class PlayerShip extends Spaceship implements KeyboardHandler {


    private Keyboard k;


    public PlayerShip(Representable representation) {
        super(representation);
        keyEvents();
    }

    @Override
    public void move() {


        accelerate(getCurrentDirection(), getSpeed());
 //       getCollisionDetector().isUnSafe(this);

    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()){
            case KeyboardEvent.KEY_DOWN:
                System.out.println("down");
                setCurrentDirection(Direction.DOWN);
                break;

            case KeyboardEvent.KEY_UP:
                System.out.println("up");
                setCurrentDirection(Direction.UP);
                break;


            case KeyboardEvent.KEY_LEFT:
                System.out.println("left");
                setCurrentDirection(Direction.LEFT);
                break;

            case KeyboardEvent.KEY_RIGHT:
                System.out.println("rigth");
                setCurrentDirection(Direction.RIGHT);
                break;

        }


    }

    public void keyEvents() {

        k = new Keyboard(this);

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

    }
}

package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.representable.Representable;

import java.util.PriorityQueue;


/**
 * Created by codecadet on 23/05/16.
 */
public class PlayerShip extends Spaceship implements KeyboardHandler {


    private Keyboard k;
    private PriorityQueue<KeyboardEvent> eventQueue;
    private Projectile p;


    public PlayerShip(Representable representation, int maxSpeed) {
        super(representation, maxSpeed);
        setSpeed(0);
        keyEvents();
        setCurrentDirection(Direction.WEST);
        eventQueue = new PriorityQueue<KeyboardEvent>();
    }

    @Override
    public void shoot() {
        //getProjectilelist().add((Projectile) getFactory().createProjectile(ShootingDirection.WEST, getRepresentation().getX() + getRepresentation().getWidth(), getRepresentation().getY() + (getRepresentation().getHeight() / 2)));
    }

    @Override
    public void move() {


        queueHandler();

        if (getCounter() == getSpeed()) {

            accelerate(getCurrentDirection());

            getCollisionDetector().checkCollision(this);

            for (int i = 0; i < getProjectilelist().size(); i++) {
                getProjectilelist().get(i).move();

            }

            setCounter(0);
        }

        setCounter(getCounter() + 1);
    }

    public void queueHandler() {

        //TODO: enviar os eventos para serem tratados e escolher a direcção a partir do keytodirectionammper


        KeyboardEvent kbEvent = eventQueue.peek();



        if (isShootingKey(kbEvent)) {

            shoot();
            eventQueue.remove(kbEvent);

            return;

        }





        setSpeed(getMaxSpeed());
    }


    public boolean isShootingKey(KeyboardEvent kbEvent) {
        return kbEvent.getKey() == KeyboardEvent.KEY_SPACE;
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

        setSpeed(0);

    }


    @Override
    public void keyPressed(KeyboardEvent e) {

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

    }
}

package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileFactory;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ShootingDirection;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public class PlayerShip extends Spaceship implements KeyboardHandler {


    private Keyboard k;
    private Projectile p;


    public PlayerShip(Representable representation) {
        super(representation);
        keyEvents();
    }

    @Override
    public void shoot() {
        getProjectilelist().add((Projectile) getFactory().createProjectile(ShootingDirection.WEST, getRepresentation().getX() + getRepresentation().getWidth(), getRepresentation().getY() + (getRepresentation().getHeight() / 2)));
    }

    @Override
    public void move() {


        accelerate(getCurrentDirection());
        getCollisionDetector().checkCollision(this);
        for (int i = 0; i < getProjectilelist().size(); i++) {
            getProjectilelist().get(i).move();

        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

        setSpeed(0);


    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        setSpeed(getMaxSpeed());

        switch (e.getKey()) {
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

    }
}

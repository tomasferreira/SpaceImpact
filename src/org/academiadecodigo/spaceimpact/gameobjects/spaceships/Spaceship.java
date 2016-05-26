package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.gameobjects.Destroyable;
import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.GameObject;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class Spaceship extends GameObject implements Destroyable {

    private Direction currentDirection;
    private int speed;
    private boolean isDestroyed;

    public Spaceship(Representable representation) {
        super(representation);
    }

    public void shoot(Direction direction) {
        //ProjectileFactory.createProjectile(direction, getRepresentation().getX(), getRepresentation().getY());
    }

    public void destroy() {
        setDestroyed(true);
    }


    @Override
    public void move() {

        switch (getCurrentDirection()) {

            case UP:


                break;

            case DOWN:

                break;

            case LEFT:

                break;


            case RIGHT:

                break;

        }
    }


    public void accelerate(Direction direction, int speed) {

        // Crashed cars can not accelerate
        if (isDestroyed()) {
            return;
        }

        Direction newDirection = direction;


        // Accelerate in the choosen direction
        this.currentDirection = newDirection;
        for (int i = 0; i < speed; i++) {
            //  getPos().moveInDirection(newDirection, 1);
            //  if (collisionDetector.isProjectileSafe(getPos())) {
            //      crash();
            //      break;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

     public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

}

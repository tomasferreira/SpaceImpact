package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.gameobjects.Destroyable;
import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.GameObject;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileFactory;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class Spaceship extends GameObject implements Destroyable {

    private Direction currentDirection;


    private int speed;
    private int maxSpeed = 5;
    private boolean isDestroyed;
    private ProjectileFactory factory;

    private int directionChangelevel = 5;

    public void setFactory(ProjectileFactory factory) {
        this.factory = factory;
    }

    public Spaceship(Representable representation) {
        super(representation);
        currentDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];
    }

    public abstract void shoot();

    public ProjectileFactory getFactory() {
        return factory;
    }

    public void destroy() {
        setDestroyed(true);
    }


    @Override
    public abstract void move();


    public Direction chooseDirection() {

        Direction newDirection = currentDirection;


        // Sometimes, we want to change direction...
        if (Math.random() > ((double) directionChangelevel / 10)) {
            newDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];

        }

        return newDirection;

    }


    public void accelerate(Direction direction, int speed) {

        // Crashed cars can not accelerate
        if (isDestroyed()) {
            return;
        }

        Direction newDirection = direction;


        // Accelerate in the choosen direction
        this.currentDirection = newDirection;

        switch (currentDirection) {
            case UP:
                getRepresentation().move(0, -getSpeed());
                break;

            case DOWN:
                getRepresentation().move(0, getSpeed());
                break;

            case LEFT:
                getRepresentation().move(-getSpeed(), 0);
                break;

            case RIGHT:
                getRepresentation().move(getSpeed(), 0);
                break;
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


    public int getMaxSpeed() {
        return maxSpeed;
    }
}

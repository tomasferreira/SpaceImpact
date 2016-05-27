package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.gameobjects.Destroyable;
import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.GameObject;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileFactory;
import org.academiadecodigo.spaceimpact.representable.Representable;

import java.util.LinkedList;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class Spaceship extends GameObject implements Destroyable {

    private Direction currentDirection;


    private int speed;
    private int maxSpeed = 5;
    private boolean isDestroyed;
    private ProjectileFactory factory;
    private LinkedList<Projectile> projectilelist = new LinkedList<>();
    private int directionChangelevel = 5;

    public Spaceship(Representable representation) {
        super(representation);
        currentDirection = Direction.LEFT;
    }

    public LinkedList<Projectile> getProjectilelist() {
        return projectilelist;
    }

    public abstract void shoot();

    public ProjectileFactory getFactory() {
        return factory;
    }

    public void setFactory(ProjectileFactory factory) {
        this.factory = factory;
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


    public void accelerate(Direction direction) {

        // Crashed cars can not accelerate
        if (isDestroyed()) {
            return;
        }


        // Accelerate in the choosen direction
        this.currentDirection = direction;

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

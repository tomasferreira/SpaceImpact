package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.RandomNumberGen;
import org.academiadecodigo.spaceimpact.gameobjects.Destroyable;
import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.GameObject;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileFactory;
import org.academiadecodigo.spaceimpact.representable.Representable;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class Spaceship extends GameObject implements Destroyable {

    private Direction currentDirection;

    private int counter;
    private int speed;
    private int maxSpeed;
    private boolean isDestroyed;
    private ProjectileFactory factory;

    private LinkedList<Projectile> projectileList = new LinkedList<>();


    public Spaceship(Representable representation, int maxSpeed) {
        super(representation);
        this.maxSpeed = maxSpeed;
        this.speed = maxSpeed;
    }

    public LinkedList<Projectile> getProjectilelist() {
        return projectileList;
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


    public void accelerate(Direction direction) {

        // Crashed cars can not accelerate
        if (isDestroyed()) {
            return;
        }

        if(getSpeed() == 0){
            return;
        }

        // Accelerate in the choosen direction
        this.currentDirection = direction;

        int dx = 0;
        int dy = 0;


        switch (currentDirection) {
            case NORTH:
                dy--;
                break;

            case SOUTH:
                dy++;
               break;

            case EAST:
                dx++;
                break;

            case WEST:
                dx--;
                break;

        }

        getRepresentation().move(dx, dy);

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

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}

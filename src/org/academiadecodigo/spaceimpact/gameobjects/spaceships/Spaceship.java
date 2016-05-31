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
    private int maxSpeed;
    private boolean isDestroyed;
    private ProjectileFactory factory;


    private LinkedList<Projectile> projectileList = new LinkedList<>();


    public Spaceship(Representable representation, int maxSpeed) {
        super(representation);
        this.maxSpeed = maxSpeed;
        this.speed = maxSpeed;
        currentDirection = Direction.EAST;
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


        // Accelerate in the choosen direction
        this.currentDirection = direction;

        switch (currentDirection) {
            case NORTH:
                getRepresentation().move(0, -1);
                break;

            case SOUTH:
                getRepresentation().move(0, 1);
                break;

            case EAST:
                getRepresentation().move(-1, 0);
                break;

            case WEST:
                getRepresentation().move(1, 0);
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

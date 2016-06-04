package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.gameobjects.Destroyable;
import org.academiadecodigo.spaceimpact.gameobjects.GameObject;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileFactory;
import org.academiadecodigo.spaceimpact.representable.Representable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Tomás Ferreira
 * @author Ana Tomás
 * @author Rodolfo Matos
 */


public abstract class Spaceship extends GameObject implements Destroyable {

    private boolean isDestroyed;
    private int shootCounter;
    private int shootPeriodicity;


    public Spaceship(Representable representation, int speed, int shootPeriodicity) {
        super(representation, speed);
        this.shootPeriodicity = shootPeriodicity;
    }

    public abstract void shoot();

    @Override
    public abstract void move();

    public void destroy() {
        getRepresentation().hide();
        setDestroyed(true);
    }

    /**
     * Method that given an array of Direction will move the representation to the new position
     * If spaceship is destroyed returns without changes
     *
     * @param directions - array of Direction
     */

    public void accelerate(Direction[] directions) {

        if (isDestroyed()) {
            return;
        }

        // Accelerate in the choosen direction
        int dx = 0;
        int dy = 0;

        for (Direction direction : directions) {

            if (direction == null) {
                continue;
            }

            switch (direction) {
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
        }
        getRepresentation().move(dx, dy);

    }

    public boolean canShoot() {
        return getShootPeriodicity() == getShootCounter();
    }

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }


    public int getShootCounter() {
        return shootCounter;
    }

    public void setShootCounter(int shootCounter) {
        this.shootCounter = shootCounter;
    }

    public int getShootPeriodicity() {
        return shootPeriodicity;
    }
}

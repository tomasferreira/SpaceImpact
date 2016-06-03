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
 * Created by codecadet on 23/05/16.
 */
public abstract class Spaceship extends GameObject implements Destroyable {

    private int counter;
    private int speed;
    private boolean isDestroyed;


    public Spaceship(Representable representation, int speed) {
        super(representation);
        this.speed = speed;
    }

    public abstract void shoot();


    public void destroy() {
        getRepresentation().hide();
        setDestroyed(true);
    }

    public boolean canMove() {
        return getCounter() == getSpeed();
    }

    @Override
    public abstract void move();


    public void accelerate(Direction[] directions) {

        if (isDestroyed()) {
            return;
        }

        // Accelerate in the choosen direction
        int dx = 0;
        int dy = 0;

        for (Direction direction : directions) {

            if(direction == null){
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


    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}

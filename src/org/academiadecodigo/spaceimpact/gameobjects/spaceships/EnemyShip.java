package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.utilities.RandomNumberGen;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * @author Tomás Ferreira
 * @author Ana Tomás
 * @author Rodolfo Matos
 */

public class EnemyShip extends Spaceship {


    private int startXtoChangeDir;
    private int endXtoChangDir;
    private Direction newDirection;

    public EnemyShip(Representable representation, int speed, int shootPeriodicity, int lives) {

        super(representation, speed, shootPeriodicity, lives);

        setShootCounter(RandomNumberGen.generate(0, getShootPeriodicity()));

        newDirection = Direction.getNorthOrSouth();


        /**
         * Generates an random interval that changes the spaceship direction to either SOUTH or NORTH
         */

        endXtoChangDir = RandomNumberGen.generate(getRepresentation().getMaxX());
        startXtoChangeDir = RandomNumberGen.generate(endXtoChangDir);
    }

    /**
     * Method overridden for its super class, if the ship is in x = 0, hides his representation and sets isDestroyed to true
     */

    @Override
    public void hit() {

        if (isOutOfBounds()) {

            getRepresentation().hide();
            setDestroyed(true);
            return;

        }

        super.hit();

    }

    /**
     * Method that creates a new projectile, will only create if canShoot() returns true, shootCounter increments one
     * when shoot() is called.
     */

    @Override
    public void shoot() {

        if (!canShoot()) {

            setShootCounter(getShootCounter() + 1);
            return;
        }

        getProjectileHandler().getNewEnemyProjectile(getRepresentation().getX(), getRepresentation().getY() + (getRepresentation().getHeight() / 2));

        setShootCounter(0);
    }

    /**
     * Method that moves given the directions by the method chooseDirection(), will only move if canMove() returns true
     */

    @Override
    public void move() {

        Direction[] directions = chooseDirection();

        if (!canMove()) {

            setCounter(getCounter() + 1);
            return;
        }

        accelerate(directions);

        if (isOutOfBounds()) {

            getRepresentation().hide();
            setDestroyed(true);
            return;
        }


        setCounter(0);
    }


    /**
     * Chooses the direction to the enemy ship based on his position and a random interval
     *
     * @return an array of Directions
     */

    private Direction[] chooseDirection() {

        Direction directions[] = new Direction[2];

        if (isOnVerticalLimits()) {

            directions[0] = Direction.getOpposite(newDirection);
            directions[1] = Direction.WEST;

            return directions;
        }

        if (getRepresentation().getX() > startXtoChangeDir &&
                getRepresentation().getX() < endXtoChangDir) {

            directions[0] = newDirection;
            directions[1] = Direction.WEST;

            return directions;
        }

        directions[0] = Direction.WEST;

        return directions;
    }

}

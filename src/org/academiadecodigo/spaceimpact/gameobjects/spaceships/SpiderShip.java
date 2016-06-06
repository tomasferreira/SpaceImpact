package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * @author Tomás Ferreira
 * @author Ana Tomás
 * @author Rodolfo Matos
 */

public class SpiderShip extends EnemyShip {

    private final int FIRST_SHOOTING_POS_X = 25;
    private final int SECOND_SHOOTING_POS_X = 29;
    private final int THIRD_SHOOTING_POS_X = 47;
    private final int SHOOTING_POS_Y = 50;
    private Direction verticalDirection;
    private int counter;


    public SpiderShip(Representable representation, int speed, int shootPeriodicity, int lives) {
        super(representation, speed, shootPeriodicity, lives);


        verticalDirection = Direction.getNorthOrSouth();
    }

    /**
     *
     * Method that has the shoot behaviour, can only shoot if canShoot() returns true.
     * Creates 3 new projectiles.
     *
     */

    @Override
    public void shoot() {
        if (!canShoot()) {
            setShootCounter(getShootCounter() + 1);
            return;
        }

        getProjectileHandler().getNewEnemyProjectile(getRepresentation().getX() + SHOOTING_POS_Y, getRepresentation().getY() + FIRST_SHOOTING_POS_X);
        getProjectileHandler().getNewEnemyProjectile(getRepresentation().getX() + SHOOTING_POS_Y, getRepresentation().getY() + SECOND_SHOOTING_POS_X);
        getProjectileHandler().getNewEnemyProjectile(getRepresentation().getX() + SHOOTING_POS_Y, getRepresentation().getY() + THIRD_SHOOTING_POS_X);
        setShootCounter(0);
    }

    /**
     *
     * Method that controls the moving behaviour of the objecting. Can only move if canMove() returns true.
     * If your position is x = 0, your spaceship will be destroyed and its representation hidden.
     *
     */

    @Override
    public void move() {


        if (!canMove()) {

            setCounter(getCounter() + 1);
            return;
        }

        accelerate(chooseDirection());

        if (isOutOfBounds()) {

            getRepresentation().hide();
            setDestroyed(true);
            return;
        }


        setCounter(0);

    }


    /**
     *
     * Suporting method of move that returns an array of Direction.
     * If the spaceship is on y = 0 or y = max height it will give you the opposite vertical direction.
     *
     *
     * @return an array of Direction
     */

    private Direction[] chooseDirection() {

        Direction[] directions = new Direction[1];


        if (isOnVerticalLimits()) {

            verticalDirection = Direction.getOpposite(verticalDirection);
        }

        directions[0] = verticalDirection;


        if (counter == 10) {
            directions[0] = Direction.WEST;
            counter = 0;
        }

        setIsOnVerticalLimits(false);

        counter++;

        return directions;
    }
}

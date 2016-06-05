package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileType;
import org.academiadecodigo.spaceimpact.representable.Representable;
import org.academiadecodigo.spaceimpact.utilities.RandomNumberGen;

/**
 * Created by codecadet on 04/06/16.
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

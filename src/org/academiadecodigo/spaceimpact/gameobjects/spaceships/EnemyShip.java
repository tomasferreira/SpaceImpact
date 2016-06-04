package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.utilities.RandomNumberGen;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public class EnemyShip extends Spaceship {

    protected int startXtoChangeDir;
    protected int endXtoChangDir;
    private Direction newDirection = Direction.values()[RandomNumberGen.generate(2, 4)];


    public EnemyShip(Representable representation, int speed, int shootPeriodicity) {

        super(representation, speed, shootPeriodicity);

        setShootCounter(RandomNumberGen.generate(0, getShootPeriodicity()));

        endXtoChangDir = RandomNumberGen.generate(getRepresentation().getMaxX());
        startXtoChangeDir = RandomNumberGen.generate(endXtoChangDir);
    }

    @Override
    public void shoot() {

        if (!canShoot()) {

            setShootCounter(getShootCounter() + 1);
            return;
        }

        getProjectileHandler().getNewEnemyProjectile(getRepresentation().getX(), getRepresentation().getY() + (getRepresentation().getHeight() / 2));

        setShootCounter(0);
    }

    @Override
    public void move() {


        Direction[] directions = chooseDirection();

        if (!canMove()) {

            setCounter(getCounter() + 1);
            return;
        }

        accelerate(directions);

        setCounter(0);

        if (isOutOfBounds()) {
            destroy();
        }
    }


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

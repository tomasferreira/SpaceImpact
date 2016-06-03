package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.utilities.RandomNumberGen;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public class EnemyShip extends Spaceship {

    private int shootCounter = RandomNumberGen.generate(0, 200);
    private int startXtoChangeDir;
    private int endXtoChangDir;
    private Direction newDirection = Direction.values()[RandomNumberGen.generate(2, 4)];


    public EnemyShip(Representable representation, int speed) {

        super(representation, speed);

        endXtoChangDir = RandomNumberGen.generate(getRepresentation().getMaxX());
        startXtoChangeDir = RandomNumberGen.generate(endXtoChangDir);
    }

    @Override
    public void shoot() {

        if (shootCounter == 500) {

            getProjectileHandler().getNewEnemyProjectile(getRepresentation().getX(), getRepresentation().getY() + (getRepresentation().getHeight() / 2));
            shootCounter = 0;
        } else {

            shootCounter++;
        }
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

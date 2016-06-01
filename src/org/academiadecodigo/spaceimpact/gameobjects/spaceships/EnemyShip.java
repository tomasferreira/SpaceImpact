package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.Game;
import org.academiadecodigo.spaceimpact.utilities.RandomNumberGen;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.Direction;
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
    private boolean isGoingDiagonal;


    public EnemyShip(Representable representation, int speed) {

        super(representation, speed);
        setCurrentDirection(Direction.WEST);

        endXtoChangDir = RandomNumberGen.generate(getRepresentation().getMaxX());
        startXtoChangeDir = RandomNumberGen.generate(endXtoChangDir);
    }

    @Override
    public void shoot() {

        if (shootCounter == 250) {

            //getProjectileHandler().getNewEnemyProjectile(getRepresentation().getX(), getRepresentation().getY() + (getRepresentation().getHeight() / 2));
            shootCounter = 0;
        } else {

            shootCounter++;
        }
    }

    @Override
    public void move() {

        setCurrentDirection(chooseDirection());

        if (getSpeed() != getCounter()) {

            setCounter(getCounter() + 1);
            return;
        }


        if (isGoingDiagonal) {

            accelerate(getCurrentDirection());
            accelerate(Direction.WEST);

        } else {

            accelerate(getCurrentDirection());
        }

       // getCollisionDetector().checkCollision(this);

        setCounter(0);
    }


    private Direction chooseDirection() {

        isGoingDiagonal = true;

        if(isOnVerticalLimits()){

            return Direction.getOpposite(newDirection);
        }

        if (getRepresentation().getX() > startXtoChangeDir &&
                getRepresentation().getX() < endXtoChangDir) {

            return newDirection;
        }

        isGoingDiagonal = false;

        return Direction.WEST;
    }

}

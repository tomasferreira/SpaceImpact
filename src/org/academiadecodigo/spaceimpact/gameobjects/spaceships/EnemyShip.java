package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.representable.Background;
import org.academiadecodigo.spaceimpact.representable.Representable;
import org.academiadecodigo.spaceimpact.utilities.RandomNumberGen;

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

        /*if (shootCounter == 250) {

            Projectile p = (Projectile) getFactory().createProjectile(ShootingDirection.WEST, getRepresentation().getX(), getRepresentation().getY() + (getRepresentation().getHeight() / 2));
            p.setEnemy(true);
            getProjectilelist().add(p);
            getCollisionDetector().addProjectileToList(p);
            shootCounter = 0;
        } else {

            shootCounter++;
        }*/
    }

    @Override
    public void move() {

        for (int i = 0; i < getProjectilelist().size(); i++) {

            getProjectilelist().get(i).move();
        }

        if (getSpeed() != getCounter()) {

            setCounter(getCounter() + 1);
            return;
        }

        setCurrentDirection(chooseDirection());

        if (isGoingDiagonal) {


            accelerate(getCurrentDirection());
            accelerate(Direction.WEST);

        } else {

            accelerate(getCurrentDirection());
        }

        getCollisionDetector().checkCollision(this);

        setCounter(0);
    }


    private Direction chooseDirection() {

        if (getRepresentation().getY() == getRepresentation().getMaxY()
                || getRepresentation().getY()  == 0) {
            newDirection = Direction.getOpposite(newDirection);
        }

        if (getRepresentation().getX() > startXtoChangeDir &&
                getRepresentation().getX() < endXtoChangDir) {

            isGoingDiagonal = true;

            return newDirection;
        }

        isGoingDiagonal = false;

        return Direction.WEST;
    }


}

package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ShootingDirection;
import org.academiadecodigo.spaceimpact.representable.Representable;
import org.academiadecodigo.spaceimpact.utilities.RandomNumberGen;

/**
 * Created by codecadet on 23/05/16.
 */
public class EnemyShip extends Spaceship {

    private int shootCounter = RandomNumberGen.generate(0, 200);
    private int xToChangeDirection = RandomNumberGen.generate(0, getRepresentation().getMaxX());
    private int yToChangeDirection = RandomNumberGen.generate(0, getRepresentation().getMaxY());
    private int moveCounter;


    public EnemyShip(Representable representation, int speed) {

        super(representation, speed);
        setCurrentDirection(Direction.WEST);
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
        accelerate(getCurrentDirection());

        getCollisionDetector().checkCollision(this);

        setCounter(0);
    }


    public Direction chooseDirection() {


        while(getxToChangeDirection() <= getRepresentation().getX()
                || getyToChangeDirection() <= getRepresentation().getY() || moveCounter <= 25){

            moveCounter++;

            return Direction.values()[RandomNumberGen.generate(2, 4)];
        }

        return Direction.WEST;
    }

    public int getxToChangeDirection() {
        return xToChangeDirection;
    }


    public int getyToChangeDirection() {
        return yToChangeDirection;
    }


}

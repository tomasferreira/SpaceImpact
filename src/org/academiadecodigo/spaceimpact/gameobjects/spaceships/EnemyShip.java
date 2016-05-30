package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.RandomNumberGen;
import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileFactory;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ShootingDirection;
import org.academiadecodigo.spaceimpact.representable.Representable;

import java.util.Random;

/**
 * Created by codecadet on 23/05/16.
 */
public class EnemyShip extends Spaceship {

    private int moveCounter = RandomNumberGen.generate(0, 10);
    private Direction previousDirection = Direction.values()[RandomNumberGen.generate(2, 4)];
    private int shootCounter = RandomNumberGen.generate(0, 200);
    private int changeDirEachMoves = 25;

    public EnemyShip(Representable representation, int maxSpeed) {
        super(representation, maxSpeed);

        setCurrentDirection(Direction.WEST);
    }

    @Override
    public void shoot() {
        if (shootCounter == 250) {

            getProjectilelist().add((Projectile) getFactory().createProjectile(ShootingDirection.WEST, getRepresentation().getX(), getRepresentation().getY() + (getRepresentation().getHeight() / 2)));
            getProjectilelist().getLast().setEnemy(true);
            shootCounter = 0;
        } else {

            shootCounter++;
        }
        //p.setEnemy(true);
    }

    @Override
    public void move() {

       /** if (getSpeed() != getCounter()) {
            setCounter(getCounter() + 1);
            return;
        }*/

        if (moveCounter % changeDirEachMoves == 0) {

            accelerate(chooseDirection());


        } else if (moveCounter % changeDirEachMoves == 1) {

            accelerate(Direction.WEST);

        }

        for (int i = 0; i < getProjectilelist().size(); i++) {

            getProjectilelist().get(i).move();
        }

        getCollisionDetector().checkCollision(this);

        setCounter(0);
    }


    public Direction chooseDirection() {

        Direction newDirection;

        if (previousDirection == Direction.NORTH) {

            newDirection = Direction.SOUTH;

        } else {

            newDirection = Direction.NORTH;
        }

        previousDirection = newDirection;

        return newDirection;
    }


}

package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.utilities.RandomNumberGen;
import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ShootingDirection;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public class EnemyShip extends Spaceship {

    private int counter;
    private int moveCounter = RandomNumberGen.generate(0, 10);
    private Direction previousDirection = Direction.values()[RandomNumberGen.generate(2, 4)];
    private int shootCounter = RandomNumberGen.generate(0, 200);

    public EnemyShip(Representable representation, int maxSpeed) {
        super(representation, maxSpeed);
    }

    @Override
    public void shoot() {
        if (shootCounter == 250) {

            Projectile p = (Projectile) getFactory().createProjectile(ShootingDirection.WEST, getRepresentation().getX(), getRepresentation().getY() + (getRepresentation().getHeight() / 2));
            p.setEnemy(true);
            getProjectilelist().add(p);
            getCollisionDetector().addProjectileToList(p);
            shootCounter = 0;
        } else {
            shootCounter++;
        }
    }

    @Override
    public void move() {

        for (int i = 0; i < getProjectilelist().size(); i++) {
            getProjectilelist().get(i).move();
        }

        if (getSpeed() == counter) {

            if (moveCounter == 10) {
                accelerate(chooseDirection());

            } else {
                accelerate(Direction.EAST);
            }


            moveCounter++;
            counter = 0;

        }

        counter++;


        getCollisionDetector().checkCollision(this);
    }


    public Direction chooseDirection() {

        Direction newDirection = Direction.NORTH;

        if (moveCounter == 10 && previousDirection == Direction.NORTH) {

            moveCounter = 0;
            newDirection = Direction.SOUTH;

        } else if (moveCounter == 10 && previousDirection == Direction.SOUTH) {

            moveCounter = 0;
            newDirection = Direction.NORTH;
        }

        return newDirection;
    }


}

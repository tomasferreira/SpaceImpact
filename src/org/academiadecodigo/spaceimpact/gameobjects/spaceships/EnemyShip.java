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

    private int counter;
    private int moveCounter  = RandomNumberGen.generate(0, 10);
    private Direction previousDirection = Direction.values()[RandomNumberGen.generate(2, 4)];
    private int shootCounter = RandomNumberGen.generate(0, 200) ;

    public EnemyShip(Representable representation, int maxSpeed) {
        super(representation, maxSpeed);
    }

    @Override
    public void shoot() {
        if (shootCounter == 250){

            getProjectilelist().add((Projectile) getFactory().createProjectile(ShootingDirection.WEST, getRepresentation().getX(), getRepresentation().getY() + (getRepresentation().getHeight() / 2)));
            getProjectilelist().getLast().setEnemy(true);
            shootCounter = 0;
        }

        else {
            shootCounter++;
        }
        //p.setEnemy(true);
    }

    @Override
    public void move() {


        if(getSpeed() == counter){

            if(moveCounter == 10){
                accelerate(chooseDirection());

            } else {
                accelerate(Direction.EAST);
            }


            moveCounter++;
            counter = 0;

        }

        counter++;

        for (int i = 0; i < getProjectilelist().size(); i++) {
            getProjectilelist().get(i).move();
        }


        getCollisionDetector().checkCollision(this);
    }


    public Direction chooseDirection() {

        Direction newDirection = Direction.NORTH;

        if(moveCounter == 10 && previousDirection == Direction.NORTH){

            moveCounter = 0;
            newDirection = Direction.SOUTH;

        } else if (moveCounter == 10 && previousDirection == Direction.SOUTH){

            moveCounter = 0;
            newDirection = Direction.NORTH;
        }

        return newDirection;
    }


}

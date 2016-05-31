package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.Game;
import org.academiadecodigo.spaceimpact.utilities.RandomNumberGen;
import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ShootingDirection;
import org.academiadecodigo.spaceimpact.representable.Representable;
import org.academiadecodigo.spaceimpact.simplegfx.SimpleGfxBackground;

/**
 * Created by codecadet on 23/05/16.
 */
public class EnemyShip extends Spaceship {

    private Direction previousDirection = Direction.values()[RandomNumberGen.generate(2, 4)];
    private int shootCounter = RandomNumberGen.generate(0, 200);


    public EnemyShip(Representable representation, int maxSpeed) {

        super(representation, maxSpeed);
        setCurrentDirection(Direction.WEST);
    }

    @Override
    public void shoot() {

        if (shootCounter == 250) {

            Projectile p = (Projectile) getFactory().createProjectile(ShootingDirection.WEST, getRepresentation().getX(), getRepresentation().getY() + (getRepresentation().getHeight() / 2));
            p.setEnemy(true);
            getProjectilelist().add(p);
            getCollisionDetector().addProjectileToEnemyProjectileList(p);
            shootCounter = 0;
        } else {

            shootCounter++;
        }
    }

    @Override
    public void move() {

        if (getSpeed() != getCounter()) {

            setCounter(getCounter() + 1);
            return;
        }


        for (int i = 0; i < getProjectilelist().size(); i++) {

            getProjectilelist().get(i).move();
        }

        //getCollisionDetector().checkCollision(this);
        setCounter(0);
    }


    public Direction chooseDirection() {
       return null;
    }

}

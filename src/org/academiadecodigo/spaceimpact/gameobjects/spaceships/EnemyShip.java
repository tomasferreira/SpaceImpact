package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileFactory;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ShootingDirection;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public class EnemyShip extends Spaceship {

    private int counter;

    public EnemyShip(Representable representation, int maxSpeed) {
        super(representation, maxSpeed);
    }

    @Override
    public void shoot() {
        Projectile p = (Projectile) getFactory().createProjectile(ShootingDirection.WEST, getRepresentation().getX(), getRepresentation().getY() + (getRepresentation().getHeight() / 2));
        p.setEnemy(true);
    }

    @Override
    public void move() {

        Direction newDirection = chooseDirection();

        while (counter < 10) {

            accelerate(newDirection);
            getCollisionDetector().checkCollision(this);
            counter++;

        }

        accelerate(Direction.LEFT);
        counter = 0;

        getCollisionDetector().checkCollision(this);
    }

}

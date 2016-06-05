package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileType;
import org.academiadecodigo.spaceimpact.representable.Representable;
import org.academiadecodigo.spaceimpact.utilities.RandomNumberGen;

/**
 * Created by codecadet on 04/06/16.
 */
public class SpiderShip extends EnemyShip {


   private int lifeLevel = 50;


    public SpiderShip(Representable representation, int speed, int shootPeriodicity) {
        super(representation, speed, shootPeriodicity);

    }

    @Override
    public void shoot() {
        if(!canShoot()) {
            setShootCounter(getShootCounter() + 1);
            return;
        }

        getProjectileHandler().getNewEnemyProjectile(getRepresentation().getMaxX(), getRepresentation().getY());
        getProjectileHandler().getNewEnemyProjectile(getRepresentation().getMaxX(), getRepresentation().getMaxY() -
                ProjectileType.ENEMY.getProjectileHeight());
        setShootCounter(0);
    }

    @Override
    public void move() {
        super.move();
    }
}

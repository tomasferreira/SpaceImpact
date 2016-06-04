package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

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
        super.shoot();
    }

    @Override
    public void move() {
        super.move();
    }
}

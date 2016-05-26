package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public class EnemyShip extends Spaceship {

    private int counter;

    public EnemyShip(Representable representation) {
        super(representation);
    }

    @Override
    public void move() {



        accelerate(getCurrentDirection(), getMaxSpeed());
        //fazer as representaçoes mexerem-se de acordo com a lógica deste objecto;


        //checar colisoes com metodo
        //getCollisionDetector().isProjectileSafe(this);
    }

}

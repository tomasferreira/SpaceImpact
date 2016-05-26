package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public class EnemyShip extends Spaceship {

    public EnemyShip(Representable representation) {
        super(representation);
    }

    @Override
    public void move() {



        //fazer as representaçoes mexerem-se de acordo com a lógica deste objecto;


        //checar colisoes com metodo
        //getCollisionDetector().isUnSafe(this);
    }

}

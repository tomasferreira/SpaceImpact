package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.spaceimpact.CollisionDetector;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public class PlayerShip extends Spaceship{

    @Override
    public void move() {
        //fazer as representaçoes mexerem-se de acordo com a lógica deste objecto;
        //checar colisoes com método
        //getCollisionDetector().isUnSafe(this);
    }

    public PlayerShip(Representable representation) {
        super(representation);
    }
}

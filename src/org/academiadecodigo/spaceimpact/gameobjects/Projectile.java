package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.spaceimpact.CollisionDetector;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public class Projectile extends GameObject implements Destroyable{

    @Override
    public void move() {
        //fazer as representaçoes mexerem-se de acordo com a lógica deste objecto;
    }

    public Projectile(CollisionDetector collisionDetector, Representable representation) {
        super(collisionDetector, representation);
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public void destroy() {

    }
}

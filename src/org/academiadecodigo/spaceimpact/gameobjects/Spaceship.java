package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.spaceimpact.CollisionDetector;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class Spaceship extends GameObject implements Destroyable{

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    private boolean isDestroyed;

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    public Spaceship(Representable representation) {
        super(representation);
    }

    public void shoot(){
        //ProjectileFactory.createProjectile(direction, getRepresentation().getX(), getRepresentation().getY());
    }

    public void destroy(){
        setDestroyed(true);
    }
}

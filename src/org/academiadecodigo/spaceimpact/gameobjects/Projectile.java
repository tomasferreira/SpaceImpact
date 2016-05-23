package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public class Projectile extends GameObject implements Destroyable{

    public Projectile(Representable representation) {
        super(representation);
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public void destroy() {

    }
}

package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class GameObject {

    private Representable representation;

    public GameObject(Representable representation) {
        this.representation = representation;
    }

    public Representable getRepresentation() {
        return representation;
    }

    public void move(int dx, int dy){
        getRepresentation().move(dx, dy);
    }
}

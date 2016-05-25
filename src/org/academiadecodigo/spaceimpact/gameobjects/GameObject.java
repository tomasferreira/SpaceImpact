package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.spaceimpact.CollisionDetector;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class GameObject {

    private Representable representation;
    private CollisionDetector collisionDetector;

    public GameObject(CollisionDetector collisionDetector, Representable representation) {
        this.collisionDetector = collisionDetector;
        this.representation = representation;
    }

    public Representable getRepresentation() {
        return representation;
    }

    public abstract void move();

}

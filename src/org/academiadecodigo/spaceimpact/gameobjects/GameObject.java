package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.spaceimpact.CollisionDetector;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileHandler;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class GameObject {

    private Representable representation;
    private CollisionDetector collisionDetector;
    private ProjectileHandler projectileHandler;

    public boolean isOutOfBounds() {
        return representation.isOutOfBounds();
    }

    public boolean isOnVerticalLimits(){
        return representation.isOnVerticalLimits();
    }


    public ProjectileHandler getProjectileHandler() {
        return projectileHandler;
    }

    public void setProjectileHandler(ProjectileHandler projectileHandler) {
        this.projectileHandler = projectileHandler;
    }

    public GameObject(Representable representation) {
        this.representation = representation;
    }

    public Representable getRepresentation() {
        return representation;
    }

    public abstract void move();

    public CollisionDetector getCollisionDetector() {
        return collisionDetector;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public boolean objectSamePosition(GameObject object){
        return representation.samePosition(object.getRepresentation());
    }
}

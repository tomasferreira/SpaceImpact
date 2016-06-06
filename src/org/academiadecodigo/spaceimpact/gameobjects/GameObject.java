package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileHandler;
import org.academiadecodigo.spaceimpact.representable.Representable;
/**
 * @author Tomás Ferreira
 * @author Ana Tomás
 * @author Rodolfo Matos
 */

public abstract class GameObject {

    private Representable representation;
    private CollisionDetector collisionDetector;
    private ProjectileHandler projectileHandler;
    private int speed;
    private int counter;


    public GameObject(Representable representation, int speed) {
        this.representation = representation;
        this.speed = speed;
    }

    public abstract void move();

    public boolean objectSamePosition(GameObject object) {
        return representation.samePosition(object.getRepresentation());
    }

    public boolean isOutOfBounds() {
        return representation.isOutOfBounds();
    }

    public boolean isOnVerticalLimits() {
        return representation.isOnVerticalLimits();
    }

    public void setIsOnVerticalLimits(boolean isOnVerticalLimits) {
        representation.setIsOnVerticalLimits(isOnVerticalLimits);
    }


    public ProjectileHandler getProjectileHandler() {
        return projectileHandler;
    }

    public void setProjectileHandler(ProjectileHandler projectileHandler) {
        this.projectileHandler = projectileHandler;
    }

    public Representable getRepresentation() {
        return representation;
    }

    public CollisionDetector getCollisionDetector() {
        return collisionDetector;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public boolean canMove() {
        return getCounter() == getSpeed();
    }

    public int getSpeed() {
        return speed;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}

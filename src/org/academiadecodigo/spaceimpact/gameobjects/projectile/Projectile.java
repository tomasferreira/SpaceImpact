package org.academiadecodigo.spaceimpact.gameobjects.projectile;

import org.academiadecodigo.spaceimpact.gameobjects.Destroyable;
import org.academiadecodigo.spaceimpact.gameobjects.GameObject;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * @author Tomás Ferreira
 * @author Ana Tomás
 * @author Rodolfo Matos
 */

public class Projectile extends GameObject implements Destroyable {

    private boolean isEnemy;
    private boolean destroyed;

    /**
     * Method moves the projectile regarding is isEnemy state, if the projectile belongs to an enemy it moves west, vice-versa
     * Can only move if canMove() returns true.
     */

    @Override
    public void move() {

        if (!canMove()) {

            setCounter(getCounter() + 1);
            return;
        }

        if (isEnemy) {
            getRepresentation().move(-1, 0);
        } else {
            getRepresentation().move(1, 0);
        }

        if (isOutOfBounds()) {
            hit();
        }

        setCounter(0);
    }

    public Projectile(Representable representation, int speed) {
        super(representation, speed);
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public void setEnemy(boolean enemy) {
        isEnemy = enemy;
    }

    public boolean isEnemy() {
        return isEnemy;
    }

    /**
     * Method that sets the flag destroyed to true and hides de projectile representation.
     *
     */

    @Override
    public void hit() {
        destroyed = true;
        getRepresentation().hide();
    }
}

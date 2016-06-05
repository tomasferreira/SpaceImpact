package org.academiadecodigo.spaceimpact.gameobjects.projectile;

import org.academiadecodigo.spaceimpact.gameobjects.Destroyable;
import org.academiadecodigo.spaceimpact.gameobjects.GameObject;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public class Projectile extends GameObject implements Destroyable {

    private boolean isEnemy;
    private boolean destroyed;

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

    @Override
    public void hit() {
        destroyed = true;
        getRepresentation().hide();
    }
}

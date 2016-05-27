package org.academiadecodigo.spaceimpact.gameobjects.projectile;

import org.academiadecodigo.spaceimpact.CollisionDetector;
import org.academiadecodigo.spaceimpact.gameobjects.Destroyable;
import org.academiadecodigo.spaceimpact.gameobjects.GameObject;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public class Projectile extends GameObject implements Destroyable {

    private boolean isEnemy;

    public void setEnemy(boolean enemy) {
        isEnemy = enemy;
    }

    public boolean isEnemy() {

        return isEnemy;
    }

    @Override
    public void move() {
        //fazer as representaçoes mexerem-se de acordo com a lógica deste objecto;
        //checar colisoes com metodo
        //getCollisionDetector().isUnSafe(this);

        if (isEnemy){
            getRepresentation().move(-1, 0);
            return;
        }
        getRepresentation().move(1, 0);
    }

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

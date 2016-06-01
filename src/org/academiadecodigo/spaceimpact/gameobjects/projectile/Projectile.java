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

    public void setEnemy(boolean enemy) {
        isEnemy = enemy;
    }

    public boolean isEnemy() {
        return isEnemy;
    }

    @Override
    public void move() {
//        if (destroyed){
//            return;
//        }
        //fazer as representaçoes mexerem-se de acordo com a lógica deste objecto;

        if (isEnemy){
            getRepresentation().move(-1, 0);
        } else {
            getRepresentation().move(1, 0);
        }

        if (isOutOfBounds()){
            destroy();
        }
    }

    public Projectile(Representable representation) {
        super(representation);
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public void destroy() {
        destroyed = true;
        getRepresentation().hide();
    }
}

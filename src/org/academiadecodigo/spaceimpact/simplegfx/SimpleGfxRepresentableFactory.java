package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.GameObjectType;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ShootingDirection;
import org.academiadecodigo.spaceimpact.representable.Representable;
import org.academiadecodigo.spaceimpact.representable.RepresentableFactory;

/**
 * Created by codecadet on 23/05/16.
 */
public class SimpleGfxRepresentableFactory implements RepresentableFactory {

    @Override
    public Representable createRepresentation(GameObjectType type, int posX, int posY) {
        Representable representable = null;

        switch (type){
            case ENEMYSHIP:
                representable = new EnemyShipRepresentation(posX, posY); //add position as argument
                break;
            case PLAYERSHIP:
                representable = new PlayerShipRepresentation(posX, posY);
                break;
        }

        return representable;
    }

    @Override
    public Representable createRepresentation(GameObjectType type, int posX, int posY, ShootingDirection direction) {
        return new ProjectileRepresentation(posX, posY);
    }
}

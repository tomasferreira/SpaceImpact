package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.GameObjectType;
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
                //new simplegfx enemyship
                break;
            case PLAYERSHIP:
                //new simplegfx playership
                break;
        }

        return representable;
    }

    @Override
    public Representable createRepresentation(GameObjectType type, int posX, int posY, Direction direction) {
        return null; //projectile
    }
}

package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.spaceimpact.representable.Representable;
import org.academiadecodigo.spaceimpact.representable.RepresentableFactory;

/**
 * Created by codecadet on 23/05/16.
 */
public class SpaceShipFactory {

    private RepresentableFactory factory;

    public SpaceShipFactory(RepresentableFactory factory) {
        this.factory = factory;
    }

    public GameObject createObject(GameObjectType type, int posX, int posY){
        GameObject gameObject = null;

        switch (type) {
            case ENEMYSHIP:
                gameObject = new EnemyShip(factory.createRepresentation(type, posX, posY));
                break;
            case PLAYERSHIP:
                gameObject = new PlayerShip(factory.createRepresentation(type, posX, posY));
                break;
        }
        return gameObject;
    }
}

package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.Game;
import org.academiadecodigo.spaceimpact.RandomNumberGen;
import org.academiadecodigo.spaceimpact.gameobjects.GameObject;
import org.academiadecodigo.spaceimpact.gameobjects.GameObjectType;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.EnemyShip;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.PlayerShip;
import org.academiadecodigo.spaceimpact.representable.RepresentableFactory;

/**
 * Created by codecadet on 23/05/16.
 */
public class SpaceShipFactory {

    private RepresentableFactory factory;
    private final int SHIP_SIZE = 100;

    public SpaceShipFactory(RepresentableFactory factory) {
        this.factory = factory;
    }

    public GameObject createObject(GameObjectType type, int posX, int posY){
        GameObject gameObject = null;

        switch (type) {
            case ENEMYSHIP:
                gameObject = new EnemyShip(factory.createRepresentation(type, factory.getBackground().getWidth() - SHIP_SIZE,
                        RandomNumberGen.generate(factory.getBackground().getHeight() - SHIP_SIZE)), 1);
                break;
            case PLAYERSHIP:
                gameObject = new PlayerShip(factory.createRepresentation(type, posX, posY), 5);
                break;
        }
        return gameObject;
    }
}

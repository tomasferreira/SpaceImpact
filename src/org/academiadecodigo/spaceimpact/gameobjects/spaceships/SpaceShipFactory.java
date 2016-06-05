package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.utilities.RandomNumberGen;
import org.academiadecodigo.spaceimpact.gameobjects.GameObject;
import org.academiadecodigo.spaceimpact.gameobjects.GameObjectType;
import org.academiadecodigo.spaceimpact.representable.RepresentableFactory;

/**
 * Created by codecadet on 23/05/16.
 */
public class SpaceShipFactory {

    private RepresentableFactory factory;
    private final int ENEMYSHIP_WIDTH = 90;
    private final int ENEMYSHIP_HEIGHT = 35;
    private final int SPIDERSHIP_WIDTH = 155;
    private final int SPIDERSHIP_HEIGHT = 125;

    public SpaceShipFactory(RepresentableFactory factory) {
        this.factory = factory;
    }

    public GameObject createObject(GameObjectType type, int posX, int posY){
        GameObject gameObject = null;

        switch (type) {

            case PLAYERSHIP:
                gameObject = new PlayerShip(factory.createRepresentation(type, posX, posY), type.getSpeed(), type.getShootPeriodicity());
                break;
            case ENEMYSHIP:
                gameObject = new EnemyShip(factory.createRepresentation(type, factory.getBackground().getWidth() - ENEMYSHIP_WIDTH,
                        factory.getBackground().getPadding() + RandomNumberGen.generate(factory.getBackground().getHeight() - ENEMYSHIP_HEIGHT)), type.getSpeed(), type.getShootPeriodicity());
                break;
            case SPIDERSHIP:
                gameObject = new SpiderShip(factory.createRepresentation(type,factory.getBackground().getWidth() - SPIDERSHIP_WIDTH,
                        factory.getBackground().getPadding() + RandomNumberGen.generate(factory.getBackground().getHeight() - SPIDERSHIP_HEIGHT)), type.getSpeed(), type.getShootPeriodicity());
                break;
        }
        return gameObject;
    }
}

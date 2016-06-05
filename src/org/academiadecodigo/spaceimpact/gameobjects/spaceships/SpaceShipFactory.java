package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.utilities.RandomNumberGen;
import org.academiadecodigo.spaceimpact.gameobjects.GameObject;
import org.academiadecodigo.spaceimpact.gameobjects.GameObjectType;
import org.academiadecodigo.spaceimpact.representable.RepresentableFactory;

/**
 * @author Tomás Ferreira
 * @author Ana Tomás
 * @author Rodolfo Matos
 */

public class SpaceShipFactory {

    private RepresentableFactory factory;
    private final int SHIP_SIZE = 100;

    public SpaceShipFactory(RepresentableFactory factory) {
        this.factory = factory;
    }

    /**
     *
     * Method that instantiates a new spaceship given it's type and position X and position Y
     *
     * @param type - spaceship type
     * @param posX - spawn position X
     * @param posY - spawn position Y
     * @return returns the reference to the GameObject
     */


    public GameObject createObject(GameObjectType type, int posX, int posY){
        GameObject gameObject = null;

        switch (type) {

            case ENEMYSHIP:
                gameObject = new EnemyShip(factory.createRepresentation(type, factory.getBackground().getWidth() - SHIP_SIZE,
                        factory.getBackground().getPadding() + RandomNumberGen.generate(factory.getBackground().getHeight() - SHIP_SIZE)), type.getSpeed(), type.getShootPeriodicity(), type.getLives());
                break;
            case PLAYERSHIP:
                gameObject = new PlayerShip(factory.createRepresentation(type, posX, posY), type.getSpeed(), type.getShootPeriodicity(), type.getLives());
                break;
        }
        return gameObject;
    }
}

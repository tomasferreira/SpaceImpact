package org.academiadecodigo.spaceimpact;

import org.academiadecodigo.spaceimpact.gameobjects.EnemyShip;
import org.academiadecodigo.spaceimpact.gameobjects.GameObjectType;
import org.academiadecodigo.spaceimpact.gameobjects.SpaceShipFactory;
import org.academiadecodigo.spaceimpact.representable.Background;
import org.academiadecodigo.spaceimpact.simplegfx.SimpleGfxBackground;
import org.academiadecodigo.spaceimpact.simplegfx.SimpleGfxRepresentableFactory;

import java.util.LinkedList;

/**
 * Created by codecadet on 23/05/16.
 */
public class Game {

    public final int SIZE_WIDTH = 100;
    public final int SIZE_HEIGHT = 100;
    private final int STARTING_ENEMY_SHIPS = 10;

//    public void init(){
//        Background background = new SimpleGfxBackground();
//        background.init(SIZE_WIDTH, SIZE_HEIGHT);
//
//        SpaceShipFactory spaceShipFactory = new SpaceShipFactory(new SimpleGfxRepresentableFactory());
//
//        LinkedList<EnemyShip> enemyShips = new LinkedList<>();
//
//        for (int i = 0; i < STARTING_ENEMY_SHIPS; i++) {
//            enemyShips.add(spaceShipFactory.createObject(GameObjectType.ENEMYSHIP, ))
//        }
//
//        for (enemyShips enemyShip: enemyShips) {
//
//        }
//
//
//    }
}

package org.academiadecodigo.spaceimpact;

import org.academiadecodigo.spaceimpact.gameobjects.*;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileFactory;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.EnemyShip;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.PlayerShip;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.SpaceShipFactory;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.Spaceship;
import org.academiadecodigo.spaceimpact.representable.Background;
import org.academiadecodigo.spaceimpact.representable.RepresentableFactory;
import org.academiadecodigo.spaceimpact.simplegfx.SimpleGfxBackground;
import org.academiadecodigo.spaceimpact.simplegfx.SimpleGfxRepresentableFactory;

import java.util.LinkedList;

/**
 * Created by codecadet on 23/05/16.
 */
public class Game {

    public static final int SIZE_WIDTH = 1280;
    public static final int SIZE_HEIGHT = 500;
    private final int STARTING_ENEMY_SHIPS = 10;
    private final int DELAY = 50;

    private int enemyStartingPosX; //por todos na mesma posiçao X mas variar a posiçao Y
    private int enemyStartingPosY;

    private int playerStartingPosX;
    private int playerStartingPosY;

    private RepresentableFactory representableFactory = new SimpleGfxRepresentableFactory();

    private Background background;
    private SpaceShipFactory spaceShipFactory;
    private ProjectileFactory projectileFactory;
    private Spaceship playerShip;
    private LinkedList<EnemyShip> enemyShips;
    private LinkedList<Projectile> projectiles;
    private CollisionDetector collisionDetector = new CollisionDetector();


    public Game() {
    }

    public void init() {

        background = new SimpleGfxBackground();

        background.init(SIZE_WIDTH, SIZE_HEIGHT);
        
        spaceShipFactory = new SpaceShipFactory(representableFactory);
        projectileFactory = new ProjectileFactory(representableFactory);

        playerShip = (PlayerShip) spaceShipFactory.createObject(GameObjectType.PLAYERSHIP, playerStartingPosX, playerStartingPosY);
        playerShip.setCollisionDetector(collisionDetector);
        playerShip.setFactory(projectileFactory);

        projectiles = new LinkedList<>();

        enemyShips = new LinkedList<>();
        for (int i = 0; i < STARTING_ENEMY_SHIPS; i++) {
            enemyShips.add((EnemyShip) spaceShipFactory.createObject(GameObjectType.ENEMYSHIP, enemyStartingPosX, enemyStartingPosY));
            enemyShips.get(i).setCollisionDetector(collisionDetector);
            enemyShips.get(i).setFactory(projectileFactory);
        }
    }

    public void start() throws InterruptedException {

        while(!playerShip.isDestroyed()){

            Thread.sleep(DELAY);
            move();
        }


    }

    public void move(){
        for (int i = 0; i < enemyShips.size(); i++) {
            enemyShips.get(i).move();
            enemyShips.get(i).shoot();

        }
        //for (int i = 0; i < projectiles.size(); i++) {
        //    projectiles.get(i).move();
        //}
        playerShip.move();
        playerShip.shoot();

    }


}

package org.academiadecodigo.spaceimpact;

import org.academiadecodigo.spaceimpact.gameobjects.CollisionDetector;
import org.academiadecodigo.spaceimpact.gameobjects.GameObjectType;
import org.academiadecodigo.spaceimpact.gameobjects.Score;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileFactory;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.EnemyShip;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.PlayerShip;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.SpaceShipFactory;
import org.academiadecodigo.spaceimpact.representable.Background;
import org.academiadecodigo.spaceimpact.representable.RepresentableFactory;
import org.academiadecodigo.spaceimpact.representable.ScoreBoard;
import org.academiadecodigo.spaceimpact.simplegfx.SimpleGfxBackground;
import org.academiadecodigo.spaceimpact.simplegfx.SimpleGfxRepresentableFactory;
import org.academiadecodigo.spaceimpact.simplegfx.SimpleGfxScoreBoard;

import java.util.LinkedList;

/**
 * Created by codecadet on 23/05/16.
 */
public class Game {

    private final int STARTING_ENEMY_SHIPS = 2;
    private final int DELAY = 1;

    private int enemyStartingPosX; //por todos na mesma posiçao X mas variar a posiçao Y
    private int enemyStartingPosY;

    private int playerStartingPosX = 10;
    private int playerStartingPosY = 250;

    private Background background;
    private ScoreBoard scoreBoard;

    private RepresentableFactory representableFactory = new SimpleGfxRepresentableFactory();

    private SpaceShipFactory spaceShipFactory;
    private ProjectileFactory projectileFactory;
    private PlayerShip playerShip;
    private LinkedList<EnemyShip> enemyShips;
    private LinkedList<Projectile> projectiles;
    private CollisionDetector collisionDetector = new CollisionDetector();
    private Score score = new Score();


    public Game() {
    }

    public void init() {

        background = new SimpleGfxBackground(score);
        representableFactory.setBackground(background);

        background.init();
        scoreBoard = new SimpleGfxScoreBoard(background, score);

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


        int enemySpawnCounter = 0;

        while (!playerShip.isDestroyed()) {

            Thread.sleep(DELAY);
            move();

            if (enemySpawnCounter == 500) {
                enemyShips.add((EnemyShip) spaceShipFactory.createObject(GameObjectType.ENEMYSHIP, enemyStartingPosX, enemyStartingPosY));
                enemyShips.getLast().setCollisionDetector(collisionDetector);
                enemyShips.getLast().setFactory(projectileFactory);
                enemySpawnCounter = 0;
            }
            enemySpawnCounter++;
            removeTrash();

            System.out.println(score.getPoints());
            background.showScore();
            scoreBoard.show();

        }


    }

    private void move() {
        for (int i = 0; i < enemyShips.size(); i++) {
            enemyShips.get(i).move();
            enemyShips.get(i).shoot();

        }
        collisionDetector.setEnemyList(enemyShips);
        collisionDetector.setPlayer(playerShip);
        //for (int i = 0; i < projectiles.size(); i++) {
        //    projectiles.get(i).move();
        //}
        playerShip.queueHandler();

    }

    private void updateScores() {
        score.updateScores(collisionDetector.getDestroyedEnemies());
    }

    private void removeTrash() {

    }


}

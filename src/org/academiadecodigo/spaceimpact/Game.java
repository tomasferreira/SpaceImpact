package org.academiadecodigo.spaceimpact;

import org.academiadecodigo.spaceimpact.gameobjects.CollisionDetector;
import org.academiadecodigo.spaceimpact.gameobjects.GameObjectType;
import org.academiadecodigo.spaceimpact.gameobjects.Score;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileFactory;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileHandler;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.EnemyShip;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.PlayerShip;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.SpaceShipFactory;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.SpiderShip;
import org.academiadecodigo.spaceimpact.representable.Background;
import org.academiadecodigo.spaceimpact.representable.RepresentableFactory;
import org.academiadecodigo.spaceimpact.representable.ScoreBoard;
import org.academiadecodigo.spaceimpact.simplegfx.SimpleGfxBackground;
import org.academiadecodigo.spaceimpact.simplegfx.SimpleGfxRepresentableFactory;
import org.academiadecodigo.spaceimpact.simplegfx.SimpleGfxScoreBoard;
import org.academiadecodigo.spaceimpact.utilities.SoundHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codecadet on 23/05/16.
 */
public class Game {

    private final int STARTING_ENEMY_SHIPS = 5;
    private final int DELAY = 1;
    private final int BOSS_SPAWN_INTERVAL = 100;
    private final int FIRST_BOSS_SPAWN_TIME = 20;
    private final int ENEMY_SPAWN_INTERVAL = 500;

    private Background background;
    private ScoreBoard scoreBoard;

    private RepresentableFactory representableFactory = new SimpleGfxRepresentableFactory();

    private SpaceShipFactory spaceShipFactory;
    private ProjectileFactory projectileFactory;
    private PlayerShip playerShip;
    private List<EnemyShip> enemyShips;
    private CollisionDetector collisionDetector = new CollisionDetector();
    private ProjectileHandler projectileHandler = new ProjectileHandler();
    private Score score;
    private SpiderShip spiderShip;


    public void init() {

        background = new SimpleGfxBackground();
        representableFactory.setBackground(background);

        background.init();

        spaceShipFactory = new SpaceShipFactory(representableFactory);
        projectileFactory = new ProjectileFactory(representableFactory);
        projectileHandler.setProjectileFactory(projectileFactory);

        playerShip = (PlayerShip) spaceShipFactory.createObject(GameObjectType.PLAYERSHIP);
        playerShip.setProjectileHandler(projectileHandler);

        score = new Score(playerShip.getLives());
        scoreBoard = new SimpleGfxScoreBoard(background, score);
        scoreBoard.showBoard();
        scoreBoard.showScore();

        enemyShips = new ArrayList<>();

        for (int i = 0; i < STARTING_ENEMY_SHIPS; i++) {

            EnemyShip enemyShip = (EnemyShip) spaceShipFactory.createObject(GameObjectType.ENEMYSHIP);
            enemyShip.setProjectileHandler(projectileHandler);
            enemyShips.add(enemyShip);
        }

        collisionDetector.setPlayer(playerShip);
        collisionDetector.setEnemyList(enemyShips);
        collisionDetector.setProjectileHandler(projectileHandler);
    }

    public void start() throws InterruptedException {

        SoundHandler.playGameSound();

        int enemySpawnCounter = 0;
        score.setSpiderShip(spiderShip != null);

        while (playerShip.getLives() > 0) {

            Thread.sleep(DELAY);
            move();

            //when score is X, stop creating enemyShips and create spiderShip
            if (playerShip.isPaused()) {
                continue;
            }


            if (spiderShip == null && (score.getTotal() != 0 && score.getTotal() % BOSS_SPAWN_INTERVAL == 0 || score.getTotal() == FIRST_BOSS_SPAWN_TIME)) {

                spawnSpiderShip();
            }

            if (enemySpawnCounter++ == ENEMY_SPAWN_INTERVAL) {

                spawnEnemyShip();
                enemySpawnCounter = 0;
            }

            collisionDetector.checkCollision();
            updateScores();

            if (spiderShip != null) {
                deleteSpiderShip();

            }

        }
    }


    private void move() {
        if (!playerShip.isPaused()) {

            for (int i = 0; i < enemyShips.size(); i++) {
                enemyShips.get(i).move();
                enemyShips.get(i).shoot();
            }
            projectileHandler.moveProjectiles();
        }

        playerShip.keyMapHandler();

    }

    private void updateScores() {

        if (score.hasSpiderShip()) {
            score.updateScoresSpiderShip(spiderShip.getLives(), collisionDetector.getDestroyedSpiderShips(), collisionDetector.getDestroyedEnemies(), playerShip.getLives());
            scoreBoard.showScore();
        }

        if (score.getDestroyedEnemyShips() != collisionDetector.getDestroyedEnemies()) {
            score.updateScores(collisionDetector.getDestroyedEnemies(), playerShip.getLives());
            scoreBoard.showScore();

        }

        if (score.getLives() != playerShip.getLives()) {
            score.updateScores(collisionDetector.getDestroyedEnemies(), playerShip.getLives());
            scoreBoard.showScore();
        }

    }


    private void spawnSpiderShip() {
        spiderShip = (SpiderShip) spaceShipFactory.createObject(GameObjectType.SPIDERSHIP);
        spiderShip.setProjectileHandler(projectileHandler);
        enemyShips.add(spiderShip);

        collisionDetector.setEnemyList(enemyShips);

        score.setSpiderShip(spiderShip != null);
        scoreBoard.showBoard();
        scoreBoard.showScore();
    }

    private void spawnEnemyShip() {
        EnemyShip enemyShip = (EnemyShip) spaceShipFactory.createObject(GameObjectType.ENEMYSHIP);
        enemyShip.setProjectileHandler(projectileHandler);
        enemyShips.add(enemyShip);
        collisionDetector.setEnemyList(enemyShips);
    }

    private void deleteSpiderShip() {
        if (spiderShip.isDestroyed()) {
            spiderShip = null;
            score.setSpiderShip(spiderShip != null);
            SoundHandler.playSpiderDeathSound();
            scoreBoard.showBoard();
            scoreBoard.showScore();
        }
    }

}

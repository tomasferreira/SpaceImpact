package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileHandler;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.EnemyShip;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.PlayerShip;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.SpiderShip;

import java.util.Iterator;
import java.util.List;

/**
 * @author Tomás Ferreira
 * @author Ana Tomás
 * @author Rodolfo Matos
 */

public class CollisionDetector {

    private List<EnemyShip> enemyList;
    private List<Projectile> enemyProjectiles;
    private List<Projectile> playerProjectiles;
    private PlayerShip player;
    private ProjectileHandler projectileHandler;
    private int destroyedEnemies;
    private int destroyedSpiderShips;

    public void setProjectileHandler(ProjectileHandler projectileHandler) {
        this.projectileHandler = projectileHandler;
    }

    /**
     * Method that contains the routine for checking collisions, checks for collisions then deletes them.
     */


    public void checkCollision() {

        enemyProjectiles = projectileHandler.getEnemyProjectiles();
        playerProjectiles = projectileHandler.getPlayerProjectiles();

        checkPlayerAndEnemyCollision();
        checkPlayerAndProjectileCollision();
        checkProjectileAndEnemyCollision();
        checkProjectileAndProjectileCollision();

        deleteTrash();
    }


    /**
     * Removes from the list enemies that have the flag isDestroyed true;
     */

    private void deleteTrash() {

        projectileHandler.deleteDestroyedBullets();

        Iterator<EnemyShip> it = enemyList.iterator();


        while (it.hasNext()) {
            EnemyShip enemyShip = it.next();

            if (enemyShip.getLives() <= 0) {
                if (enemyShip instanceof SpiderShip) {
                    destroyedSpiderShips++;
                }
                destroyedEnemies++;
            }


            if (enemyShip.isDestroyed()) {
                it.remove();
            }

        }
    }

    /**
     * Method that checks if a projectile and a projectile collided, if so calls the method hit() from both objects.
     *
     */

    private void checkProjectileAndProjectileCollision() {
        for (Projectile playerProjectile : playerProjectiles) {
            for (Projectile enemyProjectile : enemyProjectiles) {
                if (playerProjectile.objectSamePosition(enemyProjectile)) {
                    playerProjectile.hit();
                    enemyProjectile.hit();
                }
            }
        }
    }

    /**
     * Method that checks if a projectile and an enemy collided, if so calls the method hit() from both objects.
     *
     */

    private void checkProjectileAndEnemyCollision() {
        for (Projectile projectile : playerProjectiles) {
            for (EnemyShip enemy : enemyList) {
                if (projectile.objectSamePosition(enemy)) {
                    projectile.hit();
                    enemy.hit();
                }
            }
        }
    }

    /**
     *
     * Method that checks if a player and a projectile collided, if so calls the method hit() from both objects
     */

    private void checkPlayerAndProjectileCollision() {
        for (Projectile projectile : enemyProjectiles) {
            if (player.objectSamePosition(projectile)) {
                player.hit();
                projectile.hit();
            }
        }
    }

    /**
     * Method that checks if and player and an enemy collided, if so calls the method hit() from both objects.
     */

    private void checkPlayerAndEnemyCollision() {
        for (EnemyShip enemy : enemyList) {
            if (player.objectSamePosition(enemy)) {
                player.hit();
                enemy.hit();
            }
        }
    }


    public int getDestroyedEnemies() {
        return destroyedEnemies;
    }

    public int getDestroyedSpiderShips() {
        return destroyedSpiderShips;
    }

    public void setEnemyList(List<EnemyShip> enemyList) {
        this.enemyList = enemyList;
    }

    public void setPlayer(PlayerShip player) {
        this.player = player;
    }

}

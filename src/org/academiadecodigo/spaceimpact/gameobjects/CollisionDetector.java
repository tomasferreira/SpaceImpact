package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileHandler;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.EnemyShip;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.PlayerShip;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by codecadet on 25/05/16.
 */
public class CollisionDetector {

    private List<EnemyShip> enemyList;
    private List<Projectile> enemyProjectiles;
    private List<Projectile> playerProjectiles;
    private PlayerShip player;
    private ProjectileHandler projectileHandler;
    private int destroyedEnemies;

    public void setProjectileHandler(ProjectileHandler projectileHandler) {
        this.projectileHandler = projectileHandler;
    }

    public void checkCollision() {

        enemyProjectiles = projectileHandler.getEnemyProjectiles();
        playerProjectiles = projectileHandler.getPlayerProjectiles();

        checkPlayerAndEnemyCollision();
        checkPlayerAndProjectileCollision();
        checkProjectileAndEnemyCollision();
        checkProjectileAndProjectileCollision();

        deleteTrash();
    }

    private void deleteTrash() {
        projectileHandler.deleteDestroyedBullets();

        Iterator<EnemyShip> it = enemyList.iterator();

        while (it.hasNext()) {
            if (it.next().isDestroyed()) {
                it.remove();
                destroyedEnemies++;
            }
        }
    }

    private void checkProjectileAndProjectileCollision() {
        for (Projectile playerProjectile : playerProjectiles) {
            for (Projectile enemyProjectile : enemyProjectiles) {
                if (playerProjectile.objectSamePosition(enemyProjectile)) {
                    playerProjectile.destroy();
                    enemyProjectile.destroy();
                }
            }
        }
    }

    private void checkProjectileAndEnemyCollision() {
        for (Projectile projectile : playerProjectiles) {
            for (EnemyShip enemy : enemyList) {
                if (projectile.objectSamePosition(enemy)) {
                    projectile.destroy();
                    enemy.destroy();
                }
            }
        }
    }

    private void checkPlayerAndProjectileCollision() {
        for (Projectile projectile : enemyProjectiles) {
            if (player.objectSamePosition(projectile)) {
                player.destroy();
                projectile.destroy();
            }
        }
    }

    private void checkPlayerAndEnemyCollision() {
        for (EnemyShip enemy : enemyList) {
            if (player.objectSamePosition(enemy)) {
                player.destroy();
                enemy.destroy();
            }
        }
    }


    public int getDestroyedEnemies() {
        return destroyedEnemies;
    }

    public void setEnemyList(List<EnemyShip> enemyList) {
        this.enemyList = enemyList;
    }

    public void setPlayer(PlayerShip player) {
        this.player = player;
    }
}
package org.academiadecodigo.spaceimpact;

import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
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
    private List<Projectile> enemyProjectiles = new ArrayList<>();
    private List<Projectile> playerProjectiles = new ArrayList<>();
    private PlayerShip player;

    public void addProjectileToEnemyProjectileList(Projectile p) {
        enemyProjectiles.add(p);
    }

    public void addProjectileToPlayerProjectilesList(Projectile p){
        playerProjectiles.add(p);
    }

    public void checkCollision() {

        checkPlayerAndEnemyCollision();
        checkPlayerAndProjectileCollision();
        checkProjectileAndEnemyCollision();
        checkProjectileAndProjectileCollision();

    }

    private void checkProjectileAndProjectileCollision() {
        for (Projectile playerProjectile : playerProjectiles){
            for (Projectile enemyProjectile : enemyProjectiles){
                if (playerProjectile.objectSamePosition(enemyProjectile)){
                    System.out.println("asd");
                    playerProjectile.destroy();
                    enemyProjectile.destroy();
                }
            }
        }
    }

    private void checkProjectileAndEnemyCollision() {
        for (Projectile projectile : playerProjectiles){
            for (EnemyShip enemy : enemyList){
                if (projectile.objectSamePosition(enemy)){
                    System.out.println("asfjsdfkjlsdfkjn");
                    projectile.destroy();
                    enemy.destroy();
                }
            }
        }
    }

    private void checkPlayerAndProjectileCollision() {
        for (Projectile projectile : enemyProjectiles){
            if (player.objectSamePosition(projectile)){
                player.destroy();
                projectile.destroy();
            }
        }
    }

    private void checkPlayerAndEnemyCollision() {
        for (EnemyShip enemy : enemyList) {
            if (player.objectSamePosition(enemy)){
                player.destroy();
                enemy.destroy();
            }
        }
    }

    public void checkProjectilesCollision() {

        if (player.getProjectilelist() == null) {
            return;
        }

        Iterator<Projectile> playerProjectileIt = player.getProjectilelist().iterator();
        Iterator<Projectile> projectileIterator = enemyProjectiles.iterator();

        Projectile playerProjectile;
        Projectile enemyProjectile;

        while (playerProjectileIt.hasNext()) {
            playerProjectile = playerProjectileIt.next();

            while (projectileIterator.hasNext()) {
                enemyProjectile = projectileIterator.next();
                if (!enemyProjectile.isEnemy()) {
                    continue;
                }

                if (playerProjectile.objectSamePosition(enemyProjectile)) {
                    playerProjectile.destroy();
                    enemyProjectile.destroy();
                }
            }
        }
    }

//    private void checkEnemyCollision() {
//        if (player.getProjectilelist().isEmpty()) {
//            return;
//        }
//
//        Iterator<Projectile> playerProjectilesIt = player.getProjectilelist().iterator();
//
//        while (playerProjectilesIt.hasNext()) {
//
//            Projectile p = playerProjectilesIt.next();
//            if (gameObject.objectSamePosition(p)) {
//                ((EnemyShip) gameObject).destroy();
//                p.destroy();
//            }
//        }
//    }
//
//    private void checkPlayerCollision() {
//
//        Iterator<EnemyShip> enemyIterator = enemyList.iterator();
//        Iterator<Projectile> projectilesIterator;
//
//        while (enemyIterator.hasNext()) {
//
//            EnemyShip e = enemyIterator.next();
//
//            if (gameObject.objectSamePosition(e)) {
//                ((PlayerShip) gameObject).destroy();
//                e.destroy();
//            }
//
//            projectilesIterator = e.getProjectilelist().iterator();
//
//
//            while (projectilesIterator.hasNext()) {
//                Projectile p = projectilesIterator.next();
//
//                if (gameObject.objectSamePosition(p)) {
//
//                    ((PlayerShip) gameObject).destroy();
//                    p.destroy();
//                }
//            }
//        }
//    }

    public void setEnemyList(List<EnemyShip> enemyList) {
        this.enemyList = enemyList;
    }

    public void setPlayer(PlayerShip player) {
        this.player = player;
    }
}

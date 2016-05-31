package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.spaceimpact.gameobjects.Destroyable;
import org.academiadecodigo.spaceimpact.gameobjects.GameObject;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.EnemyShip;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.PlayerShip;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.Spaceship;
import org.academiadecodigo.spaceimpact.representable.Representable;
import org.academiadecodigo.spaceimpact.simplegfx.SimpleGfxGameObject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 25/05/16.
 */
public class CollisionDetector {

    private LinkedList<EnemyShip> enemyList;
    private LinkedList<Projectile> projectiles = new LinkedList<>();
    private PlayerShip player;
    private LinkedList<GameObject> objects;
    private int destroyedEnemies;

    public CollisionDetector() {

//        objects = new LinkedList<>();
//
//        objects.addAll(enemyList);
//        //objects.addAll(projectiles);
//        //objects.add(player);
//
//
//        for (Projectile p : projectiles) {
//
//            p.getRepresentation().samePosition()
//
//        }

    }

    public void addProjectileToList(Projectile p) {
        projectiles.add(p);
    }

    public void checkCollision(GameObject gameObject) {


        if (gameObject instanceof PlayerShip) {
            checkPlayerCollision(gameObject);
            if (!projectiles.isEmpty()) {
                checkProjectilesCollision(gameObject);
            }
        }

        if (gameObject instanceof EnemyShip) {
            checkEnemyCollision(gameObject);
        }


    }

    public void checkProjectilesCollision(GameObject gameObject) {

        if (player.getProjectilelist() == null) {
            return;
        }

        Iterator<Projectile> playerProjectileIt = player.getProjectilelist().iterator();
        Iterator<Projectile> projectileIterator = projectiles.iterator();

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

    private void checkEnemyCollision(GameObject gameObject) {
        if (player.getProjectilelist().isEmpty()) {
            return;
        }

        Iterator<Projectile> playerProjectilesIt = player.getProjectilelist().iterator();

        while (playerProjectilesIt.hasNext()) {

            Projectile p = playerProjectilesIt.next();
            if (gameObject.objectSamePosition(p)) {
                ((EnemyShip) gameObject).destroy();
                p.destroy();
            }
        }
    }

    private void checkPlayerCollision(GameObject gameObject) {

        Iterator<EnemyShip> enemyIterator = enemyList.iterator();
        Iterator<Projectile> projectilesIterator;

        while (enemyIterator.hasNext()) {

            EnemyShip e = enemyIterator.next();

            if (gameObject.objectSamePosition(e)) {
                ((PlayerShip) gameObject).destroy();
                e.destroy();
                destroyedEnemies++;
            }

            projectilesIterator = e.getProjectilelist().iterator();


            while (projectilesIterator.hasNext()) {
                Projectile p = projectilesIterator.next();

                if (gameObject.objectSamePosition(p)) {

                    ((PlayerShip) gameObject).destroy();
                    p.destroy();
                }
            }
        }
    }


    public int getDestroyedEnemies() {
        return destroyedEnemies;
    }

    public void setEnemyList(LinkedList<EnemyShip> enemyList) {
        this.enemyList = enemyList;
    }

    public void setProjectiles(LinkedList<Projectile> projectiles) {
        this.projectiles = projectiles;
    }

    public void setPlayer(PlayerShip player) {
        this.player = player;
    }
}

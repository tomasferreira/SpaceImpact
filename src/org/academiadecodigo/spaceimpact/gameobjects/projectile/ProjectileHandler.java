package org.academiadecodigo.spaceimpact.gameobjects.projectile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by codecadet on 31/05/16.
 */
public class ProjectileHandler {

    private List<Projectile> enemyProjectiles;
    private List<Projectile> playerProjectiles;
    private ProjectileFactory projectileFactory;

    public ProjectileHandler() {
        enemyProjectiles = new ArrayList<>();
        playerProjectiles = new ArrayList<>();
    }

    public void setProjectileFactory(ProjectileFactory projectileFactory) {
        this.projectileFactory = projectileFactory;
    }

    public void addProjectileToEnemyProjectileList(Projectile p) {
        enemyProjectiles.add(p);
    }

    public void addProjectileToPlayerProjectileList(Projectile p) {
        playerProjectiles.add(p);
    }

    public List<Projectile> getEnemyProjectiles() {
        return enemyProjectiles;
    }

    public List<Projectile> getPlayerProjectiles() {
        return playerProjectiles;
    }

    public void moveProjectiles() {
        for (Projectile p : enemyProjectiles) {
            p.move();
        }
        for (Projectile p : playerProjectiles) {
            p.move();

        }
    }

    public void deleteDestroyedBullets() {
        Iterator<Projectile> itE = enemyProjectiles.iterator();
        Iterator<Projectile> itP = playerProjectiles.iterator();

        while (itE.hasNext()) {
            if (itE.next().isDestroyed()) {
                itE.remove();
            }
        }

        while (itP.hasNext()) {
            if (itP.next().isDestroyed()) {
                itP.remove();
            }
        }
    }

    public void getNewEnemyProjectile(int posX, int posY) {
        Projectile p = (Projectile) projectileFactory.createProjectile( ProjectileType.ENEMY, ShootingDirection.WEST, posX, posY);
        p.setEnemy(true);
        addProjectileToEnemyProjectileList(p);

    }

    public void getNewPlayerProjectile(int posX, int posY) {
        Projectile p = (Projectile) projectileFactory.createProjectile(ProjectileType.PLAYER, ShootingDirection.WEST, posX, posY);
        addProjectileToPlayerProjectileList(p);

    }
}

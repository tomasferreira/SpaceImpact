package org.academiadecodigo.spaceimpact.gameobjects.projectile;

/**
 * Created by codecadet on 03/06/16.
 */
public enum  ProjectileType {
    PLAYER(7),
    ENEMY(7);

    private int projectileHeight;

    public int getProjectileHeight() {
        return projectileHeight;
    }

    ProjectileType(int projectileHeight) {

        this.projectileHeight = projectileHeight;
    }
}


package org.academiadecodigo.spaceimpact.gameobjects.projectile;

/**
 * @author Tomás Ferreira
 * @author Ana Tomás
 * @author Rodolfo Matos
 */

public enum ProjectileType {
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


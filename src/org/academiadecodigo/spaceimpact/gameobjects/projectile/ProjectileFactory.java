package org.academiadecodigo.spaceimpact.gameobjects.projectile;

import org.academiadecodigo.spaceimpact.gameobjects.GameObject;
import org.academiadecodigo.spaceimpact.gameobjects.GameObjectType;
import org.academiadecodigo.spaceimpact.representable.RepresentableFactory;

/**
 * @author Tomás Ferreira
 * @author Ana Tomás
 * @author Rodolfo Matos
 */
public class ProjectileFactory {

    private RepresentableFactory factory;

    public ProjectileFactory(RepresentableFactory factory) {
        this.factory = factory;
    }

    /**
     * Method that returns a new instance of Projectile
     *
     * @param projectileType - if its an enemy projectile or a player projectile
     * @param direction      - the projectile direction, commonly west or east
     * @param posX           - his starting position on X
     * @param posY           - his starting position on Y
     * @return a new instance of the projectile with the parameters above
     */

    public GameObject createProjectile(ProjectileType projectileType, ShootingDirection direction, int posX, int posY) {

        return new Projectile(factory.createRepresentation(GameObjectType.PROJECTILE, projectileType, posX, posY, direction), GameObjectType.PROJECTILE.getSpeed());
    }

}

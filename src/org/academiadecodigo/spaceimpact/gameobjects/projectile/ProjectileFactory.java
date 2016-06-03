package org.academiadecodigo.spaceimpact.gameobjects.projectile;

import org.academiadecodigo.spaceimpact.gameobjects.GameObject;
import org.academiadecodigo.spaceimpact.gameobjects.GameObjectType;
import org.academiadecodigo.spaceimpact.representable.RepresentableFactory;

/**
 * Created by codecadet on 23/05/16.
 */
public class ProjectileFactory {

    private RepresentableFactory factory;

    public ProjectileFactory(RepresentableFactory factory) {
        this.factory = factory;
    }

    public GameObject createProjectile(ProjectileType projectileType, ShootingDirection direction, int posX, int posY){

        return new Projectile(factory.createRepresentation(GameObjectType.PROJECTILE, projectileType, posX, posY, direction), GameObjectType.PROJECTILE.getSpeed());
    }

}

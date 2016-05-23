package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.spaceimpact.representable.RepresentableFactory;

/**
 * Created by codecadet on 23/05/16.
 */
public class ProjectileFactory {

    private static RepresentableFactory factory;

    public ProjectileFactory(RepresentableFactory factory) {
        this.factory = factory;
    }

    public static GameObject createProjectile(Direction direction, int posX, int posY){

        return new Projectile(factory.createRepresentation(GameObjectType.PROJECTILE, posX, posY, direction));
    }

}

package org.academiadecodigo.spaceimpact.gameobjects.projectile;

import org.academiadecodigo.spaceimpact.gameobjects.Direction;
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

    public GameObject createProjectile(Direction direction, int posX, int posY){

        return new Projectile(factory.createRepresentation(GameObjectType.PROJECTILE, posX, posY, direction));
    }

}

package org.academiadecodigo.spaceimpact.representable;

import org.academiadecodigo.spaceimpact.gameobjects.GameObjectType;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileType;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ShootingDirection;

/**
 * Created by codecadet on 23/05/16.
 */
public interface RepresentableFactory {

    void setBackground(Background background);

    Background getBackground();
    Representable createRepresentation(GameObjectType type, int posX, int posY);

    Representable createRepresentation(GameObjectType type, ProjectileType projectileType, int posX, int posY, ShootingDirection direction);

}

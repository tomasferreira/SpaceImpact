package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.spaceimpact.gameobjects.GameObjectType;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileType;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ShootingDirection;
import org.academiadecodigo.spaceimpact.representable.Background;
import org.academiadecodigo.spaceimpact.representable.Representable;
import org.academiadecodigo.spaceimpact.representable.RepresentableFactory;

/**
 * Created by codecadet on 23/05/16.
 */
public class SimpleGfxRepresentableFactory implements RepresentableFactory {

    private Background background;

    @Override
    public Background getBackground() {
        return background;
    }

    @Override
    public Representable createRepresentation(GameObjectType type, int posX, int posY) {

        Representable representable = null;

        switch (type){
            case ENEMYSHIP:
                representable = new EnemyShipRepresentation(posX, posY, background); //add position as argument
                break;
            case PLAYERSHIP:
                representable = new PlayerShipRepresentation(posX, posY, background);
                break;
            case SPIDERSHIP:
                representable = new SpiderShipRepresentation(posX, posY, background);
                break;
        }

        return representable;
    }

    @Override
    public Representable createRepresentation(GameObjectType type, ProjectileType projectileType, int posX, int posY, ShootingDirection direction) {
        //add projectile type
        return new ProjectileRepresentation(posX, posY, background, projectileType);
    }

    public void setBackground(Background background) {
        this.background = background;
    }
}

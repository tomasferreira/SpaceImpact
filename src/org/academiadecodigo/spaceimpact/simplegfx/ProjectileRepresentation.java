package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileType;
import org.academiadecodigo.spaceimpact.representable.Background;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 25/05/16.
 */
public class ProjectileRepresentation extends SimpleGfxGameObject {

    public ProjectileRepresentation(int x, int y, Background background, ProjectileType projectileType) {
        super(x, y, background);

        switch (projectileType) {
            case ENEMY:
                setPicture(new Picture(x, y, "resources/images/projectile_01.png"));
                break;
            case PLAYER:
                setPicture(new Picture(x, y, "resources/images/player_projectile_02.png"));
        }

        show();
    }
}

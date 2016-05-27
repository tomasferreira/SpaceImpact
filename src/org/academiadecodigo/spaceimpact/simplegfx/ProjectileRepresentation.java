package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 25/05/16.
 */
public class ProjectileRepresentation extends SimpleGfxGameObject {

    public ProjectileRepresentation(int x, int y) {
        super(x, y);
        setWidth(20);
        setHeight(10);
        setPicture(new Picture(x + SimpleGfxBackground.PADDING, y + SimpleGfxBackground.PADDING,
                "resources/images/projectile_01.png"));
        show();
    }
}

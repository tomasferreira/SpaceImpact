package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 25/05/16.
 */
public class EnemyShipRepresentation extends SimpleGfxGameObject {

    public EnemyShipRepresentation(int x, int y) {
        super(x, y);
        setWidth(20);
        setHeight(20);
        setPicture(new Picture(x + SimpleGfxBackground.PADDING, y + SimpleGfxBackground.PADDING,
                "resources/images/playerShip_01_50.png"));
        show();
    }
}

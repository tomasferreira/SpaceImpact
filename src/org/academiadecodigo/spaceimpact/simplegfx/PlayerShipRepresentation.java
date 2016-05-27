package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 25/05/16.
 */
public class PlayerShipRepresentation extends SimpleGfxGameObject {


    public PlayerShipRepresentation(int x, int y) {
        super(x, y);
        setWidth(62);
        setHeight(50);
        setPicture(new Picture(x + SimpleGfxBackground.PADDING, y + SimpleGfxBackground.PADDING,
                "resources/images/playerShip_01_50.png"));
        show();

    }

}

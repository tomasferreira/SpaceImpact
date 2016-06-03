package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceimpact.representable.Background;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 25/05/16.
 */
public class PlayerShipRepresentation extends SimpleGfxGameObject {


    public PlayerShipRepresentation(int x, int y, Background background) {
        super(x, y, background);
        setPicture(new Picture(x, y,
                "resources/images/playerShip_01_50.png"));
        show();
    }

}

package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 25/05/16.
 */
public class PlayerShipRepresentation extends SimpleGfxGameObject {


    public PlayerShipRepresentation(int x, int y) {
        super(x, y);
        setWidth(40);
        setHeight(40);
        setRectangle(new Rectangle(x + SimpleGfxBackground.PADDING, y + SimpleGfxBackground.PADDING, getWidth(),
                getHeight()));
        show(Color.CYAN);
    }

}

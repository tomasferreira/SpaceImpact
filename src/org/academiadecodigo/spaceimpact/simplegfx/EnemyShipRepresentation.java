package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 25/05/16.
 */
public class EnemyShipRepresentation extends SimpleGfxGameObject {

    public EnemyShipRepresentation(int x, int y) {
        super(x, y);
        setWidth(20);
        setHeight(20);
        setRectangle(new Rectangle(x + SimpleGfxBackground.PADDING, y + SimpleGfxBackground.PADDING, getWidth(),
                getHeight()));
        show(Color.MAGENTA);
    }
}

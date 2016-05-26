package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 25/05/16.
 */
public class ProjectileRepresentation extends SimpleGfxGameObject {

    public ProjectileRepresentation(int x, int y) {
        super(x, y);
        setWidth(10);
        setHeight(5);
        setRectangle(new Rectangle(x + SimpleGfxBackground.PADDING, y + SimpleGfxBackground.PADDING, getWidth(),
                getHeight()));
        show(Color.RED);
    }
}

package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceimpact.representable.Background;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 25/05/16.
 */
public class EnemyShipRepresentation extends SimpleGfxGameObject {

    public EnemyShipRepresentation(int x, int y, Background background) {
        super(x, y, background);
        //TODO automatic width and height
        setWidth(100);
        setHeight(46);
        setPicture(new Picture(x + SimpleGfxBackground.PADDING, y + SimpleGfxBackground.PADDING,
                "resources/images/enemy_02_30.png"));
        show();
    }
}

package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceimpact.representable.Background;

/**
 * Created by codecadet on 04/06/16.
 */
public class SpiderShipRepresentation extends SimpleGfxGameObject {

    public SpiderShipRepresentation(int x, int y, Background background) {
        super(x, y, background);
        setPicture(new Picture(x , y, "resources/images/boss_01_120.png"));
        show();
    }
}

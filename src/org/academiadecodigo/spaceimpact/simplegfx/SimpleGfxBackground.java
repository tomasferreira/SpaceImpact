package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceimpact.gameobjects.Score;
import org.academiadecodigo.spaceimpact.representable.Background;

/**
 * Created by codecadet on 25/05/16.
 */
public class SimpleGfxBackground implements Background {

    private final int PADDING = 10;
    private Picture background;

    @Override
    public void init() {
        background = new Picture(PADDING, PADDING, "resources/images/background_01.jpg");
        background.draw();
    }

    public int getPadding() {
        return PADDING;
    }

    public int getWidth() {
        return background.getWidth();
    }

    public int getHeight() {
        return background.getHeight();
    }
}

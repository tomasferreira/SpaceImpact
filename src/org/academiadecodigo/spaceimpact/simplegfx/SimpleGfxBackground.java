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

    private int padding = 10;
    private int width;
    private int height;
    private Picture background;
    private Text points;

    @Override
    public void init() {
        background = new Picture(padding, padding,"resources/images/background_01.jpg");
        background.draw();
    }

    public int getPadding() {
        return padding;
    }

    public int getWidth() {
        return background.getWidth();
    }

    public int getHeight() {
        return background.getHeight();
    }
}

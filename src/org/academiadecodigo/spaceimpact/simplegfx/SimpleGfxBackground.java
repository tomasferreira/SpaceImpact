package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceimpact.representable.Background;

import java.awt.*;

/**
 * Created by codecadet on 25/05/16.
 */
public class SimpleGfxBackground implements Background {

    public static final int PADDING = 10;
    private Picture background;
    private int width;
    private int height;


    @Override
    public void init() {
        background = new Picture(PADDING,PADDING,"resources/images/background_01.jpg");
        background.draw();
    }

    public int getWidth() {
        return background.getWidth();
    }

    public int getHeight() {
        return background.getHeight();
    }
}

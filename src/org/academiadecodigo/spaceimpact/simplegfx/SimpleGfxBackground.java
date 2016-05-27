package org.academiadecodigo.spaceimpact.simplegfx;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceimpact.representable.Background;

import java.awt.*;

/**
 * Created by codecadet on 25/05/16.
 */
public class SimpleGfxBackground implements Background {

    public static final int PADDING = 10;

    @Override
    public void init(int width, int height) {
        //Rectangle background = new Rectangle( PADDING, PADDING, width, height);
        Picture background = new Picture(PADDING,PADDING,"resources/images/background_01.jpg");
        background.draw();
    }
}

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
    private Score score;
    private Text points;

    public SimpleGfxBackground(Score score) {
        this.score = score;
    }

    @Override
    public void init() {
        background = new Picture(padding, padding,"resources/images/background_01.jpg");
        background.draw();
        Rectangle scoreRectangle = new Rectangle(padding, height+(padding*2), width, 50);
        scoreRectangle.setColor(Color.WHITE);
        scoreRectangle.fill();
        points = new Text(padding, height + (padding * 2), "");
        points.setColor(Color.BLACK);
        points.draw();
    }

    @Override
    public void showScore() {

        points.setText("Score: " + score.getPoints());
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

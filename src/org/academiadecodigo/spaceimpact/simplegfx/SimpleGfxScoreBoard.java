package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.spaceimpact.gameobjects.Score;
import org.academiadecodigo.spaceimpact.representable.Background;
import org.academiadecodigo.spaceimpact.representable.ScoreBoard;

/**
 * Created by codecadet on 30/05/16.
 */
public class SimpleGfxScoreBoard implements ScoreBoard{

    private Rectangle board;
    private int x;
    private int y;
    private int width = 80;
    private int height;
    private Background background;
    private Score score;

    public SimpleGfxScoreBoard(Background background, Score score) {
        this.background = background;
        this.score = score;
        x = (background.getWidth() - width) + background.getPadding();
        y = background.getPadding();
        height = background.getHeight();

    }

    @Override
    public void show() {
        board = new Rectangle(x, y, width, height);
        board.setColor(Color.WHITE);
        board.fill();

        String points = " " + score.getPoints();

        Text score = new Text(x, y, points);
        score.draw();

    }

    /*public void update(){
        board.setColor(Color.YELLOW);
        board.fill();
    }*/
}

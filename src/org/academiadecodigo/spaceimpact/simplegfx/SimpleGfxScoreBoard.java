package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.spaceimpact.gameobjects.Scores;
import org.academiadecodigo.spaceimpact.representable.Background;
import org.academiadecodigo.spaceimpact.representable.ScoreBoard;

/**
 * Created by codecadet on 30/05/16.
 */
public class SimpleGfxScoreBoard implements ScoreBoard{

    private Rectangle board;
    private int x;
    private int y;
    private int width = 100;
    private int height;
    private Background background;
    private Scores scores;
    private int padding = SimpleGfxBackground.PADDING;

    public SimpleGfxScoreBoard(Background background, Scores scores) {
        this.background = background;
        this.scores = scores;
        x = (background.getWidth() - width) + padding;
        y = padding;
        height = background.getHeight();

    }

    @Override
    public void show() {
        board = new Rectangle(x, y, width, height);
        board.setColor(Color.WHITE);
        board.fill();

        String points = " " + scores.getPoints();

        Text score = new Text(x, y, points);
        score.draw();

    }

    /*public void update(){
        board.setColor(Color.YELLOW);
        board.fill();
    }*/
}

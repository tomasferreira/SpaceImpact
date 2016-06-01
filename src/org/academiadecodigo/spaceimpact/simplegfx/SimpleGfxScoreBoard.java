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
public class SimpleGfxScoreBoard implements ScoreBoard {

    private Rectangle board;
    private int x;
    private int y;
    private int width;
    private int height = 80;
    private Background background;
    private Score score;
    private Text textScore;

    public SimpleGfxScoreBoard(Background background, Score score) {
        this.background = background;
        this.score = score;
        x = background.getPadding();
        y = background.getPadding() + background.getHeight();
        width = background.getWidth();

    }

    @Override
    public void showBoard() {
        board = new Rectangle(x, y, width, height);
        board.setColor(Color.WHITE);
        board.fill();
        textScore = new Text(x, y, "");
        textScore.draw();
    }

    @Override
    public void showScore() {
        textScore.setText("" + score.getPoints());
    }
}

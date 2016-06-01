package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceimpact.gameobjects.Score;
import org.academiadecodigo.spaceimpact.representable.Background;
import org.academiadecodigo.spaceimpact.representable.ScoreBoard;

/**
 * Created by codecadet on 30/05/16.
 */
public class SimpleGfxScoreBoard implements ScoreBoard {

    private Picture board;
    private int x;
    private int y;
    private Background background;
    private Score score;
    private Text textScore;
    private int textScoreX;
    private int textScoreY;

    public SimpleGfxScoreBoard(Background background, Score score) {
        this.background = background;
        this.score = score;
        x = background.getPadding();
        y = background.getPadding() + background.getHeight();
        textScoreX = background.getWidth() - 90;
        textScoreY = y + 15;
    }

    @Override
    public void showBoard() {
        board = new Picture(x, y, "resources/images/scoreboard_02.png");
        board.draw();
        textScore = new Text(textScoreX, textScoreY, "");
        textScore.grow(4, 8);
        textScore.draw();
    }

    @Override
    public void showScore() {
        textScore.setText("" + score.getPoints());
    }
}

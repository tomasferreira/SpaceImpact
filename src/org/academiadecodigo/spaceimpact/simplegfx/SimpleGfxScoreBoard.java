package org.academiadecodigo.spaceimpact.simplegfx;

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
    private Text textPoints;
    private int textPointsX;
    private int textPointsY;
    private Text textLives;
    private int textLivesX;
    private int textLivesY;

    public SimpleGfxScoreBoard(Background background, Score score) {
        this.background = background;
        this.score = score;
        x = background.getPadding();
        y = background.getPadding() + background.getHeight();
        textPointsX = background.getWidth() - 90;
        textPointsY = y + 15;
        textLivesX = background.getPadding() + 85;
        textLivesY = y + 37;
    }

    @Override
    public void showBoard() {
        board = new Picture(x, y, "resources/images/scoreboard_03.png");
        board.draw();
        textPoints = new Text(textPointsX, textPointsY, "");
        textPoints.grow(4, 8);
        textPoints.draw();
        textLives = new Text(textLivesX, textLivesY, "");
        textLives.grow(4, 8);
        textLives.draw();
    }

    @Override
    public void showScore() {
        textPoints.setText("" + score.getPoints());
        textLives.setText("" + score.getLives());
    }
}

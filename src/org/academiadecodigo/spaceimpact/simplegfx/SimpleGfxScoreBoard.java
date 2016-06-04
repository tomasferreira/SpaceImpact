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

    //text that displays the number of lives left
    private Text textLives;
    //placement of the text that displays the number of lives left
    private int textLivesX;
    private int textLivesY;

    //text that displays score
    private Text textScore;
    //placement of the text that displays score
    private int textScoreX;
    private int textScoreY;

    //text that displays the number of destroyed EnemyShips
    private Text destroyedEnemyShips;
    //placement of the text that displays the number of destroyed EnemyShips
    private int destroyedEnemyShipsX;
    private int destroyedEnemyShipsY;

    public SimpleGfxScoreBoard(Background background, Score score) {
        //Constructor that receives the background and score and attributes a position to the text that is relative to the background
        this.background = background;
        this.score = score;

        x = background.getPadding();
        y = background.getPadding() + background.getHeight();

        textLivesX = background.getPadding() + 85;
        textLivesY = y + 37;

        textScoreX = background.getWidth() - 63;
        textScoreY =  y + 37;

        destroyedEnemyShipsX = background.getWidth() - 210;
        destroyedEnemyShipsY = y + 15;
    }

    @Override
    public void showBoard() {
        //method that draws the scoreboard and the text it contains with the desired font size

        board = new Picture(x, y, "resources/images/scoreboard_04_enemyShip.png");
        board.draw();

        textLives = new Text(textLivesX, textLivesY, "");
        textLives.grow(4, 8);
        textLives.draw();

        textScore = new Text(textScoreX, textScoreY, "");
        textScore.grow( 4, 8);
        textScore.draw();

        destroyedEnemyShips = new Text(destroyedEnemyShipsX, destroyedEnemyShipsY, "");
        destroyedEnemyShips.grow(4, 8);
        destroyedEnemyShips.draw();
    }

    @Override
    public void showScore() {
        //method that updates the scores that are being displayed

        textScore.setText("" + score.getTotal());
        destroyedEnemyShips.setText("" + score.getDestroyedEnemyShips());
        textLives.setText("" + score.getLives());
    }
}

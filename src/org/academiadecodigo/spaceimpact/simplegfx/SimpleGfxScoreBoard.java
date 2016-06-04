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

    //text that displays the number of lives left
    private Text spiderShipLifeLevel;
    //placement of the text that displays the number of lives left
    private int spiderShipLifeLevelX;
    private int spiderShipLifeLevelY;

    public SimpleGfxScoreBoard(Background background, Score score) {
        //Constructor that receives the background and score and attributes a position to the text that is relative to the background
        this.background = background;
        this.score = score;

        x = background.getPadding();
        y = background.getPadding() + background.getHeight();

        textLivesX = background.getPadding() + 85;
        textLivesY = y + 37;

        textScoreX = background.getWidth() - 75;
        textScoreY = y + 45;

        destroyedEnemyShipsX = background.getWidth() - 210;
        destroyedEnemyShipsY = y + 20;
    }

    @Override
    public void showBoard() {
        //method that draws the scoreboard and the text it contains with the desired font size


        //if scoreboard score == x, picture is boss_01 & corresponding text spiderLife level

        board = new Picture(x, y, "resources/images/scoreboard_04_enemyShip.png");
        board.draw();

        textLives = new Text(textLivesX, textLivesY, "");
        textLives.grow(4, 8);
        textLives.draw();

        textScore = new Text(textScoreX, textScoreY, "");
        textScore.grow(20, 20);
        textScore.draw();

        destroyedEnemyShips = new Text(destroyedEnemyShipsX, destroyedEnemyShipsY, "");
        destroyedEnemyShips.grow(4, 8);
        destroyedEnemyShips.draw();
    }

    @Override
    public void showScore() {
        //method that updates the scores that are being displayed

        //number of lives left
        textLives.setText("" + score.getLives());

        //total score
        if (score.getTotal() == 0) {
            textScore.setText("00000");
        } else if (score.getTotal() < 10) {
            textScore.setText("0000" + score.getTotal());
        } else if (score.getTotal() < 100) {
            textScore.setText("000" + score.getTotal());
        } else if (score.getTotal() < 1000) {
            textScore.setText("00" + score.getTotal());
        } else if (score.getTotal() < 10000) {
            textScore.setText("0" + score.getTotal());
        }


        //number of destroyed EnemyShips
        if (score.getDestroyedEnemyShips() == 0) {
            destroyedEnemyShips.setText("0000");
        } else if (score.getDestroyedEnemyShips() < 10) {
            destroyedEnemyShips.setText("000" + score.getDestroyedEnemyShips());
        } else if (score.getDestroyedEnemyShips() < 100) {
            destroyedEnemyShips.setText("00" + score.getDestroyedEnemyShips());
        } else if (score.getTotal() < 100) {
            destroyedEnemyShips.setText("0" + score.getDestroyedEnemyShips());
        }


    }
}

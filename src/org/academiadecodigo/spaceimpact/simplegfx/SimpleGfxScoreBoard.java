package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.spaceimpact.representable.Background;
import org.academiadecodigo.spaceimpact.representable.ScoreBoard;

/**
 * Created by codecadet on 30/05/16.
 */
public class SimpleGfxScoreBoard implements ScoreBoard{

    private Rectangle board;
    private int x= 40;
    private int y = 70;
    private int width = 100;
    private int height = 200;
   // private Background background;

    public SimpleGfxScoreBoard() {
        //this.background = background;
        //height = background.getHeight();
        //x = background.getWidth() - width;
        board = new Rectangle();
        board.setColor(Color.BLACK);
        board.fill();

    }

}

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



    @Override
    public void show() {
        board = new Rectangle(x, y, width, height);
        board.setColor(Color.BLACK);
        board.fill();
    }
}

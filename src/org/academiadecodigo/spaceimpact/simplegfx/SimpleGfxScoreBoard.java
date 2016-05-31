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
    private int x;
    private int y;
    private int width = 100;
    private int height;
    private Background background;
    private int padding = SimpleGfxBackground.PADDING;

    public SimpleGfxScoreBoard(Background background) {
        this.background = background;
        x = (background.getWidth() - width) + padding;
        y = padding;
        height = background.getHeight();
    }

    @Override
    public void show() {
        board = new Rectangle(x, y, width, height);
        board.setColor(Color.BLACK);
        board.fill();
    }
}

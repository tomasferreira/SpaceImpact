package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 25/05/16.
 */
public class PlayerShipRepresentation implements Representable {

    private Rectangle rectangle;
    private int x;
    private int y;
    private int width = 20;
    private int height = width;

    public PlayerShipRepresentation(int x, int y) {
        this.x = x;
        this.y = y;
        rectangle = new Rectangle(x + SimpleGfxBackground.PADDING, y + SimpleGfxBackground.PADDING, width, height);
        show();
    }


    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void move(int dx, int dy) {
       rectangle.translate(dx, dy);
    }

    public void show(){
        rectangle.setColor(Color.CYAN);
        rectangle.fill();
    }

    public void hide(){
        rectangle.delete();
    }
}

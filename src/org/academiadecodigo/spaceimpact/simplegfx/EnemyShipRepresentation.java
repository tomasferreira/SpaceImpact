package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 25/05/16.
 */
public class EnemyShipRepresentation implements Representable {

    private Rectangle rectangle;
    int x;
    int y;

    public EnemyShipRepresentation(int x, int y) {
        this.x = x;
        this.y = y;
        rectangle = new Rectangle(x + SimpleGfxBackground.PADDING, y + SimpleGfxBackground.PADDING, 20, 20);
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
        rectangle.setColor(Color.MAGENTA);
        rectangle.fill();
    }

    public void hide(){
        rectangle.delete();
    }
}

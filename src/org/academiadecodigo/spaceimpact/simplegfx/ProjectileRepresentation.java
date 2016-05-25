package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 25/05/16.
 */
public class ProjectileRepresentation implements Representable {
    private Rectangle rectangle;
    int x;
    int y;

    public ProjectileRepresentation(int x, int y) {
        this.x = x;
        this.y = y;
        rectangle = new Rectangle(x+ SimpleGfxBackground.PADDING, y+ SimpleGfxBackground.PADDING, 10, 5);
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
        rectangle.setColor(Color.RED);
        rectangle.fill();
    }

    public void hide(){
        rectangle.delete();
    }
}

package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 26/05/16.
 */
public abstract class SimpleGfxGameObject implements Representable {

    private Rectangle rectangle;
    private int x;
    private int y;
    private int width;
    private int height;

    public SimpleGfxGameObject(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void show(Color color) {
        rectangle.setColor(color);
        rectangle.fill();
    }

    public void hide() {
        rectangle.delete();
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

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

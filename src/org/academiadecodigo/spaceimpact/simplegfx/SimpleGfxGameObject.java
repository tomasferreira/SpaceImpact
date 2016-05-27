package org.academiadecodigo.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceimpact.representable.Background;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 26/05/16.
 */
public abstract class SimpleGfxGameObject implements Representable {

    private Picture picture;
    private int x;
    private int y;
    private int width;
    private int height;
    private Background background;

    public SimpleGfxGameObject(int x, int y, Background background) {
        this.x = x;
        this.y = y;
        this.background = background;

    }

    public void show() {
        picture.draw();
    }

    public void hide() {
       picture.delete();
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
        picture.translate(dx, dy);
        setX(getX() + dx);
        setY(getY() + dy);
    }

    @Override
    public boolean samePosition(Representable representable) {
        return false;
    }

    @Override
    public boolean isOutOfBounds(int dx, int dy) {
        return false;
    }

    public Picture getPicture() {
        return picture;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
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

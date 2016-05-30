package org.academiadecodigo.spaceimpact.simplegfx;

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

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getMaxX() {
        return picture.getMaxX();
    }

    @Override
    public int getMaxY() {
        return picture.getMaxY();
    }

    @Override
    public void move(int dx, int dy) {
        if (isOutOfBounds(dx, dy)) {
            return;
        }
        picture.translate(dx, dy);
        setX(getX() + dx);
        setY(getY() + dy);
    }

    @Override
    public boolean samePosition(Representable representable) {
        if (representable.getX() > x && representable.getMaxX() < picture.getMaxX()) {

            if (representable.getY() > y && representable.getMaxY() < picture.getMaxY()) {
                System.out.println("asdasd");
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean isOutOfBounds(int dx, int dy) {

        int padding = SimpleGfxBackground.PADDING;

        //if x is out of bounds
        if (x + dx < padding || dx + picture.getMaxX() > padding + background.getWidth()) {
            return true;
        }

        //if y is out of bounds
        if (y + dy < padding || dy + picture.getMaxY() > padding + background.getHeight()) {
            return true;
        }

        return false;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public int getWidth() {
        return picture.getWidth();
    }

    public int getHeight() {
        return picture.getHeight();
    }


}

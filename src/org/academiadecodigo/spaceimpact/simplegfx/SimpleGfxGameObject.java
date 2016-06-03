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
    private boolean isOutOfBounds;
    private boolean isOnVerticalLimits;

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
        return (picture.getWidth() + picture.getX());
    }

    @Override
    public int getMaxY() {
        return (picture.getHeight() + picture.getMaxY());
    }

    @Override
    public void move(int dx, int dy) {
        if (isMoveOutOfBounds(dx, dy)) {
            return;
        }
        picture.translate(dx, dy);
        setX(getX() + dx);
        setY(getY() + dy);
    }

    @Override
    public boolean samePosition(Representable representable) {

        if ((x > representable.getX() && x < representable.getMaxX()) || (getMaxX() > representable.getX() && getMaxX() < representable.getMaxX())) {

            if ((y > representable.getY() && y < representable.getMaxY()) || (getMaxY() > representable.getY() && getMaxY() < representable.getMaxY())) {

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isOutOfBounds() {
        return isOutOfBounds;
    }

    @Override
    public boolean isOnVerticalLimits() {
        return isOnVerticalLimits;
    }

    @Override
    public boolean isMoveOutOfBounds(int dx, int dy) {

        int padding = background.getPadding();

        //if x is out of bounds
        if (x + dx < padding || dx + getMaxX() > padding + background.getWidth()) {
            isOutOfBounds = true;
            return true;
        }

        //if y is out of bounds
        if (y + dy < padding || dy + getMaxY() > padding + background.getHeight()) {
            isOnVerticalLimits = true;
            return true;
        }

        return false;
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

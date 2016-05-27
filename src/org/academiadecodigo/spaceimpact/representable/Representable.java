package org.academiadecodigo.spaceimpact.representable;

/**
 * Created by codecadet on 23/05/16.
 */
public interface Representable {

    int getX();
    int getY();
    int getWidth();
    int getHeight();

    void setX(int newPosX);
    void setY(int newPosY);

    void move(int dx, int dy);

}

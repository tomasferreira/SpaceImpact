package org.academiadecodigo.spaceimpact.representable;

/**
 * Created by codecadet on 23/05/16.
 */
public interface Representable {

    int getX();
    int getY();
    int getMaxX();
    int getMaxY();
    int getWidth();
    int getHeight();

    void setX(int newPosX);
    void setY(int newPosY);

    void move(int dx, int dy);
    void hide();

    boolean samePosition(Representable representable);

    boolean isMoveOutOfBounds(int dx, int dy);

    boolean isOutOfBounds();
    boolean isOnVerticalLimits();
    void setIsOnVerticalLimits(boolean isOnVerticalLimits);
    

}

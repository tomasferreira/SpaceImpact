package org.academiadecodigo.spaceimpact.gameobjects;

/**
 * Created by codecadet on 23/05/16.
 */
public enum GameObjectType {
    ENEMYSHIP(10),
    PLAYERSHIP(2),
    PROJECTILE(0);

    private int speed;

    GameObjectType(int speed){
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}

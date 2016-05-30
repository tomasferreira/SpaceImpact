package org.academiadecodigo.spaceimpact.gameobjects;

/**
 * Created by codecadet on 23/05/16.
 */
public enum GameObjectType {
    ENEMYSHIP(3),
    PLAYERSHIP(10),
    PROJECTILE(10);

    private int speed;

    GameObjectType(int speed){
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}

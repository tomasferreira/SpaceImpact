package org.academiadecodigo.spaceimpact.gameobjects;

/**
 * Created by codecadet on 23/05/16.
 */
public enum GameObjectType {
    ENEMYSHIP(10, 1000),
    PLAYERSHIP(3, 150),
    PROJECTILE(2, 0);

    private int speed;
    private int shootPeriodicity;

    GameObjectType(int speed, int shootPeriodicity){
        this.speed = speed;
        this.shootPeriodicity = shootPeriodicity;
    }

    public int getSpeed() {
        return speed;
    }

    public int getShootPeriodicity() {
        return shootPeriodicity;
    }
}

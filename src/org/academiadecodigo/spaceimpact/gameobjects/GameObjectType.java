package org.academiadecodigo.spaceimpact.gameobjects;

/**
 * Created by codecadet on 23/05/16.
 */
public enum GameObjectType {
    ENEMYSHIP(10, 1000, 2),
    PLAYERSHIP(2, 150, 3),
    PROJECTILE(1, 0, 0),
    SPIDERSHIP(10, 1000, 50);

    private int speed;
    private int shootPeriodicity;
    private int lives;


    GameObjectType(int speed, int shootPeriodicity, int lives){
        this.speed = speed;
        this.shootPeriodicity = shootPeriodicity;
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

    public int getSpeed() {
        return speed;
    }

    public int getShootPeriodicity() {
        return shootPeriodicity;
    }
}

package org.academiadecodigo.spaceimpact.gameobjects;
/**
 * @author Tomás Ferreira
 * @author Ana Tomás
 * @author Rodolfo Matos
 */

public enum GameObjectType {
    ENEMYSHIP(10, 1000, 2),
    PLAYERSHIP(2, 150, 3),
    PROJECTILE(1, 0, 0),
    SPIDERSHIP(10, 1000, 50);

    private int speed;
    private int shootPeriodicity;
    private int lives;

    /**
     *
     * Constructor that creates a new instance of the object.
     *
     * @param speed - how frequently the object moves (0 being the fastest)
     * @param shootPeriodicity - how frequently the object shoots (0 being the fastest)
     * @param lives - how many lives the object has
     */

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

package org.academiadecodigo.spaceimpact.gameobjects;

/**
 * Created by codecadet on 31/05/16.
 */
public class Score {


    private int total = 0;
    private int lives;
    private int destroyedEnemyShips = 0;
    private int spiderShipLife;
    private boolean spiderShip;

    public void setSpiderShip(boolean spiderShip) {
        this.spiderShip = spiderShip;
    }

    public boolean hasSpiderShip() {
        return spiderShip;
    }
    //increase score when spider is destroyed <-probably on Game

    public Score(int lives) {
        this.lives = lives;
    }

    public void updateScores(int destroyedEnemies, int lives) {
        this.destroyedEnemyShips = destroyedEnemies;
        this.lives = lives;
    }

    public void updateScoresSpiderShip(int spiderShipLife, int destroyedEnemyShips, int lives){
        this.spiderShipLife = spiderShipLife;
        this.destroyedEnemyShips = destroyedEnemyShips;
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

    public int getTotal() {
        total = destroyedEnemyShips;
        return total;
    }

    public int getDestroyedEnemyShips() {
        return destroyedEnemyShips;
    }

    public int getSpiderShipLife() {
        return spiderShipLife;
    }
}

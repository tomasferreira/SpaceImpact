package org.academiadecodigo.spaceimpact.gameobjects;

/**
 * Created by codecadet on 31/05/16.
 */
public class Score {


    private int total = 0;
    private int destroyedEnemyShips = 0;
    private int lives;

    public Score(int lives) {
        this.lives = lives;
    }

    public void updateScores(int destroyedEnemies, int lives) {
        this.destroyedEnemyShips = destroyedEnemies;
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

}

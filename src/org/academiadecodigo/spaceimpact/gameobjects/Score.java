package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.spaceimpact.gameobjects.spaceships.PlayerShip;

/**
 * Created by codecadet on 31/05/16.
 */
public class Score {


    private int points = 0;
    private int lives;

    public Score(int lives) {
        this.lives = lives;
    }

    public void updateScores(int destroyedEnemies, int lives) {
        this.points = destroyedEnemies;
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

    public int getPoints() {
        return points;
    }

}

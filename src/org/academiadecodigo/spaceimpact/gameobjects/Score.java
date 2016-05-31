package org.academiadecodigo.spaceimpact.gameobjects;

/**
 * Created by codecadet on 31/05/16.
 */
public class Score {


    private int points = 0;


    public void updateScores(int destroyedEnemies) {
        this.points = destroyedEnemies;
    }

    public int getPoints() {
        return points;
    }

}

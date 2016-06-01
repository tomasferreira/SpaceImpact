package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

/**
 * Created by codecadet on 23/05/16.
 */
public enum Direction {
    WEST(),
    EAST(),
    NORTH(),
    SOUTH();


    static Direction getOpposite(Direction dir) {

        Direction oppositeDir = null;

        switch (dir) {

            case WEST:
                oppositeDir = EAST;
                break;
            case EAST:
                oppositeDir = WEST;
                break;
            case NORTH:
                oppositeDir = SOUTH;

                break;
            case SOUTH:
                oppositeDir = NORTH;
                break;
        }


        return oppositeDir;
    }
}

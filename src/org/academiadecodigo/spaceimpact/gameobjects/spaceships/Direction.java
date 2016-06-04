package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

/**
 * @author Tomás Ferreira
 * @author Ana Tomás
 * @author Rodolfo Matos
 */


public enum Direction {
    WEST,
    EAST,
    NORTH,
    SOUTH;


    /**
     * Given a Direction, method returns it's opposite Direction
     * E.g: SOUTH is the opposite of NORTH
     *
     * @param dir - Direction
     * @return the opposite Direction
     */


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

package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.Direction;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that maps a key to a direction
 */

public class KeyToDirectionMapper{


    private static final Map<Integer, Direction> KeyToDirection = new HashMap<>(4);

    static {

        KeyToDirection.put(KeyboardEvent.KEY_RIGHT, Direction.EAST);
        KeyToDirection.put(KeyboardEvent.KEY_LEFT, Direction.WEST);
        KeyToDirection.put(KeyboardEvent.KEY_UP, Direction.NORTH);
        KeyToDirection.put(KeyboardEvent.KEY_DOWN, Direction.SOUTH);

    }

   public static Direction getDirection(Integer key) {
        return KeyToDirection.get(key);
    }

}


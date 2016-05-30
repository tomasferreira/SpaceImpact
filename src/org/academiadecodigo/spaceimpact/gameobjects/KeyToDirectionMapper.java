package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

import java.util.EnumMap;
import java.util.Map;

public class KeyToDirectionMapper{

    private static final Map<Integer, Direction> KeyToDirection = new EnumMap<Integer, Direction>(Direction.class);

    static {

        KeyToDirection.put(KeyboardEvent.KEY_RIGHT, Direction.EAST);
        KeyToDirection.put(KeyboardEvent.KEY_LEFT, Direction.WEST);
        KeyToDirection.put(KeyboardEvent.KEY_UP, Direction.NORTH);
        KeyToDirection.put(KeyboardEvent.KEY_DOWN, Direction.SOUTH);

    }

    /**
     * Get a Lanterna Terminal getColor from a grid getColor
     *
     * @param color the grid getColor
     * @return the lanterna terminal getColor
     */
    public static Direction getDirection(KeyboardEvent kbEvent) {
        return KeyToDirection.get(kbEvent.getKey());
    }

}


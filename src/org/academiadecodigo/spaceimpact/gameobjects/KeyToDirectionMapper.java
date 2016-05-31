package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class KeyToDirectionMapper{

    private static final Map<Integer, Direction> KeyToDirection = new HashMap<>(4);

    static {

        KeyToDirection.put(KeyboardEvent.KEY_RIGHT, Direction.EAST);
        KeyToDirection.put(KeyboardEvent.KEY_LEFT, Direction.WEST);
        KeyToDirection.put(KeyboardEvent.KEY_UP, Direction.NORTH);
        KeyToDirection.put(KeyboardEvent.KEY_DOWN, Direction.SOUTH);

    }

    /**
     * Get a Lanterna Terminal getColor from a grid getColor
     *
     * @param
     * @return the lanterna terminal getColor
     */
    public static Direction getDirection(KeyboardEvent kbEvent) {
        return KeyToDirection.get(kbEvent.getKey());
    }

}

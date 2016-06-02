package org.academiadecodigo.spaceimpact.gameobjects;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

import java.security.Key;
import java.util.*;

/**
 * Created by rodolfomatos on 01/06/16.
 */


public class KeyToIsPressedMapper {

    private static final Map<Integer, Boolean> KeyToIsPressed = new HashMap<>(4);

    static {

        Boolean isRightPressed = false;
        Boolean isLeftPressed = false;
        Boolean isUpPressed = false;
        Boolean isDownPressed = false;
        Boolean isShooting = false;

        KeyToIsPressed.put(KeyboardEvent.KEY_RIGHT, isRightPressed);
        KeyToIsPressed.put(KeyboardEvent.KEY_LEFT, isLeftPressed);
        KeyToIsPressed.put(KeyboardEvent.KEY_UP, isUpPressed);
        KeyToIsPressed.put(KeyboardEvent.KEY_DOWN, isDownPressed);
        KeyToIsPressed.put(KeyboardEvent.KEY_SPACE, isShooting);
    }


    public static LinkedList<Integer> getPressedKeys() {

        Set<Integer> set = KeyToIsPressed.keySet();

        set.iterator();

        LinkedList<Integer> returnList = new LinkedList<>();

        for (Integer key : set) {

            if (KeyToIsPressed.get(key).booleanValue()) {

                returnList.add(key);

            }
        }

        System.out.println(returnList);
        return returnList;
    }

    public static void setKeyPressed(KeyboardEvent kbEvent){

        System.out.println("KeyPressed " + kbEvent.getKey());

        KeyToIsPressed.put(kbEvent.getKey(), true);

        System.out.println(KeyToIsPressed.containsValue(true));
    }

    public static void setKeyReleased(KeyboardEvent kbEvent){

        System.out.println("KeyReleased" + kbEvent.getKey());

        KeyToIsPressed.put(kbEvent.getKey(), false);
    }

    public static boolean isKeyPressed(KeyboardEvent kbEvent){

        return KeyToIsPressed.get(kbEvent);
    }
}


package org.academiadecodigo.spaceimpact;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.spaceimpact.gameobjects.KeyToDirectionMapper;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.representable.Background;
import org.academiadecodigo.spaceimpact.simplegfx.ProjectileRepresentation;
import org.academiadecodigo.spaceimpact.simplegfx.SimpleGfxBackground;

/**
 * Created by codecadet on 25/05/16.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        //TEST STUFF HERE

        Game g = new Game();

        g.init();
        g.start();

        /*
        KeyboardEvent keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_DOWN);
        System.out.println(KeyToDirectionMapper.getDirection(keyboardEvent));
        keyboardEvent.setKey(KeyboardEvent.KEY_RIGHT);
        System.out.println(KeyToDirectionMapper.getDirection(keyboardEvent));
        keyboardEvent.setKey(KeyboardEvent.KEY_LEFT);
        System.out.println(KeyToDirectionMapper.getDirection(keyboardEvent));

        keyboardEvent.setKey(KeyboardEvent.KEY_1);
        System.out.println(KeyToDirectionMapper.getDirection(keyboardEvent));
        */
    }
}

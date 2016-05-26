package org.academiadecodigo.spaceimpact;

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

        Background b = new SimpleGfxBackground();
        b.init(500, 500);

        Projectile projectile = new Projectile(new ProjectileRepresentation(100, 100));

        projectile.move();
        projectile.move();
        projectile.move();
    }
}

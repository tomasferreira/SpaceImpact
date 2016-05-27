package org.academiadecodigo.spaceimpact.gameobjects.spaceships;

import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ProjectileFactory;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.ShootingDirection;
import org.academiadecodigo.spaceimpact.representable.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public class EnemyShip extends Spaceship {

    public EnemyShip(Representable representation) {
        super(representation);
    }

    @Override
    public void shoot() {
        Projectile p = (Projectile) getFactory().createProjectile(ShootingDirection.WEST, getRepresentation().getX(), getRepresentation().getY() + (getRepresentation().getHeight() / 2));
        p.setEnemy(true);
    }

    @Override
    public void move() {

        accelerate(chooseDirection());
        //fazer as representaçoes mexerem-se de acordo com a lógica deste objecto;


        //checar colisoes com metodo
        //getCollisionDetector().isProjectileSafe(this);
    }

}

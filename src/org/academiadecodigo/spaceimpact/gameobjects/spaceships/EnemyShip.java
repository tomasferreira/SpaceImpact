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

    private int counter;

    private int shootCounter;

    public EnemyShip(Representable representation, int maxSpeed) {
        super(representation, maxSpeed);
    }

    @Override
    public void shoot() {
        if (shootCounter == 49){
            getProjectilelist().add((Projectile) getFactory().createProjectile(ShootingDirection.WEST, getRepresentation().getX(), getRepresentation().getY() + (getRepresentation().getHeight() / 2)));
            getProjectilelist().getLast().isEnemy();
            shootCounter = 0;
        }
        else {
            shootCounter++;
        }
        //p.setEnemy(true);
    }

    @Override
    public void move() {

        Direction newDirection = chooseDirection();
        accelerate(chooseDirection());

        for (int i = 0; i < getProjectilelist().size(); i++) {
            getProjectilelist().get(i).move();
        }
        //fazer as representaçoes mexerem-se de acordo com a lógica deste objecto;

        while (counter < 10) {

            accelerate(newDirection);
            getCollisionDetector().checkCollision(this);
            counter++;

        }

        accelerate(Direction.LEFT);
        counter = 0;

        getCollisionDetector().checkCollision(this);
    }

}

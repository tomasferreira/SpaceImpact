package org.academiadecodigo.spaceimpact;

import org.academiadecodigo.spaceimpact.gameobjects.Destroyable;
import org.academiadecodigo.spaceimpact.gameobjects.GameObject;
import org.academiadecodigo.spaceimpact.gameobjects.projectile.Projectile;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.EnemyShip;
import org.academiadecodigo.spaceimpact.gameobjects.spaceships.PlayerShip;
import org.academiadecodigo.spaceimpact.representable.Representable;
import org.academiadecodigo.spaceimpact.simplegfx.SimpleGfxGameObject;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by codecadet on 25/05/16.
 */
public class CollisionDetector {

    private LinkedList<EnemyShip> enemyList;
    private LinkedList<Projectile> projectiles;
    private PlayerShip player;
    private LinkedList<GameObject> objects;

    public CollisionDetector() {
    }

    public void checkCollision(GameObject gameObject) {

       /* objects.addAll(enemyList);
        objects.addAll(projectiles);
        objects.add(player);

        * recebe o objecto que o chama e compara-o com todos os objectos da lista de acordo com objecto recebido
        * set is destroyed dos objectos envolvidos na colisão
        * verificar a área da representação do objecto a partir da sua largura e altura
        * se for uma bala "is enemy" a detectar colisão com um enemy não há colisão *


        //TODO comparar posição do player com a do projectile
        if (gameObject instanceof Destroyable) {

            GameObject iterator = objects.get(0);

            for (int i = 0; i < objects.size(); i++) {

                if (gameObject instanceof Projectile && iterator instanceof EnemyShip && ((Projectile) gameObject).isEnemy()) {
                    return;
                }

                if (gameObject instanceof EnemyShip && iterator instanceof Projectile && ((Projectile) iterator).isEnemy()) {
                    return;
                }
                // compare object representations to see if they overlap, if yes, destroy the objects involved
                if ((gameObject.getRepresentation().getX() < (iterator.getRepresentation().getX() +
                        iterator.getRepresentation().getWidth()) && (gameObject.getRepresentation().getX() +
                        gameObject.getRepresentation().getWidth()) > iterator.getRepresentation().getX()) ||
                        (gameObject.getRepresentation().getY() < (iterator.getRepresentation().getY() +
                                iterator.getRepresentation().getHeight()) && (gameObject.getRepresentation().getY() +
                                gameObject.getRepresentation().getHeight()) > iterator.getRepresentation().getY())) {

                    ((Destroyable) iterator).destroy();
                    ((Destroyable) gameObject).destroy();
                }
            }
        }
    }

    public void setEnemyList(LinkedList<EnemyShip> enemyList) {
        this.enemyList = enemyList;
    }

    public void setProjectiles(LinkedList<Projectile> projectiles) {
        this.projectiles = projectiles;
    }

    public void setPlayer(PlayerShip player) {
        this.player = player;
    }*/
    }
}

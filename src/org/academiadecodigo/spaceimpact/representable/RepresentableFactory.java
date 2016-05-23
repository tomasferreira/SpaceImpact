package org.academiadecodigo.spaceimpact.representable;

import org.academiadecodigo.spaceimpact.gameobjects.Direction;
import org.academiadecodigo.spaceimpact.gameobjects.GameObjectType;

/**
 * Created by codecadet on 23/05/16.
 */
public interface RepresentableFactory {

    Representable createRepresentation(GameObjectType type, int posX, int posY);

    Representable createRepresentation(GameObjectType type, int posX, int posY, Direction direction);

}

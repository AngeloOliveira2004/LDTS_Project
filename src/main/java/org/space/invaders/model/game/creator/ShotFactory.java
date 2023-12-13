package org.space.invaders.model.game.creator;

import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.MiniShot;
import org.space.invaders.model.game.elements.Shot;
import org.space.invaders.model.game.elements.ShotElement;

public class ShotFactory {
    public ShotElement createShot(Position position) {
        Position position_ = new Position(position.x + 8 , position.y - 4);
        return new Shot(position_ , 4 , 5);
    }
    public ShotElement createMiniShot(Position position)
    {
        Position position_ = new Position(position.x + 3 , position.y - 4);
        return new MiniShot(position_, 1);
    }
    public ShotElement createEnemyShot(Position position) {
        Position position_ = new Position(position.x + 8 , position.y - 4);
        return new Shot(position_ , -1 , 5);
    }
}


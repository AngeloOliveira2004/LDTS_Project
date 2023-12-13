package org.space.invaders.control.game;

import org.space.invaders.model.Position;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.model.game.elements.Shot;
import org.space.invaders.model.game.elements.ShotElement;

public class ShotController {
    private ShotElement shot;
    public ShotController(ShotElement shot)
    {
        this.shot = shot;
    }
    public void update()
    {
        Position position = new Position(shot.getXposition() , shot.getYposition() - shot.getYVelocity());
        shot.setPosition(position);
    }
}
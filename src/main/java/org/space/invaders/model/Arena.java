package org.space.invaders.model;


import org.space.invaders.model.game.elements.Shot;
import org.space.invaders.model.game.SpaceShip;

import java.util.ArrayList;

public class Arena {
    //Add enimies and enimies list
    private final SpaceShip spaceShip;
    private final ArrayList<Position> starPositions;

    public Arena()
    {
        this.starPositions = new ArrayList<>();
        this.spaceShip = new SpaceShip();
    }

    public void update()
    {

    }

    public void getScore()
    {

    }
}

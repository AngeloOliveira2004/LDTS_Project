package org.space.invaders.model.game.elements;

import org.space.invaders.model.Position;

import java.awt.*;

public class MiniSpaceShip extends Element{
    private boolean invincible;
    public MiniSpaceShip(int x, int y, int Yvelocity, int Xvelocity, int Health, int SpawnRate , boolean alive , int height , int width) {
        super(x, y, Yvelocity, Xvelocity, Health, SpawnRate , alive , height , width);
    }
    private boolean getInvencibility(){return invincible;}
    private void setInvincible(boolean invincible){this.invincible = invincible;}

}

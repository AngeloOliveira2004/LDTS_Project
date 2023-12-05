package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;
import org.space.invaders.view.game.MiniSpaceShipView;

import java.awt.*;

public class MiniSpaceShip extends Element{
    private boolean invincible;
    private boolean visible;
    private boolean shooting;
    MiniSpaceShipView miniSpaceShipView;

    public MiniSpaceShip(int x, int y, int Yvelocity, int Xvelocity, int Health, int SpawnRate , boolean alive , int height , int width) {
        super(x, y, Yvelocity, Xvelocity, Health, SpawnRate , alive , height , width);
        visible = false;
    }
    public boolean getInvencibility(){return invincible;}
    public void setInvincible(boolean invincible){this.invincible = invincible;}
    public void setVisible(boolean visible){this.visible = visible;}
    public boolean getShoot(){return shooting;}
    private void setShoot(boolean shoot){this.shooting = shoot;}
    public boolean getVisible(){return visible;}
    public void shot()
    {
        if(shooting)
        {
            //TODO creator create shot
        }
    }
    public void draw(TextGraphics textGraphics)
    {

    }

}

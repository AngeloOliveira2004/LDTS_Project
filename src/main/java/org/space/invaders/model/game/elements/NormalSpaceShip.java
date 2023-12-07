/*package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.view.game.NormalSpaceShipView;

public class NormalSpaceShip extends Element {
    private boolean invincible;
    private boolean visible;
    private boolean shoot;
    private NormalSpaceShipView normalSpaceShipView;
    public NormalSpaceShip(int x, int y, int Yvelocity, int Xvelocity, int Health, int SpawnRate , boolean alive , int height , int width) {
        super(x, y, Yvelocity, Xvelocity, Health, SpawnRate , alive , height , width);
        visible = true;
    }

    public boolean getInvencibility(){return invincible;}
    public void setInvincible(boolean invincible){this.invincible = invincible;}
    public void setVisible(boolean visible){this.visible = visible;}
    public boolean getVisible(){return visible;}
    public boolean getShoot(){return shoot;}
    private void setShoot(boolean shoot){this.shoot = shoot;}

    public void shot()
    {
        //TODO actually shot
    }
    public void draw(TextGraphics textGraphics)
    {
        normalSpaceShipView = new NormalSpaceShipView(this , textGraphics);
        normalSpaceShipView.draw();
    }
}
*/
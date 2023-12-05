package org.space.invaders.model.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.Terminal;

import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.Element;
import org.space.invaders.view.game.NormalSpaceShipView;
import org.space.invaders.view.game.SpaceshipView;


public class SpaceShip extends Element {
    private boolean invincible;
    private boolean shooting;
    private boolean isMini;
    private SpaceshipView spaceshipView;

    public SpaceShip(int x, int y, int Yvelocity, int Xvelocity, int Health, int SpawnRate , boolean alive , int height , int width) {
        super(x, y, Yvelocity, Xvelocity, Health, SpawnRate , alive , height , width);
        this.isMini = false;
    }
    public boolean isInvincible() {
        return invincible;
    }

    public void setInvincible(boolean invincible) {
        this.invincible = invincible;
    }
    public boolean isShooting() {
        return shooting;
    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }

    public boolean isMini() {
        return isMini;
    }

    public void toggleMini(boolean mini) {
        isMini = mini;
    }
    public void shot()
    {
        //TODO actually shot
    }
    public void miniShot()
    {

    }
    public void draw(TextGraphics textGraphics)
    {
        spaceshipView = new SpaceshipView(this , textGraphics);
        spaceshipView.draw();
    }

}


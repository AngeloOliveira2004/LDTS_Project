package org.space.invaders.model.game.elements;

public class Asteroid extends Element{
    public Asteroid(int x, int y, int Yvelocity, int Xvelocity, int Health, int SpawnRate , boolean alive , int height , int width) {
        super(x, y, Yvelocity, Xvelocity, Health, SpawnRate , alive , height , width);
    }
    public boolean getInvincible()
    {
        return true;
    }
    public void draw(){}
}

package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;

import org.space.invaders.model.Position;

public class Element {
    private Position position;
    private int  Yvelocity ;
    private int  Xvelocity ;
    private int Health ;
    private int SpawnRate;

    public Element(int x, int y, int Yvelocity, int Xvelocity, int Health, int SpawnRate)
    {
        this.position = new Position(x , y);
        this.Yvelocity = Yvelocity;
        this.Xvelocity = Xvelocity;
        this.Health = Health;
        this.SpawnRate = SpawnRate;

    }
    public Position getPosition() {
        return this.position;
    }
    public int getXposition()
    {
        return position.getX();
    }
    public int getYposition()
    {
        return position.getY();
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    //void draw(TextGraphics screen);
    int getHealth()
    {
        return Health;
    }
    void setHealth(int health)
    {
        this.Health = Health;
    }
    int getSpawnRate()
    {
        return SpawnRate;
    }
    void setSpawnRate(int spawnRate)
    {
        this.SpawnRate = spawnRate;
    }
    int getYVelocity()
    {
        return Yvelocity;
    }
    void setYVelocity(int yVelocity)
    {
        this.Yvelocity = yVelocity;
    }
    int getXVelocity()
    {
        return Xvelocity;
    }
    void setXVelocity(int xVelocity)
    {
        this.Xvelocity = xVelocity;
    }

}


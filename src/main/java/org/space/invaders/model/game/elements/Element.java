package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.Constants;

import org.space.invaders.model.Position;
import org.space.invaders.model.game.Collider;

import javax.swing.text.StyledEditorKit;

import static org.space.invaders.Constants.WIDTH;
import static org.space.invaders.Constants.HEIGHT;

public abstract class Element implements Collider{
    private Position position;
    private int Yvelocity ;
    private int Xvelocity ;
    private int Health ;
    private int SpawnRate;
    private boolean alive;
    private int height;
    private int width;
    public Element(int x, int y, int Yvelocity, int Xvelocity, int Health, int SpawnRate , boolean alive , int height , int width)
    {
        this.position = new Position(x , y);
        this.Yvelocity = Yvelocity;
        this.Xvelocity = Xvelocity;
        this.Health = Health;
        this.SpawnRate = SpawnRate;
        this.alive = true;
        this.height = height;
        this.width = width;
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
    public void dies()
    {
        this.alive = false;
    }
    public boolean isAlive(){return alive;}

    public void moveFoward()
    {
        Position previousPosition = getPosition();
        position.y -= getYVelocity();
        if(isInsideBorders())
        {
            return;
        }
        position = previousPosition;
    }
    public void moveBackwards()
    {
        Position previousPosition = getPosition();
        position.y += getYVelocity();
        if(isInsideBorders())
        {
            return;
        }
        position = previousPosition;
    }
    public void moveLeft()
    {
        Position previousPosition = getPosition();
        position.x -= getXVelocity();
        if(isInsideBorders())
        {
            return;
        }
        position = previousPosition;
    }
    public void moveRight()
    {
        Position previousPosition = getPosition();
        position.x += getXVelocity();
        if(isInsideBorders())
        {
            return;
        }
        position = previousPosition;
    }
    public boolean isInsideBorders()
    {
        return (getPosition().x > 0 && getPosition().x < WIDTH && getPosition().y > 0 && getPosition().y < HEIGHT);
    }
    public abstract void draw(TextGraphics textGraphics);
}


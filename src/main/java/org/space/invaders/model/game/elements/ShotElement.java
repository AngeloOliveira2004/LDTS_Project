package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;

import java.time.Year;

import static org.space.invaders.Constants.HEIGHT;
import static org.space.invaders.Constants.WIDTH;

public abstract class ShotElement {
    private Position position;
    private int damage;
    private int yVelocity ;
    public ShotElement(Position position , int yVelocity , int damage)
    {
        this.position = position;
        this.yVelocity = yVelocity;
        this.damage = damage;
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

    public void setYPosition(int y)
    {
        position = new Position(position.x , y);
    }
    public int getYVelocity()
    {
        return yVelocity;
    }
    public void setYVelocity(int yVelocity)
    {
        this.yVelocity = yVelocity;
    }
    public boolean isInsideBorders()
    {
        return (getPosition().x > 0 && getPosition().x < WIDTH && getPosition().y > 0 && getPosition().y < HEIGHT);
    }
    public abstract void draw(TextGraphics textGraphics);
    public int getDamage(){return damage;}
}

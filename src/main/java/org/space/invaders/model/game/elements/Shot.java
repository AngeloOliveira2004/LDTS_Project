package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;

import java.security.PublicKey;


public class Shot extends ShotElement {
    private int count;
    public Shot(Position position , int yVelocity)
    {
        super(position , yVelocity);
        count = 0;
    }
    public void addCount()
    {
        count++;
    }
    public void resetCount()
    {
        count = 0;
    }
    public int getCount()
    {
        return count;
    }
}

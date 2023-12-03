package org.space.invaders.model.game.elements;

import org.space.invaders.model.Position;
import org.space.invaders.view.game.SuperShotVIew;

public class SuperShot extends ShotElement{
    private int count;
    private int iterations;
    public SuperShot(Position position , int yVelocity)
    {
        super(position , yVelocity);
        iterations = 0;
        count = 5;
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
    public int getIterations()
    {
        return iterations;
    }
    public void incrementIterations(){iterations++;}
    public void resetIterations(){iterations = 0;}
}

package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;
import org.space.invaders.view.game.SuperShotView;

public class SuperShot extends ShotElement{
    private SuperShotView superShotVIew;
    private int count;
    private int iterations;
    public SuperShot(Position position , int yVelocity , int damage)
    {
        super(position , yVelocity , 20);
        iterations = 0;
        count = 5;
    }

    @Override
    public void draw(TextGraphics textGraphics) {
        superShotVIew = new SuperShotView(this , textGraphics);
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

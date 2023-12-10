package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;
import org.space.invaders.view.game.ShotView;
import org.space.invaders.view.game.SpaceshipView;

import java.security.PublicKey;


public class Shot extends ShotElement {
    private ShotView shotView;
    private int count;
    public Shot(Position position , int yVelocity , int damage)
    {
        super(position , yVelocity , damage);
        count = 0;
    }
    @Override
    public void draw(TextGraphics textGraphics) {
        shotView = new ShotView(textGraphics, this);
        shotView.draw();
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

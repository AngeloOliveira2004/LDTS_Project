package org.space.invaders.spaceInvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.Position;

public class Shot extends Position{

    private int yVelocity = -1;
    private boolean update = true;
    public Shot(int x , int y) {
        super(x , y);
    }
    public void draw(TextGraphics screen)
    {
        while(getY() > 0)
        {
            if(update)
            {
                TextCharacter character = new TextCharacter('|');
                character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                character = character.withForegroundColor(TextColor.ANSI.YELLOW);
                screen.setCharacter(getX(), getY() - 1, character);
                update = false;
            }

            setY(getY()+yVelocity);

            if(getY() % 5  == 0)
            {
                TextCharacter character = new TextCharacter('|');
                character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                character = character.withForegroundColor(TextColor.ANSI.YELLOW);
                screen.setCharacter(getX(), getY(), character);
            }

        }
    }
}

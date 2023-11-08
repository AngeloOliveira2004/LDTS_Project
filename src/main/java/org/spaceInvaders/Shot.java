package org.spaceInvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Shot {

    private int yVelocity = -1;
    Position position;
    private boolean update = true;
    public Shot(int x , int y) {
        this.position = new Position(x , y);
    }
    public void draw(TextGraphics screen)
    {
        while(position.getY() > 0)
        {
            if(update)
            {
                TextCharacter character = new TextCharacter('|');
                character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                character = character.withForegroundColor(TextColor.ANSI.YELLOW);
                screen.setCharacter(position.getX(), position.getY() - 1, character);
                update = false;
            }
            position.setY((int) (position.getY()+yVelocity));
            if(position.getY() % 5  == 0)
            {
                TextCharacter character = new TextCharacter('|');
                character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                character = character.withForegroundColor(TextColor.ANSI.YELLOW);
                screen.setCharacter(position.getX(), position.getY(), character);
            }

        }
    }
}

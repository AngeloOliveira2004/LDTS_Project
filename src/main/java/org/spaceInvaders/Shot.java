package org.spaceInvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Shot {

    private int yVelocity = -2;
    Position position;
    public Shot(int x , int y) {
        this.position = new Position(x , y);
    }

    public void draw(TextGraphics screen)
    {
        while(position.getY() > 0)
        {
            position.setY(position.getY()+yVelocity);

            TextCharacter character = new TextCharacter('|');
            character = character.withBackgroundColor(TextColor.ANSI.BLACK);
            character = character.withForegroundColor(TextColor.ANSI.YELLOW);
            screen.setCharacter(position.getX(), position.getY(), character);
        }
    }
}

package org.spaceInvaders;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class SpaceShip{

    org.spaceInvaders.Position position;
    SpaceShip(int x, int y) {
        super();
        // You can set x and y values for the spaceship here if needed
        position = new org.spaceInvaders.Position(x , y);
    }

    public int getPosX()
    {
        return position.getX();
    }
    public int getPosY()
    {
        return position.getY();
    }

    public void setPositionX(int x)
    {
        position.setX(x);
    }
    public void setPositionY(int y)
    {
        position.setY(y);
    }
    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(new TerminalPosition(position.getX(), position.getY()), "V");
    }
}

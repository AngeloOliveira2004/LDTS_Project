package org.spaceInvaders;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.MouseAction;
import com.googlecode.lanterna.input.MouseActionType;

import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;

public class SpaceShip{
    org.spaceInvaders.Position position;
    private int orientation;
    private static final char[] shipCharacters = { '^', '/', '>', '\\', 'V', '\\' , '<', '/' };
    private static final int characterCount = shipCharacters.length;
    SpaceShip(int x, int y) {
        super();
        // You can set x and y values for the spaceship here if needed
        position = new org.spaceInvaders.Position(x , y);
        this.orientation = 0;
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


    public void rotateClockwise() {
        orientation = (orientation + 10) % 360;  // Rotate clockwise by 10 degrees
    }

    public void rotateCounterClockwise() {
        orientation = (orientation - 10 + 360) % 360;  // Rotate counterclockwise by 10 degrees
    }

    public void updateOrientationBasedOnMouse(int mouseX, int mouseY) {

        int dx = mouseX - position.getX();
        int dy = mouseY - position.getY();

        // Calculate the angle (in degrees) from the spaceship to the mouse
        orientation = (int) Math.toDegrees(Math.atan2(dy, dx));
    }

    private char getRotatedCharacter(int degrees) {
        // Rotate the character by adjusting its ASCII code based on the orientation
        int characterIndex = (degrees / (360 / characterCount)) % characterCount;
        return shipCharacters[characterIndex];
    }

    public void draw(TextGraphics screen) {
        // Calculate the character index based on the orientation
        int characterIndex = (orientation / (360 / characterCount)) % characterCount;

        // Clear the previous character at the spaceship's position
        screen.setCharacter(new TerminalPosition(position.getX(), position.getY()), new TextCharacter(' '));

        // Draw the rotated spaceship character
        TextCharacter character = new TextCharacter(shipCharacters[characterIndex]);
        character = character.withBackgroundColor(TextColor.ANSI.BLACK);
        character = character.withForegroundColor(TextColor.ANSI.YELLOW);
        screen.setCharacter(new TerminalPosition(position.getX(), position.getY()), character);
    }

}

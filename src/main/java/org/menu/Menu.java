package org.menu;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.MouseAction;
import com.googlecode.lanterna.input.MouseActionType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.spaceInvaders.Position;

import java.awt.*;
import java.io.IOException;
public class Menu {

    private static final String Title = "Space Invaders";
    private static final String Kinda = "kinda";

    private Position position;
    public Menu(int x , int y)
    {
        position = new Position(x , y);
    }
    public void draw(TextGraphics screen) {
        // Clear the screen
        screen.fill(' ');

        // Set the text attributes for the Title (yellow, white background)
        screen.setForegroundColor(TextColor.ANSI.YELLOW);

        for (int i = 0; i < Title.length(); i++) {
            int yOffset = (int) (Math.sin((i * 0.5 + System.currentTimeMillis() / 200) * Math.PI) * 3); // Adjust the amplitude (3) as needed
            screen.putString(position.getX() + i, position.getY() + yOffset, Title.substring(i, i + 1));
        }

        // Reset text attributes for Kinda (white, black background)
        screen.setForegroundColor(TextColor.ANSI.WHITE);

        for (int i = 0; i < Kinda.length(); i++) {
            int yOffset = (int) (Math.sin((i * 0.5 + System.currentTimeMillis() / 200.0) * Math.PI) * 3); // Adjust the amplitude (3) as needed
            screen.putString(position.getX() + Title.length() + 2 + i  , position.getY() + yOffset, Kinda.substring(i, i + 1));
        }

        // Reset text attributes for the rest
        screen.setForegroundColor(TextColor.ANSI.DEFAULT);
        screen.setBackgroundColor(TextColor.ANSI.DEFAULT);
    }


}

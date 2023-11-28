package org.space.invaders.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;


import org.space.invaders.model.Position;
import java.io.IOException;
import java.util.ArrayList;

public class LanternaGUI implements GUI{
    @Override
    public ACTION getNextAction() throws IOException {
        return null;
    }

    @Override
    public void drawSpaceShip(TextGraphics screen, Position position, char[][] spaceShipShape) {
        screen.setForegroundColor(TextColor.ANSI.YELLOW);

        for(int x = 0 ; x < spaceShipShape.length ; x++)
        {
            for(int y = 0; y < spaceShipShape[0].length ; y++)
            {
                if(spaceShipShape[x][y] != '0')
                {
                    TextCharacter character = new TextCharacter(spaceShipShape[x][y]);
                    character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                    character = character.withForegroundColor(TextColor.ANSI.YELLOW);
                    screen.setCharacter(position.x + y, position.y + x, character);
                }
                else
                {
                    TextCharacter character = new TextCharacter(spaceShipShape[x][y]);
                    character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                    character = character.withForegroundColor(TextColor.ANSI.BLACK);
                    screen.setCharacter(position.x + y, position.y + x, character);
                }
            }
        }
    }

    @Override
    public void drawShot(TextGraphics screen, Position position, char[][] ShotShape , int yVelocity) {
        boolean update = true;
        while(position.y > 0)
        {
            if(update)
            {
                TextCharacter character = new TextCharacter('|');
                character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                character = character.withForegroundColor(TextColor.ANSI.YELLOW);
                screen.setCharacter(position.x, position.y - 1, character);
                update = false;
            }

            position.setY(position.y+yVelocity);

            if(position.y % 5  == 0)
            {
                TextCharacter character = new TextCharacter('|');
                character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                character = character.withForegroundColor(TextColor.ANSI.YELLOW);
                screen.setCharacter(position.x, position.y, character);
            }

        }
    }

    @Override
    public void drawStars(TextGraphics screen, ArrayList<Position> StarPositions) {

    }

    @Override
    public void drawEnemies(TextGraphics screen, ArrayList<Position> EnemiesPosition, ArrayList<char[][]> enemiesShape) {

    }

    @Override
    public void drawHealth(TextGraphics screen, Position position, String text, String color) {

    }
    @Override
    public void clear() {

    }

    @Override
    public void refresh() throws IOException {

    }

    @Override
    public void close() throws IOException {

    }
}

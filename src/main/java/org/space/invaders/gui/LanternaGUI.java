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
import com.googlecode.lanterna.terminal.Terminal;
import java.util.ArrayList;
import java.util.List;


import org.space.invaders.model.Position;
import java.io.IOException;
import java.util.ArrayList;

public class LanternaGUI implements GUI{
    private final TextGraphics screen;
    public LanternaGUI(TextGraphics screen) {
        this.screen = screen;
    }
    @Override
    public ACTION getNextAction() throws IOException {
        return null;
    }

    @Override
    public void drawSpaceShip(Position position, char[][] spaceShipShape) {
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
    public void drawShot(Position position, char[][] ShotShape , int yVelocity) {
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
    public void drawStars(ArrayList<Position> StarPositions) {
        TextCharacter character = new TextCharacter('*');
        for(Position position : StarPositions)
        {
            screen.setCharacter(position.x , position.y , character);
        }
    }

    @Override
    public void drawEnemies(ArrayList<Position> EnemiesPosition, ArrayList<char[][]> enemiesShape) {
        screen.setForegroundColor(TextColor.ANSI.YELLOW);

        for(char[][] enemyShape : enemiesShape)
        {
            for(int x = 0 ; x < enemyShape.length ; x++)
            {
                Position position = EnemiesPosition.get(x);
                for(int y = 0; y < enemyShape[0].length ; y++)
                {
                    if(enemyShape[x][y] != '0')
                    {
                        TextCharacter character = new TextCharacter(enemyShape[x][y]);
                        character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                        character = character.withForegroundColor(TextColor.ANSI.YELLOW);
                        screen.setCharacter(position.x + y, position.y + x, character);
                    }
                    else
                    {
                        TextCharacter character = new TextCharacter(enemyShape[x][y]);
                        character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                        character = character.withForegroundColor(TextColor.ANSI.BLACK);
                        screen.setCharacter(position.x + y, position.y + x, character);
                    }
                }
            }
        }
    }

    @Override
    public void drawHealth(Position position, String text, String color) {

    }

    @Override
    public void drawText(Position position , String text)
    {

    }
    @Override
    public void clear() {
        screen.fill(' ');
    }


    @Override
    public void close() throws IOException {

    }
}

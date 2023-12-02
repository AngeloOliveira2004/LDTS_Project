package org.space.invaders.gui;

import com.googlecode.lanterna.SGR;
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
    private final Screen screen;
    private  TextGraphics textGraphics;
    public LanternaGUI(int screenWidth , int screenHeight) throws Exception {
        Terminal terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(screenWidth, screenHeight))
                .createTerminal();

        this.screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        // Start the screen
        screen.startScreen();

        textGraphics = screen.newTextGraphics();
    }
    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }
    private TextCharacter createColoredCharacter(char character, TextColor foregroundColor, TextColor backgroundColor) {
        TextCharacter textCharacter = new TextCharacter(character);
        textCharacter = textCharacter.withForegroundColor(foregroundColor);
        textCharacter = textCharacter.withBackgroundColor(backgroundColor);
        return textCharacter;
    }
    @Override
    public ACTION getNextAction() throws IOException {
        return null;
    }

    @Override
    public void drawSpaceShip(Position position, char[][] spaceShipShape) {
        textGraphics.setForegroundColor(TextColor.ANSI.YELLOW);

        for(int x = 0 ; x < spaceShipShape.length ; x++)
        {
            for(int y = 0; y < spaceShipShape[0].length ; y++)
            {
                if(spaceShipShape[x][y] != '0')
                {
                    TextCharacter textCharacter = createColoredCharacter(spaceShipShape[x][y], TextColor.ANSI.YELLOW, TextColor.ANSI.BLACK);
                    textGraphics.setCharacter(position.x + y, position.y + x, textCharacter);
                }
                else
                {
                    TextCharacter textCharacter = createColoredCharacter(spaceShipShape[x][y], TextColor.ANSI.YELLOW, TextColor.ANSI.BLACK);
                    textGraphics.setCharacter(position.x + y, position.y + x, textCharacter);
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
                TextCharacter textCharacter = createColoredCharacter('|', TextColor.ANSI.YELLOW, TextColor.ANSI.BLACK);
                textGraphics.setCharacter(position.x, position.y - 1, textCharacter);
                update = false;
            }

            position.setY(position.y+yVelocity);

            if(position.y % 5  == 0)
            {
                TextCharacter textCharacter = createColoredCharacter('|', TextColor.ANSI.YELLOW, TextColor.ANSI.BLACK);
                textGraphics.setCharacter(position.x, position.y, textCharacter);
            }
        }
    }

    @Override
    public void drawStars(ArrayList<Position> StarPositions) {
        TextCharacter character = new TextCharacter('*');
        for(Position position : StarPositions)
        {
            textGraphics.setCharacter(position.x , position.y , character);
        }
    }

    @Override
    public void drawEnemies(ArrayList<Position> EnemiesPosition, ArrayList<char[][]> enemiesShape) {
        textGraphics.setForegroundColor(TextColor.ANSI.YELLOW);

        for(char[][] enemyShape : enemiesShape)
        {
            for(int x = 0 ; x < enemyShape.length ; x++)
            {
                Position position = EnemiesPosition.get(x);
                for(int y = 0; y < enemyShape[0].length ; y++)
                {
                    if(enemyShape[x][y] != '0')
                    {
                        TextCharacter textCharacter = createColoredCharacter(enemyShape[x][y], TextColor.ANSI.YELLOW, TextColor.ANSI.BLACK);
                        textGraphics.setCharacter(position.x + y, position.y + x, textCharacter);
                    }
                    else
                    {
                        TextCharacter textCharacter = createColoredCharacter(enemyShape[x][y], TextColor.ANSI.BLACK, TextColor.ANSI.BLACK);
                        textGraphics.setCharacter(position.x + y, position.y + x, textCharacter);
                    }
                }
            }
        }
    }

    @Override
    public void drawHealth(Position position, String text, String color) {

    }

    @Override
    public void drawText(Position position , String text, String color, String modifier)
    {
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.putString(position.x, position.y,text, SGR.valueOf(modifier));
    }

    @Override
    public void clear() {
        screen.clear();
    }


    @Override
    public void close() throws IOException {
        screen.close();
    }

    @Override
    public void refresh(){
        try {
            screen.refresh();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

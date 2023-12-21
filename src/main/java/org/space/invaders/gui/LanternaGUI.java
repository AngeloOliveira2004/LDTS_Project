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
    public Screen getScreen(){
        return screen;
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
    public void setTextGraphics(TextGraphics textGraphics){
        this.textGraphics = textGraphics;
    }
}

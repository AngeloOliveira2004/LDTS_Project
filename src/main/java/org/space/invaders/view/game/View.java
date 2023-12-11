package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;
import org.space.invaders.view.Viewer;
import org.space.invaders.view.Color;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public abstract class View extends Viewer {
    protected int charWidth;
    protected int charHeight;
    protected TextGraphics graphics;
    public View(int charWidth ,int charHeight, TextGraphics textGraphics){
        this.charWidth = charWidth;
        this.charHeight = charHeight;
        this.graphics = textGraphics;
    }
    public TextGraphics getGraphics() {
        return graphics;
    }
    public void setGraphics(TextGraphics graphics) {
        this.graphics = graphics;
    }
    public void setForegroundColor(Color color){
        getGraphics().setForegroundColor( color.getColor());
    }
    public void setBackgroundColor(Color color){
        getGraphics().setBackgroundColor( color.getColor());
    }
    public void setColor(char colorChar){
        Color color = Color.getColor(colorChar);
        if (color != null) {
            setBackgroundColor(color);
        }
    }
    public void setColorForeground(char colorChar)
    {
        Color color = Color.getColor(colorChar);
        if (color != null) {
            setForegroundColor(color);
        }
    }
    public void drawLine(String line, int X, int Y , ArrayList<Position> positions){
        int x = 0;
        for (char c : line.toCharArray()){
            if (c!=' '){
                setColor(c);
                graphics.fillRectangle(new TerminalPosition(X + x, Y),
                        new TerminalSize(charWidth, charHeight), ' ');
                positions.add(new Position(X + x , Y));
            }
            x+=charWidth;
        }
    }
    public void drawImage(String[] image, int x, int Y , ArrayList<Position> positions) {
        int y = Y;
        for (String line : image){
            drawLine(line, x, y , positions);
            y+=charHeight;
        }
    }

    public void drawNumbers(char number , int x , int y)
    {
        setColor('W');
        graphics.fillRectangle(new TerminalPosition(x, y),
                new TerminalSize(charWidth, charHeight), number);

    }

    public abstract void draw() throws IOException;
}

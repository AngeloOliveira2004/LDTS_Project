package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import org.space.invaders.gui.GUI;
import org.space.invaders.view.Viewer;

import java.awt.*;
import java.io.IOException;

public abstract class View extends Viewer {
    protected int charWidth;
    protected int charHeight;

    protected TextGraphics graphics;
    public View(int charWidth ,int charHeight){
        this.charWidth = charWidth;
        this.charHeight = charHeight;
    }
    public TextGraphics getGraphics() {
        return graphics;
    }
    public void setGraphics(TextGraphics graphics) {
        this.graphics = graphics;
    }
    public void setForegroundColor(Color color){
        getGraphics().setForegroundColor((TextColor) color);
    }
    public void setBackgroundColor(Color color){
        getGraphics().setBackgroundColor((TextColor) color);
    }
    public void setColor(char color){
        Color c = Color.getColor(String.valueOf(color));
        if (c!=null)
            setBackgroundColor(c);
    }
    public void drawLine(String line, int X, int Y){
        int x = 0;
        for (char c : line.toCharArray()){
            if (c!=' '){
                setColor(c);
                graphics.fillRectangle(new TerminalPosition(X + x, Y),
                        new TerminalSize(charWidth, charHeight), ' ');
            }
            x+=charWidth;
        }
    }
    public void drawImage(String[] image, int x, int Y) {
        int y = Y;
        for (String line : image){
            drawLine(line, x, y);
            y+=charHeight;
        }
    }
    public abstract void draw() throws IOException;
}

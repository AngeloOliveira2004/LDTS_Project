package org.space.invaders.view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import org.space.invaders.gui.GUI;
import org.space.invaders.gui.MenuGUI;

import java.awt.*;
import java.io.IOException;

public abstract class Viewer<T>{

    protected TextGraphics graphics;
    private TerminalScreen screen;
    private Font font;
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void start() throws IOException {
        AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true,
                AWTTerminalFontConfiguration.BoldMode.NOTHING, getFont());
        Terminal terminal = new DefaultTerminalFactory()
                .setForceAWTOverSwing(true)
                .setInitialTerminalSize(getSize())
                .setTerminalEmulatorFontConfiguration(cfg)
                .createTerminal();

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        setGraphics(screen.newTextGraphics());
    }
    public void drawMenu(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        //gui.refresh();
    }
    protected abstract void drawElements(GUI gui);
    public void refresh() throws IOException {
        screen.refresh();
    }
    public void close() throws IOException {
        screen.close();
    }
    public void setForegroundColor(Color color){
        graphics.setForegroundColor((TextColor) color);
    }
    public void setBackgroundColor(Color color){
        graphics.setBackgroundColor((TextColor) color);
    }
    public TextGraphics getGraphics()
    {
        return graphics;
    }
    public abstract TerminalSize getSize();
    public TerminalScreen getScreen() {
        return screen;
    }
    public void setGraphics(TextGraphics graphics) {
        this.graphics = graphics;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }
}


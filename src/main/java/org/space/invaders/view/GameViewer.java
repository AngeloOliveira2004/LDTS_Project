package org.space.invaders.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.space.invaders.control.GameController;
import org.space.invaders.model.Arena;
import org.space.invaders.model.game.elements.Element;
import org.space.invaders.model.game.elements.ShotElement;
import org.space.invaders.states.ApplicationState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class GameViewer {
    private Screen screen;
    private TextGraphics textGraphics;
    private GameController gameController;
    //private AWTTerminalFrame frame;
    public GameViewer(GameController gameController) throws IOException {
        this.gameController = gameController;

        Font myFont = new Font("Monospaced", Font.PLAIN, 10);
        AWTTerminalFontConfiguration myFontConfiguration = AWTTerminalFontConfiguration.newInstance(myFont);
        DefaultTerminalFactory dtf = new DefaultTerminalFactory();
        dtf.setForceAWTOverSwing(true);
        dtf.setTerminalEmulatorFontConfiguration(myFontConfiguration);
        dtf.setInitialTerminalSize(new TerminalSize(200, 100));

        Terminal terminal = dtf.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.startScreen();
        textGraphics = screen.newTextGraphics();

    }

    public void drawElements(Arena arena) {
        // TODO: Implement drawing game elements based on the game state
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.fillRectangle(new TerminalPosition(0, 0), screen.getTerminalSize(), ' ');

        for(Element element : arena.getObjects())
        {
            element.draw(textGraphics);
        }
        System.out.println(arena.getShots().size());
        for(ShotElement shotElement : arena.getShots())
        {
            shotElement.draw(textGraphics);
        }
        refresh();
    }

    public void refresh() {
        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public KeyStroke handleInput() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        return keyStroke;
    }
    public void close() throws IOException {
        screen.close();
    }
    public TextGraphics getTextGraphics(){return textGraphics;}
}
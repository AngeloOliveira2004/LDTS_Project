package org.space.invaders.view;

import com.googlecode.lanterna.TerminalSize;
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
        dtf.setInitialTerminalSize(new TerminalSize(40, 20));

        Terminal terminal = dtf.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.startScreen();
        textGraphics = screen.newTextGraphics();

    }

    public void drawElements(Arena arena) {
        // TODO: Implement drawing game elements based on the game state
        for(Element element : arena.getObjects())
        {
            element.draw(textGraphics);
            System.out.println(element.getClass());
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

    public void runGameLoop(Arena arena) {
        try {
            if(gameController.getApplicationState() == ApplicationState.Game) {
                // Process user input
                handleInput();
                // Update game state
                // TODO: Implement game state update logic
                System.out.println("here");
                // Draw game elements
                drawElements(arena);

                // Introduce some delay to control frame rate
                refresh();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleInput() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke != null) {
            if (keyStroke.getKeyType() == KeyType.Escape || keyStroke.getKeyType() == KeyType.EOF) {
                System.out.println("Key Type: " + keyStroke.getKeyType());
                screen.close();
                // Exit the game
                gameController.changeState(ApplicationState.MainMenu);
            }else
            {
                System.out.println("Key Type: " + keyStroke.getKeyType());
                System.out.println("Character: " + keyStroke.getCharacter());
                System.out.println("Ctrl: " + keyStroke.isCtrlDown());
                System.out.println("Alt: " + keyStroke.isAltDown());
                System.out.println("Shift: " + keyStroke.isShiftDown());
                System.out.println();
            }
            // TODO: Handle other key events based on your game's requirements
        }
    }
    public void close() throws IOException {
        screen.close();
    }
    public TextGraphics getTextGraphics(){return textGraphics;}
}
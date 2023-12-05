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

        // Start the game loop in a separate thread
        new Thread(this::runGameLoop).start();
    }

    public void drawElements() {
        // TODO: Implement drawing game elements based on the game state
        textGraphics.putString(5, 5, "Game is running...");
        refresh();
    }

    private void refresh() {
        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runGameLoop() {
        try {
            while (gameController.getApplicationState() == ApplicationState.Game) {
                // Process user input
                handleInput();

                // Update game state
                // TODO: Implement game state update logic

                // Draw game elements
                drawElements();

                // Introduce some delay to control frame rate
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleInput() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke != null) {
            if (keyStroke.getKeyType() == KeyType.Escape || keyStroke.getKeyType() == KeyType.EOF) {
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
}
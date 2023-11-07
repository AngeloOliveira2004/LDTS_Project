package org.spaceInvaders;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.MouseAction;
import com.googlecode.lanterna.input.MouseActionType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.awt.*;
import java.io.IOException;


public class Game {
    private boolean running = true;
    private Screen screen;
    private Arena arena;
    private SpaceShip spaceShip;

    private static final int FRAME_RATE = 60; // Frames per second
    private static final long FRAME_TIME = 1000000000 / FRAME_RATE; // Time per frame in nanoseconds

    private long lastFrameTime;
    public Game() {
        try {
            arena = new Arena(50 , 100);
            Terminal terminal = new DefaultTerminalFactory()
                    .setInitialTerminalSize(new TerminalSize(arena.getWidth(), arena.getHeight()))
                    .createTerminal();
            lastFrameTime = System.nanoTime();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

            spaceShip = new SpaceShip(10, 10);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        spaceShip.draw(screen.newTextGraphics());
        screen.refresh();
    }
    private void processKey(com.googlecode.lanterna.input.KeyStroke key)
    {
        switch (key.getKeyType()) {
            case ArrowRight -> spaceShip.moveRight();
            case ArrowLeft -> spaceShip.moveLeft();
            case ArrowDown -> spaceShip.moveDown();
            case ArrowUp -> spaceShip.moveUp();
            case Character -> {
                char character = key.getCharacter();
                if (character == 'D' || character == 'd') {
                    spaceShip.moveRight();
                } else if (character == 'A' || character == 'a') {
                    spaceShip.moveLeft();
                } else if (character == 'S' || character == 's') {
                    spaceShip.moveDown();
                } else if (character == 'W' || character == 'w') {
                    spaceShip.moveUp();
                }
            }
        }

        System.out.println(key);
    }

    private void printMousePosition(Point mouseAction) {
        int mouseX = mouseAction.x;
        int mouseY = mouseAction.y;
        System.out.println("Mouse Position: X=" + mouseX + ", Y=" + mouseY);

    }
    public void run()
    {
        try {
            while(running) {

                long currentTime = System.nanoTime();
                long elapsedTime = currentTime - lastFrameTime;

                if (elapsedTime >= FRAME_TIME) {
                    lastFrameTime = currentTime;

                    draw();

                    // Read user input
                    com.googlecode.lanterna.input.KeyStroke key = screen.pollInput();
                    if (key != null) {
                        if (key.getKeyType() == KeyType.Escape || key.getKeyType() == KeyType.EOF) {
                            screen.close();
                            break;
                        }
                        processKey(key);
                    }

                    // Update game state
                    // Here you can update the game state, e.g., move the spaceship, handle collisions, etc.

                    // Print mouse position
                    printMousePosition(MouseInfo.getPointerInfo().getLocation());

                    screen.refresh();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

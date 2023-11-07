package org.spaceInvaders;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class Game {
    private boolean running = true;
    private Screen screen;
    Arena arena = new Arena(50 , 100);

    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory()
                    .setInitialTerminalSize(new TerminalSize(arena.getWidth(), arena.getHeight()))
                    .createTerminal();

            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void draw() throws IOException {

    }
    private void processKey(com.googlecode.lanterna.input.KeyStroke key)
    {
        System.out.println(key);
    }
    public void run()
    {
        try {
            while(true) {
                draw();
                com.googlecode.lanterna.input.KeyStroke key = screen.readInput();
                processKey(key);

                if (key.getKeyType() == KeyType.Escape || key.getKeyType() == KeyType.EOF) {
                    screen.close();
                    break;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

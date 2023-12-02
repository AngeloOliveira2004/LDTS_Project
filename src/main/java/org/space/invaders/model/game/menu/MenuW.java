package org.space.invaders.model.game.menu;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import org.space.invaders.Game;

import java.io.IOException;

public class MenuW {

    private char option = '0';

    private Screen screenMenu;

    private Terminal terminalFactory;

    private boolean exitMenu = false;

    private char difficulty = '0';

    public MenuW() {
        try {
            terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(75, 30)).createTerminal();
            screenMenu = new TerminalScreen(terminalFactory); // Ver se há conflitos com a screen no game !!!

            screenMenu.startScreen();
            screenMenu.setCursorPosition(null);
            showMainMenu(screenMenu);

            while (!exitMenu) {
                showMainMenu(screenMenu);
                com.googlecode.lanterna.input.KeyStroke key = screenMenu.pollInput();
                if (key != null) {
                    handleMainMenuInput(key);
                }
            }

            screenMenu.clear();
            screenMenu.refresh();
            screenMenu.doResizeIfNecessary();

            while (exitMenu) {
                menuDifficulty(screenMenu);
                com.googlecode.lanterna.input.KeyStroke key = screenMenu.pollInput();
                if (key != null) {
                    handleMainMenuInput(key);
                }
            }

            screenMenu.stopScreen();

        } catch (IOException e) {
            e.printStackTrace(); // Ver melhor maneira para sair graciosamente
        }
    }

    private void showMainMenu(Screen screen) {
        try {
            TextGraphics textTitle = screen.newTextGraphics();
            textTitle.setBackgroundColor(TextColor.ANSI.BLACK);
            textTitle.setForegroundColor(TextColor.ANSI.GREEN);
            drawBiggerText(textTitle, 22, 10, "WORLD THRUSTER", SGR.BOLD);
            if(option == '0'){
                textTitle.setBackgroundColor(TextColor.ANSI.WHITE);
            }
            textTitle.putString(30, 12, "New Game", SGR.BOLD);
            textTitle.setBackgroundColor(TextColor.ANSI.BLACK);
            if(option == '1'){
                textTitle.setBackgroundColor(TextColor.ANSI.WHITE);
            }
            textTitle.putString(30, 14, "Exit", SGR.BOLD);
            textTitle.setBackgroundColor(TextColor.ANSI.BLACK);
            textTitle.putString(55, 29, "Insert a Coin:", SGR.BOLD,SGR.BLINK);
            screen.refresh();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void drawBiggerText(TextGraphics textGraphics, int x, int y, String text, SGR sgr) { //Talvez trocar para posição mais tarde
        textGraphics.enableModifiers(sgr);
        boolean t_counter = false;

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character == 'L' || character == 'D' || (character == 'T' && !t_counter) || character == 'S') {
                if (character == 'T') {
                    t_counter = true;
                }
                textGraphics.putString(x + i * 2, y, String.valueOf(character), SGR.BOLD);
            } else {
                textGraphics.putString(x + i * 2, y, String.valueOf(character), SGR.BOLD, SGR.BLINK);
            }
        }
        textGraphics.disableModifiers(sgr);
    }
    private void handleMainMenuInput(KeyStroke key) throws IOException {
        switch (key.getKeyType()) {
            case ArrowUp : {
                if (option == '2' && exitMenu) {
                    this.option = '1';
                } else {
                    this.option = '0';
                }
                break;
            }
            case ArrowDown : {
                if (option == '1' && exitMenu) {
                    this.option = '2';
                } else if(option == '0') {
                    this.option = '1';
                }
                break;
            }
            case Enter : validateSelection();
        }
    }

    private void validateSelection() {
        if (!exitMenu) {
            switch (option) {
                case '0': {
                    exitMenu = true;
                    break; // Procede para o próximo menu da dificuldade
                }
                case '1': {
                    System.exit(0);
                    break; //Fecha o programa, talvez seja uma ideia guardar values highscore em ficheiro .csv e ler no final , nesse caso mudar aqui os valores
                }
            }
        } else {
            difficulty = option;
            try {
                screenMenu.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Game game = Game.getInstance();
            game.run();
        }

    }

    private void menuDifficulty(Screen screen) {
        try {
            TextGraphics textTitle = screen.newTextGraphics();
            textTitle.setForegroundColor(TextColor.ANSI.GREEN);
            textTitle.putString(30, 10, "Difficulty", SGR.BOLD);

            if (option == '0') {
                textTitle.setBackgroundColor(TextColor.ANSI.WHITE);
                textTitle.putString(30, 12, "EASY", SGR.BOLD,SGR.BLINK);
            }
            textTitle.putString(30, 12, "EASY", SGR.BOLD);

            textTitle.setBackgroundColor(TextColor.ANSI.BLACK);
            if (option == '1') {
                textTitle.setBackgroundColor(TextColor.ANSI.WHITE);
            }
            textTitle.putString(30, 14, "NORMAL", SGR.BOLD);

            textTitle.setBackgroundColor(TextColor.ANSI.BLACK);
            if (option == '2') {
                textTitle.setBackgroundColor(TextColor.ANSI.WHITE);
            }
            textTitle.putString(30, 16, "HARD", SGR.BOLD);

            textTitle.setBackgroundColor(TextColor.ANSI.BLACK);

            screen.refresh();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
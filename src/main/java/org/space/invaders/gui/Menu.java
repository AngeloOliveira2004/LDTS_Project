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

public class Menu implements MenuGUI {
    private Screen screen;
    private TextGraphics textGraphics;
    private boolean visible = true;
    public Menu(int screenWidth, int screenHeight) throws IOException {
        if(visible)
        {
            Terminal terminal = new DefaultTerminalFactory()
                    .setInitialTerminalSize(new TerminalSize(screenWidth, screenHeight))
                    .createTerminal();

            this.screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            // Start the screen
            screen.startScreen();

            textGraphics = screen.newTextGraphics();
        }
    }
    public Menu(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void drawText(Position position, String text, String color) {
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.putString(position.x, position.y, text);
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
    public void drawText(Position position , String text, String color, String modifier)
    {
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.setForegroundColor(TextColor.ANSI.GREEN_BRIGHT);
        textGraphics.putString(position.x, position.y,text, SGR.valueOf(modifier));
    }

    @Override
    public void drawSelectedText(Position position , String text, String color, String modifier)
    {
        textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
        textGraphics.setForegroundColor(TextColor.ANSI.GREEN_BRIGHT);
        textGraphics.putString(position.x, position.y,text, SGR.valueOf(modifier));
    }

    @Override
    public void refresh(){
        try {
            screen.refresh();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Screen getScreen(){
        return screen;
    }

    @Override
    public MenuGUI.ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if(keyStroke == null) return MenuGUI.ACTION.NONE;
        if(keyStroke.getKeyType() == KeyType.EOF) return MenuGUI.ACTION.QUIT;
        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return MenuGUI.ACTION.QUIT;
        if(keyStroke.getKeyType() == KeyType.ArrowUp) return MenuGUI.ACTION.UP;
        if(keyStroke.getKeyType() == KeyType.ArrowDown) return MenuGUI.ACTION.DOWN;
        if(keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if(keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if(keyStroke.getKeyType() == KeyType.Enter) return MenuGUI.ACTION.ENTER;
        return null;
    }
    public void setVisible(boolean visible){this.visible = visible;}
    /*public enum Option {START, INST, PREF, RANKING, EXIT};

    public String[] optString = {"NEW GAME", "INSTRUCTIONS", "SETTINGS", "RANKINGS", "EXIT"};

    Option selected;
    Option[] opt = Option.values();

    public Menu(boolean inGame) {
        this.selected = START;
        if (inGame) optString[0] = "CONTINUE";
    }

    public Option getSelected() {
        return selected;
    }

    public int getPosElem(Option target) {
        int i = 0;
        for (; opt[i] != target; i++) ;
        return i;
    }

    public String enumToString(Option menuOption) {
        int position = getPosElem(menuOption);
        return optString[position];
    }

    public void setSelected(Option selected) {
        this.selected = selected;
    }

    public void nextSelected() {
        if (selected == EXIT) selected = START;
        else {
            //find the position of this.selected in the opt array
            int i = getPosElem(selected);
            i++;
            selected = opt[i];
        }
    }

    public void previousSelected() {
        if (selected == START) selected = EXIT;
        else {
            //find the position of this.selected in the opt array
            int i = getPosElem(selected);
            i--;
            selected = opt[i];
        }
    }*/
}
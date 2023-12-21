package org.space.invaders.gui;

import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.model.Position;
import java.io.IOException;
import java.util.ArrayList;

public interface MenuGUI {
    MenuGUI.ACTION getNextAction() throws IOException;
    void clear();
    void refresh();

    Screen getScreen();
    void drawText(Position position , String text , String color, String Modifier);

    void drawSelectedText(Position position , String text, String color, String modifier);
    void close() throws IOException;

    enum ACTION {DOWN, ENTER, LEFT, NONE, QUIT, RIGHT, SELECT, UP}
}

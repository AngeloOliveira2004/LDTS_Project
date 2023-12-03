package org.space.invaders.gui;

import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.model.Position;
import java.io.IOException;
import java.util.ArrayList;

public interface MenuGUI {
    MenuGUI.ACTION getNextAction() throws IOException;
    void drawText(Position position , String text , String color);
    void clear();
    void refresh();

    Screen getScreen();
    void drawText(Position position , String text , String color, String Modifier);

    void drawSelectedText(Position position , String text, String color, String modifier);
    void close() throws IOException;
    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT,ENTER}
}

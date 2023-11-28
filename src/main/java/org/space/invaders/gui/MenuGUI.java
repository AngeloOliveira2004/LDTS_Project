package org.space.invaders.gui;

import javax.swing.text.Position;
import java.io.IOException;
import java.util.ArrayList;

public interface MenuGUI {
    GUI.ACTION getNextAction() throws IOException;
    void drawText(Position position , String text , String color);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}

package org.space.invaders.gui;

import com.googlecode.lanterna.graphics.TextGraphics;


import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.model.Position;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public interface GUI {

    void drawEnemies(ArrayList<Position> EnemiesPosition , ArrayList<char[][]> enemiesShape);

    void clear();

    void close() throws IOException;

    void refresh();

    Screen getScreen();

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, ENTER}
}

package org.space.invaders.gui;

import com.googlecode.lanterna.graphics.TextGraphics;


import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.model.Position;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawSpaceShip(Position position , char[][] spaceShipShape);

    void drawShot(Position position , char[][] ShotShape , int yVelocity);

    void drawStars(ArrayList<Position> StarPositions);

    void drawEnemies(ArrayList<Position> EnemiesPosition , ArrayList<char[][]> enemiesShape);

    void drawHealth(Position position, String text, String color);
    void clear();

    void close() throws IOException;

    void refresh();

    Screen getScreen();

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, ENTER}
}

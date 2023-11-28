package org.space.invaders.gui;

import com.googlecode.lanterna.graphics.TextGraphics;


import org.space.invaders.model.Position;
import java.io.IOException;
import java.util.ArrayList;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawSpaceShip(TextGraphics screen, Position position , char[][] spaceShipShape);

    void drawShot(TextGraphics screen , Position position , char[][] ShotShape);

    void drawStars(TextGraphics screen , ArrayList<Position> StarPositions);

    void drawEnemies(TextGraphics screen , ArrayList<Position> EnemiesPosition , ArrayList<char[][]> enemiesShape);

    void drawHealth(TextGraphics screen , Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}

package org.space.invaders.gui;

import javax.swing.text.Position;
import java.io.IOException;
import java.util.ArrayList;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawSpaceShip(Position position , char[][] spaceShipShape);

    void drawShot(Position position , char[][] ShotShape);

    void drawStars(ArrayList<Position> StarPositions);

    void drawEnemies(ArrayList<Position> EnemiesPosition , ArrayList<char[][]> enemiesShape);

    void drawHealth(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}

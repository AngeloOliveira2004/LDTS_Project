package org.space.invaders.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import javax.swing.text.Position;
import java.io.IOException;
import java.util.ArrayList;

public class LanternaGUI implements GUI{
    @Override
    public ACTION getNextAction() throws IOException {
        return null;
    }

    @Override
    public void drawSpaceShip(Position position, char[][] spaceShipShape) {

    }

    @Override
    public void drawShot(Position position, char[][] ShotShape) {

    }

    @Override
    public void drawStars(ArrayList<Position> StarPositions) {

    }

    @Override
    public void drawEnemies(ArrayList<Position> EnemiesPosition, ArrayList<char[][]> enemiesShape) {

    }

    @Override
    public void drawHealth(Position position, String text, String color) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void refresh() throws IOException {

    }

    @Override
    public void close() throws IOException {

    }
}

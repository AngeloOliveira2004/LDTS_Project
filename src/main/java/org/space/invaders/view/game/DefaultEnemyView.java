package org.space.invaders.view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.DefaultEnemy;

import java.util.ArrayList;

public class DefaultEnemyView extends View {
    private DefaultEnemy defaultEnemy;
    private static final int CHAR_HEIGHT = 1;
    private static final int CHAR_WIDTH = 1;

    private static final String[] DefaultEnemyModel = new String[]{
            "     C   C      ",
            "     C   C      ",
            "    AAAAAAAGG   ",
            "   AAAAAAAAAGG  ",
            "  CCCCCCCCCAAG  ",
            "  CCCCCCCCCAAA  ",
            "  RRRRRRRRCAAA  ",
            "  CCCCCCCCCAAA  ",
            "   AAAAAAAAAA   ",
            "       CC       ",
            " GGA  AAAA  AGG ",
            " GAACCARRACCAAG ",
            "   C  AAAA  C   ",
            "  CCC      CCC  ",
            " C C C    C C C ",
            " C   C    C   C ",
    };

    public DefaultEnemyView(DefaultEnemy defaultEnemy, TextGraphics textGraphics) {
        super(CHAR_WIDTH, CHAR_HEIGHT, textGraphics);
        this.defaultEnemy = defaultEnemy;
    }

    public void drawDefaultEnemy() {
        ArrayList<Position> positions = new ArrayList<>();
        int x = (int) defaultEnemy.getPosition().getX();
        int y = (int) defaultEnemy.getPosition().getY();
        drawImage(DefaultEnemyModel, x, y,positions);
        defaultEnemy.setOccupiedPositions(positions);
    }

    @Override
    public void draw() {
    }

    public String[] getDesign() {
        return DefaultEnemyModel;
    }
}

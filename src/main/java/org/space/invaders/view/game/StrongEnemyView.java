package org.space.invaders.view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.game.elements.StrongEnemy;

public class StrongEnemyView extends View {
    private StrongEnemy strongEnemy;
    private static final int CHAR_HEIGHT = 1;
    private static final int CHAR_WIDTH = 1;


    private static final String[] StrongEnemyModel = new String[]{
            "BBBBBCBBBCBBBBBB",
            "BBBBBCBBBCBBBBBB",
            "BBBBRRRRRRRGGBBB",
            "BBBRRRRRRRRRGGBB",
            "BBCCCCCCCCCRRGBB",
            "BBCCCCCCCCCRRRBB",
            "BBGGGGGGGGCRRRBB",
            "BBCCCCCCCCCRRRBB",
            "BBBRRRRRRRRRRBBB",
            "BBBBBBBCCBBBBBBB",
            "BGGRBBRRRRBBRGGB",
            "BGRRCCRGGRCCRRGB",
            "BBBCBBRRRRBBCBBB",
            "BBCCCBBBBBBCCCBB",
            "BCBCBCBBBBCBCBCB",
            "BCBBBCBBBBCBBBCB",
    };

    public StrongEnemyView(StrongEnemy strongEnemy, TextGraphics textGraphics) {
        super(CHAR_WIDTH, CHAR_HEIGHT, textGraphics);
        this.strongEnemy = strongEnemy;
    }

    public void drawStrongEnemy() {
        int x = (int) strongEnemy.getPosition().getX();
        int y = (int) strongEnemy.getPosition().getY();
        drawImage(StrongEnemyModel, x, y);
    }

    @Override
    public void draw() {
    }

    public String[] getDesign() {
        return StrongEnemyModel;
    }
}

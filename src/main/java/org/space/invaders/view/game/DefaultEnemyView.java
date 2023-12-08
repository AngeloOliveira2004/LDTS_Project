package org.space.invaders.view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.game.elements.DefaultEnemy;

public class DefaultEnemyView extends View {
    private DefaultEnemy defaultEnemy;
    private static final int CHAR_HEIGHT = 1;
    private static final int CHAR_WIDTH = 1;

    private static final String[] DefaultEnemyModel = new String[]{
            "BBBBBCBBBCBBBBBB",
            "BBBBBCBBBCBBBBBB",
            "BBBBAAAAAAAGGBBB",
            "BBBAAAAAAAAAGGBB",
            "BBCCCCCCCCCAAGBB",
            "BBCCCCCCCCCAAABB",
            "BBRRRRRRRRCAAABB",
            "BBCCCCCCCCCAAABB",
            "BBBAAAAAAAAAABBB",
            "BBBBBBBCCBBBBBBB",
            "BGGABBAAAABBAGGB",
            "BGAACCARRACCAAGB",
            "BBBCBBAAAABBCBBB",
            "BBCCCBBBBBBCCCBB",
            "BCBCBCBBBBCBCBCB",
            "BCBBBCBBBBCBBBCB",
    };

    public DefaultEnemyView(DefaultEnemy defaultEnemy, TextGraphics textGraphics) {
        super(CHAR_WIDTH, CHAR_HEIGHT, textGraphics);
        this.defaultEnemy = defaultEnemy;
    }

    public void drawDefaultEnemy() {
        int x = (int) defaultEnemy.getPosition().getX();
        int y = (int) defaultEnemy.getPosition().getY();
        drawImage(DefaultEnemyModel, x, y);
    }

    @Override
    public void draw() {
    }

    public String[] getDesign() {
        return DefaultEnemyModel;
    }
}

package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.game.elements.KamikazeEnemy;
import org.space.invaders.view.Color;
import java.io.IOException;

public class KamikazeView extends View{
    private KamikazeEnemy kamikazeEnemy;
    private static final int CHAR_HEIGHT = 1;
    private static final int CHAR_WIDTH = 1;

    private static final String[] KamikazeModel = new String[]{
            "BBBBBBOYYOBBBBBB",
            "BBBBBBBOOBBBBBBB",
            "BCBBBBBCCBBBBBCB",
            "CWCCBBCWWCBBCCWC",
            "CWWWCCWWOWCCWWWC",
            "CWWWWWWOWWWWWWWC",
            "BCWWWWWBBWWWWWCB",
            "BBCWWWBBBBWWWCBB",
            "BBBCWWBBBBWWCBBB",
            "BBBBCWWBBWWCBBBB",
            "BBBBCWWWWWWCBBBB",
            "BBBBBCWWWWCBBBBB",
            "BBBBBCWWWWCBBBBB",
            "BBBBBBCWWCBBBBBB",
            "BBBBBBBCCBBBBBBB",
    };


    public KamikazeView(KamikazeEnemy kamikazeEnemy , TextGraphics textGraphics) {
        super(CHAR_WIDTH, CHAR_HEIGHT, textGraphics);
        this.kamikazeEnemy = kamikazeEnemy;
    }

    public void drawKamikaze()
    {
        int x = (int)kamikazeEnemy.getPosition().getX();
        int y = (int)kamikazeEnemy.getPosition().getY();
        drawImage(KamikazeModel, x, y);
    }
    @Override
    public void draw() throws IOException {
    }
    public String[] getDesign(){return  KamikazeModel;}
}

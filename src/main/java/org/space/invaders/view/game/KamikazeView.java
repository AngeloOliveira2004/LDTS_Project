package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.KamikazeEnemy;
import org.space.invaders.view.Color;
import java.io.IOException;
import java.util.ArrayList;

public class KamikazeView extends View{
    private KamikazeEnemy kamikazeEnemy;
    private static final int CHAR_HEIGHT = 1;
    private static final int CHAR_WIDTH = 1;
    ArrayList<Position> positions;
    static final String[] KamikazeModel = new String[]{
            "      OYYO      ",
            "       OO       ",
            " C     CC     C ",
            "CWCC  CWWC  CCWC",
            "CWWWCCWWOWCCWWWC",
            "CWWWWWWOWWWWWWWC",
            " CWWWWWBBWWWWWC ",
            "  CWWWBBBBWWWC  ",
            "   CWWBBBBWWC   ",
            "    CWWBBWWC    ",
            "    CWWWWWWC    ",
            "     CWWWWC     ",
            "     CWWWWC     ",
            "      CWWC      ",
            "       CC       ",
    };

    private int check;
    public KamikazeView(KamikazeEnemy kamikazeEnemy , TextGraphics textGraphics) {
        super(CHAR_WIDTH, CHAR_HEIGHT, textGraphics);
        this.kamikazeEnemy = kamikazeEnemy;

        this.positions = new ArrayList<>();
        this.check = 0;
    }

    public void drawKamikaze()
    {
        ArrayList<Position> positions = new ArrayList<>();
        int x = (int)kamikazeEnemy.getPosition().getX();
        int y = (int)kamikazeEnemy.getPosition().getY();
        drawImage(KamikazeModel, x, y , positions);
        kamikazeEnemy.setOccupiedPositions(positions);
      }
    @Override
    public void draw() throws IOException {
    }
    public String[] getDesign(){return  KamikazeModel;}
}

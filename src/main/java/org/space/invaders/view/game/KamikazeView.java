package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.game.elements.KamikazeEnemy;

import java.io.IOException;

public class KamikazeView extends View{
    private KamikazeEnemy kamikazeEnemy;
    private static final int CHAR_HEIGHT = 3;
    private static final int CHAR_WIDTH = 3;
    private static final String[] KamikazeModel = {"K" , " "};

    public KamikazeView(KamikazeEnemy kamikazeEnemy , TextGraphics textGraphics) {
        super(CHAR_WIDTH, CHAR_HEIGHT, textGraphics);
        this.kamikazeEnemy = kamikazeEnemy;
    }

    public void drawKamikaze()
    {
        for(int y = 0 ; y < KamikazeModel.length ; y++)
        {
            for(int x = 0 ; x < KamikazeModel[0].length() ; x++)
            {
                char character = KamikazeModel[y].charAt(x);
                if (character != ' ') {
                    setColor(character);
                    getGraphics().putString(kamikazeEnemy.getXposition() , kamikazeEnemy.getYposition() , "Kamikaze");
                    getGraphics().fillRectangle(new TerminalPosition(kamikazeEnemy.getXposition() * CHAR_WIDTH
                                    , kamikazeEnemy.getYposition() * charHeight)
                            , new TerminalSize(CHAR_WIDTH, CHAR_HEIGHT), ' ');
                }
            }
        }
    }
    @Override
    public void draw() throws IOException {
    }
}

package org.space.invaders.view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.game.UI.Score;
import org.space.invaders.model.game.UI.Time;

import java.io.IOException;

public class ScoreView extends View{
    private static final int CHAR_HEIGHT = 1;
    private static final int CHAR_WIDTH = 1;
    private Score score;

    public ScoreView(Score score , TextGraphics textGraphics)
    {
        super(CHAR_HEIGHT , CHAR_WIDTH , textGraphics);
        this.score = score;
    }

    @Override
    public void draw() throws IOException {
        String scoreString = String.valueOf(score.getScore());
    }
}

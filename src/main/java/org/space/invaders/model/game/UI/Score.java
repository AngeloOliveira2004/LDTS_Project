package org.space.invaders.model.game.UI;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.view.game.ScoreView;
import org.space.invaders.view.game.TimeView;

import java.io.IOException;

public class Score {
    private long score;
    private ScoreView scoreView;
    public Score()
    {
        this.score = 0;
    }
    public void incrementScore(int a){this.score += a;}

    public void draw(TextGraphics textGraphics) throws IOException {
        scoreView = new ScoreView(this , textGraphics);
        scoreView.draw();
    }

    public long getScore() {
        return score;
    }
}

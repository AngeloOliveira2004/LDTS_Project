package org.space.invaders.view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.UI.NumberEnum;
import org.space.invaders.model.game.UI.Score;

import java.io.IOException;
import java.util.ArrayList;

public class ScoreView extends View {
    private static final int CHAR_HEIGHT = 1;
    private static final int CHAR_WIDTH = 1;
    private Score score;
    private boolean first_time;
    static final String[] scoreString = new String[]{
            "ggggg  ggggg  gggggg  ggggg  ggggg     ",
            "gg     gg     gg  gg  gg gg  gg      gg",
            "ggggg  gg     gg  gg  gggg   ggggg     ",
            "   gg  gg     gg  gg  gg g   gg      gg",
            "ggggg  ggggg  gggggg  gg gg  ggggg     ",
    };

    public ScoreView(Score score, TextGraphics textGraphics) {
        super(CHAR_HEIGHT, CHAR_WIDTH, textGraphics);
        this.score = score;
        this.first_time = true;
    }

    @Override
    public void draw() throws IOException {
        String scoreStringValue = String.valueOf(score.getScore());

        Position position = new Position(10, 305);
        actualDraw(position, scoreString,scoreStringValue);
    }

    void actualDraw(Position position, String[] model, String score) {
        ArrayList<Position> positions = new ArrayList<>();
        int x = (int) position.getX();
        int y = (int) position.getY();

        if (first_time) {
            drawImage(model, x, y, positions);
            x += 45;
            first_time = false;
        }
        for (int i = 0; i < score.length(); i++) {
            int digit = Character.getNumericValue(score.charAt(i));
            drawImage(NumberEnum.values()[digit].getDesign(), x + i * 8, y, positions);
        }
    }

    public boolean getFirstTime() {
        return first_time;
    }

    public String[] getScoreString()
    {
        return scoreString;
    }
}

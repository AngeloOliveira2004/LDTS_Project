package org.space.invaders.view.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.UI.Score;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ScoreViewTest {

    @Mock
    private TextGraphics textGraphics;

    @Mock
    private Score score;
    private ScoreView scoreView;
    @Mock
    private Position position;

    @Before
    public void setUp() {
        scoreView = new ScoreView(score, textGraphics);
        Position position = new Position(10, 305);
    }

    @Test
    public void testActualDraw() {
        String[] model = ScoreView.scoreString;
        String scoreValue = "123";

        scoreView.actualDraw(position, model, scoreValue);

        for (int i = 0; i < ScoreView.scoreString.length; i++) {
            verify(textGraphics, atLeastOnce()).setCharacter(position.getX(), position.getY() + i, any(TextCharacter.class));
        }

        for (int i = 0; i < 5; i++) {
            verify(textGraphics, atLeastOnce()).setCharacter(position.getX() + i * 8, position.getY(), any(TextCharacter.class));
        }
    }
}


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

    @Before
    public void setUp() {
        scoreView = new ScoreView(score, textGraphics);
    }

    @Test
    public void testDrawMethod() throws IOException {
        when(score.getScore()).thenReturn(0L);

        scoreView.draw();

        int expectedX = 10;
        int expectedY = 305;

        for (int i = 0; i < ScoreView.scoreString.length; i++) {
            verify(textGraphics, atLeastOnce()).setCharacter(expectedX, expectedY + i, any(TextCharacter.class));
        }

        for (int i = 0; i < 5; i++) {
            verify(textGraphics, atLeastOnce()).setCharacter(expectedX + i * 8, expectedY, any(TextCharacter.class));
        }

    }

    @Test
    public void testActualDraw() {
        Position position = new Position(10, 305);
        String[] model = ScoreView.scoreString;
        String scoreValue = "12345";

        scoreView.actualDraw(position, model, scoreValue);

        int expectedX = 10;
        int expectedY = 305;

        for (int i = 0; i < ScoreView.scoreString.length; i++) {
            verify(textGraphics, atLeastOnce()).setCharacter(expectedX, expectedY + i, any(TextCharacter.class));
        }

        for (int i = 0; i < 5; i++) {
            verify(textGraphics, atLeastOnce()).setCharacter(expectedX + i * 8, expectedY, any(TextCharacter.class));
        }
    }
}


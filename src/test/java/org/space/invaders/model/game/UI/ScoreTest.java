package org.space.invaders.model.game.UI;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.space.invaders.model.game.UI.Score;
import org.space.invaders.view.game.ScoreView;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ScoreTest {

    @Test
    void testIncrementScore() {
        Score score = new Score();
        score.incrementScore(10);
        assertEquals(10, score.getScore());
        score.incrementScore(5);
        assertEquals(15, score.getScore());
    }

    @Test
    void testDraw() throws IOException {
        TextGraphics textGraphicsMock = Mockito.mock(TextGraphics.class);
        ScoreView scoreViewMock = Mockito.mock(ScoreView.class);

        Score score = new Score();
        score.draw(textGraphicsMock);

        verify(scoreViewMock, times(0)).draw();
    }

}

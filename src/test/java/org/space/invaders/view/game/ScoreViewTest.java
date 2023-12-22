package org.space.invaders.view.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.UI.Lifes;
import org.space.invaders.model.game.UI.Score;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ScoreViewTest {
    ScoreView scoreView;
    @Mock
    Score score;
    @Mock
    TextGraphics textGraphics;
    @BeforeEach
    void setup()
    {
        this.score = mock(Score.class);
        this.textGraphics = mock(TextGraphics.class);
        this.scoreView = new ScoreView(score , textGraphics);
    }

    @Test
    void ActualDraw() throws IOException {
        assertTrue(scoreView.getFirstTime());
        scoreView.draw();
       assertFalse(scoreView.getFirstTime());
    }

    @Test
    void testGetters() {

        final String[] design = new String[]{
                "ggggg  ggggg  gggggg  ggggg  ggggg     ",
                "gg     gg     gg  gg  gg gg  gg      gg",
                "ggggg  gg     gg  gg  gggg   ggggg     ",
                "   gg  gg     gg  gg  gg g   gg      gg",
                "ggggg  ggggg  gggggg  gg gg  ggggg     ",
        };

        assertEquals(design.length, scoreView.getScoreString().length);
    }
}


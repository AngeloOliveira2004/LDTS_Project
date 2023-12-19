package org.space.invaders.view.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.KamikazeEnemy;
import static org.mockito.Mockito.*;

public class KamikazeViewTest {

    @Mock
    private TextGraphics textGraphics;

    @Mock
    private KamikazeEnemy kamikazeEnemy;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDrawKamikazeMethod() {
        when(kamikazeEnemy.getPosition()).thenReturn(new Position(10, 20));

        KamikazeView kamikazeView = new KamikazeView(kamikazeEnemy, textGraphics);

        kamikazeView.drawKamikaze();

        int expectedX = 10;
        int expectedY = 20;

        for (int i = 0; i < KamikazeView.KamikazeModel.length; i++) {
            verify(textGraphics, atLeastOnce()).setCharacter(expectedX, expectedY + i, any(TextCharacter.class));
        }
    }
}

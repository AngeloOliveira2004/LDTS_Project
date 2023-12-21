package org.space.invaders.view.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.StrongEnemy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

public class StrongEnemyViewTest {

    @Mock
    private TextGraphics textGraphics;

    @Mock
    private StrongEnemy strongEnemy;
    private StrongEnemyView strongEnemyView;

    @Before
    public void setUp() {
        strongEnemyView = new StrongEnemyView(strongEnemy, textGraphics);
    }

    @Test
    public void testDrawStrongEnemyMethod() {
        when(strongEnemy.getPosition()).thenReturn(new Position(10, 20));

        strongEnemyView.drawStrongEnemy();

        int expectedX = 10;
        int expectedY = 20;

        for (int i = 0; i < StrongEnemyView.StrongEnemyModel.length; i++) {
            verify(textGraphics, atLeastOnce()).setCharacter(expectedX, expectedY + i, any(TextCharacter.class));
        }
    }
}


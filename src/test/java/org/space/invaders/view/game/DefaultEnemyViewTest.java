package org.space.invaders.view.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.DefaultEnemy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

public class DefaultEnemyViewTest {

    @Mock
    private TextGraphics textGraphics;

    @Mock
    private DefaultEnemy defaultEnemy;

    private DefaultEnemyView defaultEnemyView;

    @Before
    public void setUp() {
        defaultEnemyView = new DefaultEnemyView(defaultEnemy, textGraphics);
    }

    @Test
    public void testDrawDefaultEnemy() {
        when(defaultEnemy.getPosition()).thenReturn(new Position(10, 20));

        defaultEnemyView.drawDefaultEnemy();

        int expectedX = 10;
        int expectedY = 20;

        for (int i = 0; i < DefaultEnemyView.DefaultEnemyModel.length; i++) {
            verify(textGraphics, atLeastOnce()).setCharacter(expectedX, expectedY + i, any(TextCharacter.class));
        }

    }
}


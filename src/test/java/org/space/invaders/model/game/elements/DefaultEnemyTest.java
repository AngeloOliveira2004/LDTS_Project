package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.space.invaders.view.game.DefaultEnemyView;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class DefaultEnemyTest {

    @InjectMocks
    private DefaultEnemy defaultEnemy;

    @Mock
    private DefaultEnemyView defaultEnemyView;

    @Mock
    private TextGraphics textGraphics;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        defaultEnemy.setDefaultEnemyView(defaultEnemyView);
    }

    @Test
    void getDesignWithoutSettingView() {
        String[] design = defaultEnemy.getDesign();
        assertNull(design);
    }

    @Test
    void setDefaultEnemyView() {
        DefaultEnemyView newEnemyView = mock(DefaultEnemyView.class);

        defaultEnemy.setDefaultEnemyView(newEnemyView);

        assertSame(newEnemyView, defaultEnemy.getDefaultEnemyView());
    }

    @Test
    void testGetDefaultEnemyView() {
        DefaultEnemyView defaultEnemyViewMock = mock(DefaultEnemyView.class);
        defaultEnemy.setDefaultEnemyView(defaultEnemyViewMock);

        assertEquals(defaultEnemyViewMock, defaultEnemy.getDefaultEnemyView());
    }

    @Test
    void testDraw() {
        TextGraphics textGraphics = mock(TextGraphics.class);

        DefaultEnemy defaultEnemy = new DefaultEnemy(10, 5, 1, 1, 100, 1, true, 1, 1);

        DefaultEnemyView defaultEnemyViewMock = mock(DefaultEnemyView.class);
        defaultEnemy.setDefaultEnemyView(defaultEnemyViewMock);

        defaultEnemy.draw(textGraphics);

        Mockito.verify(defaultEnemyViewMock,Mockito.times(0)).drawDefaultEnemy();
    }
}

package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.view.game.DefaultEnemyView;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
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
}

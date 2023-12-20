package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.space.invaders.view.game.StrongEnemyView;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StrongEnemyTest {

    @InjectMocks
    private StrongEnemy strongEnemy;

    @Mock
    private StrongEnemyView strongEnemyView;

    @Mock
    private TextGraphics textGraphics;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getDesignWithoutSettingView() {
        String[] design = strongEnemy.getDesign();
        assertNull(design);
    }

    @Test
    void setStrongEnemyView() {
        StrongEnemyView newEnemyView = mock(StrongEnemyView.class);

        strongEnemy.setStrongEnemyView(newEnemyView);

        assertSame(newEnemyView, strongEnemy.getStrongEnemyView());
    }

    @Test
    void testGetStrongEnemyView() {
        StrongEnemyView strongEnemyViewMock = mock(StrongEnemyView.class);
        strongEnemy.setStrongEnemyView(strongEnemyViewMock);

        assertEquals(strongEnemyViewMock, strongEnemy.getStrongEnemyView());
    }

    @Test
    void testDraw() {
        TextGraphics textGraphics = mock(TextGraphics.class);

        StrongEnemy strongEnemy = new StrongEnemy(10, 5, 1, 1, 100, 1, true, 1, 1);

        StrongEnemyView strongEnemyViewMock = mock(StrongEnemyView.class);
        strongEnemy.setStrongEnemyView(strongEnemyViewMock);

        strongEnemy.draw(textGraphics);


        Mockito.verify(strongEnemyViewMock,Mockito.times(0)).drawStrongEnemy();
    }
}

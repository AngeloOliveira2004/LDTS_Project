package org.space.invaders.view.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.StrongEnemy;
import org.space.invaders.model.game.elements.StrongEnemy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StrongEnemyViewTest {

    @Mock
    private TextGraphics textGraphics;

    @Mock
    private StrongEnemy StrongEnemy;

    private StrongEnemyView StrongEnemyView;

    @BeforeEach
    public void setUp() {
        StrongEnemy = new StrongEnemy(15,15,1,1,1,1,true,1,1);
        textGraphics = mock(TextGraphics.class);
        StrongEnemyView = new StrongEnemyView(StrongEnemy, textGraphics);
        StrongEnemyView.setStrongEnemy(StrongEnemy);
    }

    @Test
    public void testDrawStrongEnemy() {
        StrongEnemy = mock(StrongEnemy.class);
        StrongEnemyView.setStrongEnemy(StrongEnemy);

        when(StrongEnemy.getPosition()).thenReturn(new Position(0,0));

        StrongEnemyView.drawStrongEnemy();

        verify(StrongEnemy , atLeastOnce()).setOccupiedPositions(any());
    }

    @Test
    void testDraw()
    {
        StrongEnemyView.draw();
        StrongEnemyView = mock(StrongEnemyView.class);

        StrongEnemyView.draw();

        verify(StrongEnemyView , times(1)).draw();
    }

    @Test
    void testGetDesign()
    {
         final String[] design = new String[]{
                "     C   C      ",
                "     C   C      ",
                "    RRRRRRRGG   ",
                "   RRRRRRRRRGG  ",
                "  CCCCCCCCCRRG  ",
                "  CCCCCCCCCRRR  ",
                "  GGGGGGGGCRRR  ",
                "  CCCCCCCCCRRR  ",
                "   RRRRRRRRRR   ",
                "       CC       ",
                " GGR  RRRR  RGG ",
                " GRRCCRGGRCCRRG ",
                "   C        C   ",
                "  CCC      CCC  ",
                " C C C    C C C ",
                " C   C    C   C ",
        };

        assertEquals(StrongEnemyView.getDesign().length , design.length);
    }
}


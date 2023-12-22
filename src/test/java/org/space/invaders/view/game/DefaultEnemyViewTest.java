package org.space.invaders.view.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.DefaultEnemy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DefaultEnemyViewTest {

    @Mock
    private TextGraphics textGraphics;

    @Mock
    private DefaultEnemy defaultEnemy;

    private DefaultEnemyView defaultEnemyView;

    @BeforeEach
    public void setUp() {
        defaultEnemy = new DefaultEnemy(15,15,1,1,1,1,true,1,1);
        textGraphics = mock(TextGraphics.class);
        defaultEnemyView = new DefaultEnemyView(defaultEnemy, textGraphics);
        defaultEnemyView.setDefaultEnemy(defaultEnemy);
    }

    @Test
    public void testDrawDefaultEnemy() {
        defaultEnemy = mock(DefaultEnemy.class);
        defaultEnemyView.setDefaultEnemy(defaultEnemy);

        when(defaultEnemy.getPosition()).thenReturn(new Position(0,0));

        defaultEnemyView.drawDefaultEnemy();

        verify(defaultEnemy , atLeastOnce()).setOccupiedPositions(any());
    }

    @Test
    void testDraw()
    {
        defaultEnemyView.draw();
        defaultEnemyView = mock(DefaultEnemyView.class);

        defaultEnemyView.draw();

        verify(defaultEnemyView , times(1)).draw();
    }

    @Test
    void testGetDesign()
    {
         final String[] design = new String[]{
                "     C   C      ",
                "     C   C      ",
                "    AAAAAAAGG   ",
                "   AAAAAAAAAGG  ",
                "  CCCCCCCCCAAG  ",
                "  CCCCCCCCCAAA  ",
                "  RRRRRRRRCAAA  ",
                "  CCCCCCCCCAAA  ",
                "   AAAAAAAAAA   ",
                "       CC       ",
                " GGA  AAAA  AGG ",
                " GAACCARRACCAAG ",
                "   C  AAAA  C   ",
                "  CCC      CCC  ",
                " C C C    C C C ",
                " C   C    C   C ",
        };

         assertEquals(defaultEnemyView.getDesign().length , design.length);
    }
}


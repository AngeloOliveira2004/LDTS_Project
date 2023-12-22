package org.space.invaders.view.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.DefaultEnemy;
import org.space.invaders.model.game.elements.KamikazeEnemy;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class KamikazeViewTest {

    @Mock
    private TextGraphics textGraphics;

    @Mock
    private KamikazeEnemy kamikazeEnemy;
    private KamikazeView kamikazeView;

    @BeforeEach
    public void setUp() {
        kamikazeEnemy = mock(KamikazeEnemy.class);
        textGraphics = mock(TextGraphics.class);
        kamikazeView = new KamikazeView(kamikazeEnemy, textGraphics);
    }

    @Test
    public void testDrawKamikazeMethod() {
        kamikazeEnemy = mock(KamikazeEnemy.class);
        kamikazeView.setKamikazeEnemy(kamikazeEnemy);

        when(kamikazeEnemy.getPosition()).thenReturn(new Position(0,0));

        kamikazeView.drawKamikaze();

        verify(kamikazeEnemy , atLeastOnce()).setOccupiedPositions(any());
    }

    @Test
    void testDraw() throws IOException {
        kamikazeView.draw();
        kamikazeView = mock(KamikazeView.class);

        kamikazeView.draw();

        verify(kamikazeView , times(1)).draw();
    }

    @Test
    void testGetDesign()
    {
        final String[] design = new String[]{
                "      OYYO      ",
                "       OO       ",
                " C     CC     C ",
                "CWCC  CWWC  CCWC",
                "CWWWCCWWOWCCWWWC",
                "CWWWWWWOWWWWWWWC",
                " CWWWWWBBWWWWWC ",
                "  CWWWBBBBWWWC  ",
                "   CWWBBBBWWC   ",
                "    CWWBBWWC    ",
                "    CWWWWWWC    ",
                "     CWWWWC     ",
                "     CWWWWC     ",
                "      CWWC      ",
                "       CC       ",
        };

        assertEquals(kamikazeView.getDesign().length , design.length);
    }
}

package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.view.game.KamikazeView;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class KamikazeEnemyTest {

    @InjectMocks
    private KamikazeEnemy kamikazeEnemy;

    @Mock
    private KamikazeView kamikazeView;

    @Mock
    private TextGraphics textGraphics;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        kamikazeEnemy.setKamikazeView(kamikazeView);
    }

    @Test
    void getDesignWithoutSettingView() {
        String[] design = kamikazeEnemy.getDesign();
        assertNull(design);
    }

    @Test
    void setKamikazeView() {
        KamikazeView newKamikazeView = mock(KamikazeView.class);

        kamikazeEnemy.setKamikazeView(newKamikazeView);

        assertSame(newKamikazeView, kamikazeEnemy.getKamikazeView());
    }

    @Test
    void testGetKamikazeView() {
        KamikazeView kamikazeViewMock = mock(KamikazeView.class);
        kamikazeEnemy.setKamikazeView(kamikazeViewMock);

        assertEquals(kamikazeViewMock, kamikazeEnemy.getKamikazeView());
    }

    @Test
    void testDraw() {
        KamikazeEnemy kamikazeEnemy = new KamikazeEnemy(10, 5, 1, 1, 100, 1, true, 1, 1);

        KamikazeView kamikazeViewMock = mock(KamikazeView.class);
        kamikazeEnemy.setKamikazeView(kamikazeViewMock);

        kamikazeEnemy.draw(textGraphics);

        verify(kamikazeViewMock, times(0)).drawKamikaze();
    }
}

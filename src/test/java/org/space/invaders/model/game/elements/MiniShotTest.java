package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.MiniShot;
import org.space.invaders.view.game.MiniShotView;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class MiniShotTest {

    @InjectMocks
    private MiniShot miniShot;

    @Mock
    private MiniShotView miniShotView;

    @Mock
    private TextGraphics textGraphics;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        miniShot.setMiniShotView(miniShotView);
    }

    @Test
    void testDraw() throws IOException {
        miniShot.draw(textGraphics);
        verify(miniShotView, times(0)).draw();
    }

    @Test
    void testIsInsideBorders() {
        Position initialPosition = new Position(5, 5);
        MiniShot miniShot = spy(new MiniShot(initialPosition, 2));

        when(miniShot.getPosition()).thenReturn(new Position(5, 3));

        assertTrue(miniShot.isInsideBorders());
    }

    @Test
    void testIsNotInsideBorders() {
        Position initialPosition = new Position(5, 2);
        MiniShot miniShot = spy(new MiniShot(initialPosition, 2));

        when(miniShot.getPosition()).thenReturn(new Position(5, 0));

        assertFalse(miniShot.isInsideBorders());
    }
}

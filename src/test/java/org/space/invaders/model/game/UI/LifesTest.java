package org.space.invaders.model.game.UI;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.space.invaders.view.game.LifesView;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LifesTest {

    @Test
    void testDecrementLifes() {
        Lifes lifes = new Lifes();
        lifes.decrementLifes();
        assertEquals(4, lifes.getLifes());
    }

    @Test
    void testIncrementLifes() {
        Lifes lifes = new Lifes();
        lifes.incrementLifes();
        assertEquals(6, lifes.getLifes());
    }

    @Test
    void testKillAllLifes() {
        Lifes lifes = new Lifes();
        lifes.killAllLifes();
        assertEquals(0, lifes.getLifes());
    }

    @Test
    void testDraw() throws IOException {
        TextGraphics textGraphicsMock = Mockito.mock(TextGraphics.class);
        LifesView lifesViewMock = Mockito.mock(LifesView.class);

        Lifes lifes = new Lifes();
        lifes.draw(textGraphicsMock);

        verify(lifesViewMock, times(0)).draw();
    }

}

package org.space.invaders.model.game.UI;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.space.invaders.view.game.TimeView;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class TimeTest {

    @Test
    void testGetElapsedTime() {
        Time time = new Time();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long elapsedTime = time.getElapsedTime();
        assertTrue(elapsedTime >= 100 && elapsedTime < 150);
    }

    @Test
    void testDraw() throws IOException {
        TextGraphics textGraphicsMock = Mockito.mock(TextGraphics.class);
        TimeView timeViewMock = Mockito.mock(TimeView.class);

        Time time = new Time();
        time.draw(textGraphicsMock);

        verify(timeViewMock, times(0)).draw();
    }

}

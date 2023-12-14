package org.space.invaders.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;

import java.io.IOException;

import static org.mockito.Mockito.*;

class LanternaGUITest {

    @Mock
    private Screen screen;

    @Mock
    private TextGraphics textGraphics;

    private LanternaGUI lanternaGUI;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        when(screen.newTextGraphics()).thenReturn(textGraphics);
        lanternaGUI = new LanternaGUI(screen);
    }


    @Test
    void testClear() {
        lanternaGUI.clear();
        verify(screen).clear();
    }

    @Test
    void testClose() throws IOException {
        lanternaGUI.close();
        verify(screen).close();
    }

    @Test
    void testRefresh() throws IOException {
        lanternaGUI.refresh();
        verify(screen).refresh();
    }
}

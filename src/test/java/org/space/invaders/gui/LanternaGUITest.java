package org.space.invaders.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
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
    void testEnumValues() {
        assertEquals(GUI.ACTION.UP, GUI.ACTION.valueOf("UP"));
        assertEquals(GUI.ACTION.RIGHT, GUI.ACTION.valueOf("RIGHT"));
        assertEquals(GUI.ACTION.DOWN, GUI.ACTION.valueOf("DOWN"));
        assertEquals(GUI.ACTION.LEFT, GUI.ACTION.valueOf("LEFT"));
        assertEquals(GUI.ACTION.NONE, GUI.ACTION.valueOf("NONE"));
        assertEquals(GUI.ACTION.QUIT, GUI.ACTION.valueOf("QUIT"));
        assertEquals(GUI.ACTION.SELECT, GUI.ACTION.valueOf("SELECT"));
        assertEquals(GUI.ACTION.ENTER, GUI.ACTION.valueOf("ENTER"));
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

package org.space.invaders.gui;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LanternaGUITest {

    @Mock
    private Screen screen;

    @Mock
    private TextGraphics textGraphics;

    @InjectMocks
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

    @Test
    void testDrawEnemies() {
        ArrayList<Position> enemiesPositions = new ArrayList<>();
        enemiesPositions.add(new Position(0, 0));
        enemiesPositions.add(new Position(0, 1));

        ArrayList<char[][]> enemiesShapes = new ArrayList<>();
        char[][] enemyShape = {{'0', '1'}, {'1', '1'}};

        enemiesShapes.add(enemyShape);

        lanternaGUI.setTextGraphics(textGraphics);

        lanternaGUI.drawEnemies(enemiesPositions, enemiesShapes);

        verify(textGraphics, times(enemyShape.length * enemyShape[0].length)).setCharacter(anyInt(), anyInt(), any());
    }

    @Test
    void testGetScreen() {
        Screen actualScreen = lanternaGUI.getScreen();
        assertNotNull(actualScreen);
    }

    @Test
    void testRefreshThrowsIOException() throws IOException {
        IOException ioException = new IOException();
        doThrow(ioException).when(screen).refresh();

        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> lanternaGUI.refresh());
        assertEquals(ioException, runtimeException.getCause());
    }

}

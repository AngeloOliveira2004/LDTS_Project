package org.space.invaders.view;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.space.invaders.control.GameController;
import org.space.invaders.model.Arena;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.UI.Lifes;
import org.space.invaders.model.game.UI.Score;
import org.space.invaders.model.game.UI.Time;
import org.space.invaders.model.game.elements.*;
import org.space.invaders.model.game.map.Stars;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

class GameViewerTest {

    private GameViewer gameViewer;
    private GameController gameController;
    private Arena mockArena;

    @BeforeEach
    void setUp() throws IOException {
        gameController = mock(GameController.class);
        mockArena = mock(Arena.class);
        gameViewer = new GameViewer(gameController);
    }

    @AfterEach
    void tearDown() {
        assertDoesNotThrow(() -> gameViewer.close());
    }

    @Test
    void testGetTextGraphics(){
        assertNotNull(gameViewer.getTextGraphics());
    }

    @Test
    void testRefresh() {
        GameViewer spyGameViewer = spy(gameViewer);

        assertDoesNotThrow(() -> spyGameViewer.refresh());
        verify(spyGameViewer, times(1)).refresh();
    }

    @Test
    void testDrawElements() throws IOException {
        when(mockArena.getStars()).thenReturn(new Stars());
        when(mockArena.getTime()).thenReturn(new Time());
        when(mockArena.getScore()).thenReturn(new Score());
        when(mockArena.getLifes()).thenReturn(new Lifes());
        when(mockArena.getPlanet()).thenReturn(new Planet(15,250,0,0,0,0,true,3,3 , 0));

        ArrayList<Element> objects = new ArrayList<>();
        ArrayList<ShotElement> shots = new ArrayList<>();
        ArrayList<ShotElement> enemiesShots = new ArrayList<>();

        Element element = new DefaultEnemy(0,0,0,0,0,0,true,0,0);
        objects.add(element);
        ShotElement shotElement = new Shot(new Position(0,0),2,5);
        shots.add(shotElement);
        ShotElement shotElementEnemy = new Shot(new Position(0,0),-1,5);
        enemiesShots.add(shotElementEnemy);

        when(mockArena.getObjects()).thenReturn(objects);
        when(mockArena.getShots()).thenReturn(shots);
        when(mockArena.getEnemiesShots()).thenReturn(enemiesShots);

        assertDoesNotThrow(() -> gameViewer.drawElements(mockArena));

        verify(mockArena, times(1)).getStars();
        verify(mockArena, times(1)).getTime();
        verify(mockArena, times(1)).getScore();
        verify(mockArena, times(1)).getPlanet();
        verify(mockArena, times(1)).getObjects();
    }

    @Test
    void testHandleInput() throws IOException {

        Screen screenMock = mock(Screen.class);
        GameViewer gameViewerMock = mock(GameViewer.class);
        gameViewerMock.setScreen(screenMock);
        KeyStroke keyStroke = new KeyStroke(KeyType.Enter);

        when(gameViewerMock.handleInput()).thenReturn(keyStroke);
        KeyStroke result = gameViewerMock.handleInput();
        assertEquals(keyStroke, result);
        verify(gameViewerMock, times(1)).handleInput();
    }

    @Test
    void testGetScreen(){
        assertNotNull(gameViewer.getScreen());
    }

    @Test
    void testSetScreen(){
        GameViewer mockGameViewer = mock(GameViewer.class);
        Screen screen = mock(Screen.class);
        mockGameViewer.setScreen(screen);
        verify(mockGameViewer, times(1)).setScreen(screen);
    }
}

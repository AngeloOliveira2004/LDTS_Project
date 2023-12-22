package org.space.invaders.view;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
    void testRefresh() {
        GameViewer spyGameViewer = spy(gameViewer);

        assertDoesNotThrow(() -> spyGameViewer.refresh());
        verify(spyGameViewer, times(1)).refresh();
    }

    @Test
    void testGetTextGraphics(){
        assertNotNull(gameViewer.getTextGraphics());
    }

    @Test
    void testHandleInput() throws IOException, NoSuchFieldException, IllegalAccessException {
        Screen mockScreen = Mockito.mock(Screen.class);

        KeyStroke keyStroke = new KeyStroke(KeyType.Enter);

        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GameViewer gameViewer = new GameViewer(mock(GameController.class));

        Field screenField = GameViewer.class.getDeclaredField("screen");
        screenField.setAccessible(true);
        screenField.set(gameViewer, mockScreen);

        KeyStroke result = gameViewer.handleInput();

        assertEquals(keyStroke, result);
    }

}

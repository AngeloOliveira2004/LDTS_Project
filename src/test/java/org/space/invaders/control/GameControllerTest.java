package org.space.invaders.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.gamestates.GameState;

import java.awt.desktop.AppForegroundListener;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class GameControllerTest {

    private MenuController menuController;
    private GameController gameController;

    @BeforeEach
    public void setUp() throws IOException {
        menuController = mock(MenuController.class);
        gameController = new GameController(menuController);
    }
/*
    @Test
    public void testChangeStateGame() throws IOException {
        gameController.changeState(ApplicationState.Game);
        assertEquals(ApplicationState.Game, gameController.getApplicationState());
        verify(menuController, never()).changeState(any());
    }


    @Test
    public void testChangeStatePauseMenu() throws IOException {
        gameController.changeState(ApplicationState.PauseMenu);
        assertEquals(ApplicationState.PauseMenu, gameController.getApplicationState());
        verify(menuController, times(1)).changeState(ApplicationState.PauseMenu);
    }

    @Test
    public void testChangeStateMainMenu() throws IOException {
        gameController.changeState(ApplicationState.MainMenu);
        assertEquals(ApplicationState.MainMenu, gameController.getApplicationState());
        verify(menuController, times(1)).changeState(ApplicationState.MainMenu);
    }

    @Test
    public void testChangeStateGameOverMenu() throws IOException {
        gameController.changeState(ApplicationState.GameOverMenu);
        assertEquals(ApplicationState.GameOverMenu, gameController.getApplicationState());
        verify(menuController, times(1)).changeState(ApplicationState.GameOverMenu);
    }

    @Test
    public void testHandleInputEscape() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.Escape);
        GameState gameState = mock(GameState.class);
        gameController.setGameState(gameState);

        gameController.handleInput(keyStroke);

        verify(gameState, times(1)).close();
        verify(gameState, times(1)).setRunning(true);
        verify(gameState, times(1)).setPaused(false);
        verify(gameState, times(1)).run();
        assertEquals(ApplicationState.MainMenu, gameController.getApplicationState());
    }
/*
    @Test
    public void testHandleInputEOF() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.EOF);
        gameController.setState(new GameState(gameController));
        gameController.handleInput(keyStroke);

        assertEquals(ApplicationState.MainMenu, gameController.getApplicationState());
    }

 */
}

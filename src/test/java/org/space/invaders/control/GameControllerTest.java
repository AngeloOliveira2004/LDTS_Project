package org.space.invaders.control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.State;
import org.space.invaders.states.gamestates.GameState;
import org.space.invaders.states.menustates.GameOverState;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameControllerTest{

    private MenuController menuController;
    private GameController gameController;

    @BeforeEach
    public void setUp() throws IOException {
        menuController = mock(MenuController.class);
        gameController = new GameController(menuController);
        GameState gameState = mock(GameState.class);
        gameController.setGameState(gameState);
    }

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
    void testGetAndSetState() throws IOException {
        gameController = new GameController(mock(MenuController.class));
        GameOverState gameOverState = mock(GameOverState.class);
        gameController.setState(gameOverState);

        assertEquals(gameOverState , gameController.getState());
    }

    @Test
    void testGetAppliationState() throws IOException {
        gameController = new GameController(mock(MenuController.class));
        assertEquals(null , gameController.getGameState());
    }
}
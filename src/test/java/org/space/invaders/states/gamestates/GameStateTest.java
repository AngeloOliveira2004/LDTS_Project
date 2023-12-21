package org.space.invaders.states.gamestates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.space.invaders.control.GameController;
import org.space.invaders.control.game.PlayerController;
import org.space.invaders.model.Arena;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.State;
import org.space.invaders.states.gamestates.GameState;
import org.space.invaders.view.GameViewer;

import java.io.IOException;

class GameStateTest {

    private GameController gameController;
    private GameState gameState;
    private GameViewer gameViewer;
    private Arena arena;

    @BeforeEach
    void setUp() throws IOException {
        /*
        gameController = mock(GameController.class);

        gameState = new GameState(gameController);

        when(gameState.getController()).thenReturn(gameController);
        when(gameState.getArena()).thenReturn(new Arena());

        when(gameState.getRunning()).thenReturn(true);

        System.out.println(gameController);
        gameState.setGameController(gameController);

        gameViewer = mock(GameViewer.class);
        arena = gameState.getArena();
        */
    }

    @Test
    void testConstructor() {
        assertNotNull(gameState.getController());
        assertTrue(gameState.getRunning());
        assertFalse(gameState.isPaused());
    }

    @Test
    void testRun() throws IOException {
        // Mock the behavior of gameViewer.handleInput() to return a specific KeyStroke (e.g., escape key)
        when(gameViewer.handleInput()).thenReturn(new KeyStroke(KeyType.Escape));

        // Run the game loop for a short time to simulate the game execution
        gameState.run();

        // Add assertions based on the expected behavior during the run
        verify(gameViewer, atLeastOnce()).drawElements(arena);
        verify(gameViewer, atLeastOnce()).refresh();
        verify(gameController, atLeastOnce()).changeState(any(ApplicationState.class));
    }

    @Test
    void testHandleInput() throws IOException {
        Arena arena = new Arena();
        GameViewer mockViewer = mock(GameViewer.class);
        gameController = mock(GameController.class);

        GameState gameState = new GameState(gameController);

        gameState.setGameViewer(mockViewer);
        mockViewer.setGameController(gameController);
        gameState.setGameController(mock(GameController.class));
        gameState.setPlayerController(mock(PlayerController.class));

        gameState.setArena(arena);
        arena.killAlllifes();

        when(mockViewer.handleInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));

        gameState.run(); // Run the game loop to handle input

        verify(mockViewer , times(1)).close();
        verify(gameController, atLeastOnce()).changeState(ApplicationState.GameOverMenu);
    }

    @Test
    void testWriteFinalScoreToFile() {
        long finalScore = 1000;
        String filename = "testLeaderboard.txt";

        String filePath = System.getProperty("user.dir") + "/src/test/resources/" + filename;

        GameState.writeFinalScoreToFile(finalScore, filePath);
    }


    @Test
    void testPaused() throws IOException {
        GameState gameState = new GameState(gameController);
        gameState.setGameViewer(mock(GameViewer.class));

        gameState.setPaused(true);

        assertTrue(gameState.isPaused());
    }
}

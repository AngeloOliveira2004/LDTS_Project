package org.space.invaders.states.gamestates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.space.invaders.control.GameController;
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
        gameState = mock(GameState.class);
        gameController = mock(GameController.class);
        System.out.println(gameController);
        gameState.setGameController(gameController);

        gameViewer = mock(GameViewer.class);
        arena = gameState.getArena();
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
        // Mock the behavior of gameViewer.handleInput() to return a specific KeyStroke (e.g., arrow key)
        when(gameViewer.handleInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));

        gameState.run(); // Run the game loop to handle input

        // Add assertions based on the expected behavior during input handling
        // For example, check if the playerController.keyPressed() method was called with the correct arguments
        verify(gameController, atLeastOnce()).changeState(any(ApplicationState.class));
    }

    @Test
    void testWriteFinalScoreToFile() {
        // Test the writeFinalScoreToFile method
        long finalScore = 1000;
        String filename = "testLeaderboard.txt";

        // Call the method
        GameState.writeFinalScoreToFile(finalScore, filename);

        // Add assertions to check if the file was created and written correctly
        // You may need to read the file or use additional methods to verify the outcome
    }

    // Add more test methods as needed

}

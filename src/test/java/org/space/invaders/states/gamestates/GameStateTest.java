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

    @Test
    void testConstructor() throws IOException {
        gameState = new GameState(mock(GameController.class));
        gameState.setGameViewer(mock(GameViewer.class));

        assertNotNull(gameState.getController());
        assertTrue(gameState.getRunning());
        assertFalse(gameState.isPaused());
    }

    @Test
    void testRun() throws IOException {
        arena = new Arena();
        gameViewer = mock(GameViewer.class);
        gameController = mock(GameController.class);
        PlayerController playerController = mock(PlayerController.class);

        gameState = mock(GameState.class);

        gameState.setGameController(gameController);
        gameState.setGameViewer(gameViewer);
        gameState.setPlayerController(playerController);

        gameState.setArena(arena);
        arena.setLifes(5);

        doAnswer(invocation ->
        {
            gameViewer.refresh();
            gameController.changeState(any());
            return null;
        }).when(gameState).run();

        gameState.run();

        verify(gameViewer, atLeastOnce()).refresh();
        verify(gameController, atLeastOnce()).changeState(any());
    }

    @Test
    void testHandleInput() throws IOException {
        arena = new Arena();
        gameViewer = mock(GameViewer.class);
        gameController = mock(GameController.class);
        PlayerController playerController = mock(PlayerController.class);

        gameState = new GameState(gameController);

        gameState.setGameViewer(gameViewer);
        gameState.setPlayerController(playerController);

        gameState.setArena(arena);
        arena.killAlllifes();

        gameState.run();

        verify(gameController, atLeastOnce()).changeState(ApplicationState.GameOverMenu);

        //---------------------2nd Test-----------------------

        arena.setLifes(5);

        gameState.run();
        verify(gameController, atLeastOnce()).changeState(ApplicationState.PauseMenu);

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

    @Test
    void testClose() throws IOException {
        gameState = new GameState(mock(GameController.class));
        gameViewer = mock(GameViewer.class);
        gameState.setGameViewer(gameViewer);

        gameState.setGameController(mock(GameController.class));

        gameState.close();
    }

    @Test
    void testStepAndStartScreen() throws IOException {
        gameState = new GameState(mock(GameController.class));
        gameViewer = mock(GameViewer.class);
        gameState.setGameViewer(gameViewer);

        gameState.startScreen();
        gameState.step();
    }
}

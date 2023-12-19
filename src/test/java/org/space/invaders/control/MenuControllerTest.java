package org.space.invaders.control;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.space.invaders.control.music.MusicController;
import org.space.invaders.control.music.Musics;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.Menu;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.gamestates.GameState;
import org.space.invaders.states.menustates.*;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class MenuControllerTest {

    private MenuController menuController;
    private MusicController musicController;
    private MenuGUI gui;
    private GameController gameController;

    @Before
    public void setUp() throws IOException {
        gui = mock(MenuGUI.class);
        musicController = mock(MusicController.class);
        gameController = mock(GameController.class);
        menuController = spy(new MenuController());
        menuController.setApplicationState(ApplicationState.MainMenu);
    }

    @Test
    public void testChangeStateGame() throws IOException {
        menuController.changeState(ApplicationState.Game);
        verify(musicController, times(1)).changeMusic(Musics.BACKGROUND);
        verify(gui, times(1)).close();
        verify(gameController, times(1)).changeState(ApplicationState.Game);
    }

    @Test
    public void testChangeStateMenuInstructions() throws IOException {
        menuController.changeState(ApplicationState.MenuInstructions);
        verify(menuController, times(1)).getApplicationState();
        verify(gui, times(1)).close();
        verify(menuController, times(1)).setApplicationState(ApplicationState.MenuInstructions);
        verify(menuController, times(1)).getApplicationState();
        verify(menuController, times(1)).getApplicationState();
    }

    @Test
    public void testChangeStateMenuLeaderboard() throws IOException {
        menuController.changeState(ApplicationState.MenuLeaderboard);
        // Add relevant verifications for MenuLeaderboard state
    }

    @Test
    public void testChangeStateMenuSettings() throws IOException {
        menuController.changeState(ApplicationState.MenuSettings);
        // Add relevant verifications for MenuSettings state
    }

    @Test
    public void testChangeStateExitMenu() throws IOException {
        menuController.changeState(ApplicationState.ExitMenu);
        // Add relevant verifications for ExitMenu state
    }

    @Test
    public void testChangeStateMainMenu() throws IOException {
        menuController.changeState(ApplicationState.MainMenu);
        // Add relevant verifications for MainMenu state
    }

    @Test
    public void testChangeStatePauseMenu() throws IOException {
        menuController.changeState(ApplicationState.PauseMenu);
        // Add relevant verifications for PauseMenu state
    }

    @Test
    public void testChangeStateGameOverMenu() throws IOException {
        menuController.changeState(ApplicationState.GameOverMenu);
        // Add relevant verifications for GameOverMenu state
    }

    // Additional tests as needed for specific scenarios in the MenuController class
}


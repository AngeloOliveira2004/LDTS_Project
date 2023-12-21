package org.space.invaders.states.menustates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.space.invaders.control.MenuController;
import org.space.invaders.control.music.MusicController;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.GameOverModel;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.view.menu.GameOverView;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class GameOverStateTest {
    private MenuController menuController;
    private MenuGUI menuGui;
    private GameOverModel GameOverModel;
    private GameOverView GameOverView;
    private GameOverState gameOverState;

    @BeforeEach
    void setUp() {
        menuController = mock(MenuController.class);
        menuGui = mock(MenuGUI.class);
        GameOverModel = mock(GameOverModel.class);
        GameOverView = mock(GameOverView.class);

        // Stub/mock necessary methods in your setup
        // For example:
        when(menuGui.getScreen()).thenReturn(null);
        when(GameOverModel.validateApplicationState()).thenReturn(ApplicationState.MainMenu);
        // Mock other necessary methods and behaviors

        gameOverState = new GameOverState(menuController, menuGui);
    }

    @Test
    void testConstructor() {
        GameOverView GameOverView = mock(GameOverView.class);

        GameOverState GameOverState = new GameOverState(menuController, menuGui);

        assertSame(menuController, GameOverState.getMenuController());
        assertSame(menuGui, GameOverState.getGui());
    }
    @Test
    void testStep() throws IOException {
        gameOverState = new GameOverState(menuController, menuGui);

        GameOverView GameOverView = mock(GameOverView.class);
        GameOverModel mockGameOverModel = mock(GameOverModel.class);

        gameOverState.setMenuModel(mockGameOverModel);
        gameOverState.setMenuView(GameOverView);

        //doNothing().when(GameOverView.drawElements(any()));
        when(menuGui.getNextAction()).thenReturn(MenuGUI.ACTION.UP);


        gameOverState.step();

        verify(menuGui, times(1)).getNextAction();
        verify(menuGui, times(1)).clear();
        verify(GameOverView, times(1)).drawElements(any());
    }


    @Test
    void testActionUp() {
        gameOverState = new GameOverState(menuController, menuGui);
        GameOverModel GameOverModel = mock(GameOverModel.class);

        gameOverState.setMenuModel(GameOverModel);

        gameOverState.Action(MenuGUI.ACTION.UP);

        verify(GameOverModel, times(1)).setAcronymletterUP();
    }

    @Test
    void testActionDown() {
        gameOverState = new GameOverState(menuController, menuGui);
        GameOverModel GameOverModel = mock(GameOverModel.class);

        gameOverState.setMenuModel(GameOverModel);

        gameOverState.Action(MenuGUI.ACTION.DOWN);

        verify(GameOverModel, times(1)).setAcronymletterDOWN();
    }
    @Test
    void testActionEnter() throws IOException {
        menuController = mock(MenuController.class);

        gameOverState = new GameOverState(menuController , menuGui);
        GameOverModel gameOverModel = new GameOverModel();

        gameOverState.setMenuModel(gameOverModel);
        gameOverState.setMenuController(menuController);

        gameOverState.Action(MenuGUI.ACTION.ENTER);

        verify(menuController , times(1)).changeState(ApplicationState.MainMenu);
        verify(menuController , times(1)).setApplicationState(ApplicationState.MainMenu);
    }

    @Test
    void testActionLeft() {
        gameOverState = new GameOverState(menuController, menuGui);
        GameOverModel GameOverModel = mock(GameOverModel.class);

        gameOverState.setMenuModel(GameOverModel);

        gameOverState.Action(MenuGUI.ACTION.LEFT);

        verify(GameOverModel, times(1)).previousOptionIndex();
    }
    @Test
    void testActionRight(){
        gameOverState = new GameOverState(menuController, menuGui);
        GameOverModel GameOverModel = mock(GameOverModel.class);

        gameOverState.setMenuModel(GameOverModel);

        gameOverState.Action(MenuGUI.ACTION.RIGHT);

        verify(GameOverModel, times(1)).nextOptionIndex();
    }
    @Test
    void testStartScreen() {
        gameOverState.startScreen();
    }

    @Test
    void testIsRunning() {
        assertTrue(gameOverState.isRunning());
    }

    @Test
    void testRun() throws IOException {
        menuController = mock(MenuController.class);
        GameOverView = mock(GameOverView.class);
        menuGui = mock(MenuGUI.class);

        gameOverState = new GameOverState(menuController , menuGui);

        gameOverState.setMenuController(menuController);
        gameOverState.setGui(menuGui);
        gameOverState.setMenuView(GameOverView);

        when(menuController.getApplicationState())
                .thenReturn(ApplicationState.GameOverMenu)
                .thenReturn(ApplicationState.GameOverMenu)
                .thenReturn(ApplicationState.ExitMenu);

        gameOverState.run();

        if(menuController.getApplicationState() == ApplicationState.GameOverMenu)
        {
            verify(menuGui, atLeastOnce()).refresh();
            verify(GameOverView, atLeastOnce()).draw(any());
        }
    }

    @Test
    void testClose() throws IOException {
        gameOverState.close();
    }
}


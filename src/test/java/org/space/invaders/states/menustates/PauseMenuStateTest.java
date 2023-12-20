package org.space.invaders.states.menustates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.space.invaders.control.MenuController;
import org.space.invaders.control.music.MusicController;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.PauseMenuModel;
import org.space.invaders.model.game.menu.PauseMenuModel;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.view.menu.PauseMenuView;
import org.space.invaders.view.menu.PauseMenuView;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class PauseMenuStateTest {
    private MenuController menuController;
    private MenuGUI menuGui;
    private PauseMenuModel pauseMenuModel;
    private PauseMenuView PauseMenuView;
    private PauseMenuState pauseMenuState;

    @BeforeEach
    void setUp() {
        menuController = mock(MenuController.class);
        menuGui = mock(MenuGUI.class);
        pauseMenuModel = mock(PauseMenuModel.class);
        PauseMenuView = mock(PauseMenuView.class);

        when(menuGui.getScreen()).thenReturn(null);
        when(pauseMenuModel.validateApplicationState()).thenReturn(ApplicationState.MainMenu);

        pauseMenuState = new PauseMenuState(menuController, menuGui);
    }

    @Test
    void testConstructor() {
        PauseMenuView pauseMenuView = mock(PauseMenuView.class);

        PauseMenuState pauseMenuState = new PauseMenuState(menuController, menuGui);

        assertSame(menuController, pauseMenuState.getMenuController());
        assertSame(menuGui, pauseMenuState.getGui());
    }
    @Test
    void testStep() throws IOException {
        pauseMenuState = new PauseMenuState(menuController, menuGui);

        PauseMenuView pauseMenuView = mock(PauseMenuView.class);
        PauseMenuModel mockPauseMenuModel = mock(PauseMenuModel.class);

        pauseMenuState.setMenuModel(mockPauseMenuModel);
        pauseMenuState.setPauseMenuVIew(pauseMenuView);

        when(menuGui.getNextAction()).thenReturn(MenuGUI.ACTION.UP);

        pauseMenuState.step();

        verify(mockPauseMenuModel, times(1)).previousOption();
    }


    @Test
    void testActionUp() {
        pauseMenuState.setMenuModel(new PauseMenuModel());
        PauseMenuModel pauseMenuModel = pauseMenuState.getModel();

        ApplicationState applicationState = pauseMenuModel.validateApplicationState();

        pauseMenuState.Action(MenuGUI.ACTION.UP);
        pauseMenuState.Action(MenuGUI.ACTION.UP);

        ApplicationState applicationState1 = pauseMenuModel.validateApplicationState();

        assertEquals(applicationState , applicationState1);


        pauseMenuState = new PauseMenuState(menuController, menuGui);
        PauseMenuModel PauseMenuModel = mock(PauseMenuModel.class);

        pauseMenuState.setMenuModel(PauseMenuModel);

        pauseMenuState.Action(MenuGUI.ACTION.UP);

        verify(PauseMenuModel, times(1)).previousOption();
    }

    @Test
    void testActionDown() {
        pauseMenuState.setMenuModel(new PauseMenuModel());
        pauseMenuModel = pauseMenuState.getModel();

        ApplicationState applicationState = pauseMenuModel.validateApplicationState();

        pauseMenuState.Action(MenuGUI.ACTION.DOWN);
        pauseMenuState.Action(MenuGUI.ACTION.DOWN);

        ApplicationState applicationState1 = pauseMenuModel.validateApplicationState();

        assertEquals(applicationState , applicationState1);

        pauseMenuState = new PauseMenuState(menuController, menuGui);
        PauseMenuModel PauseMenuModel = mock(PauseMenuModel.class);

        pauseMenuState.setMenuModel(PauseMenuModel);

        pauseMenuState.Action(MenuGUI.ACTION.DOWN);

        verify(PauseMenuModel, times(1)).nextOption();
    }
    @Test
    void testActionEnter() throws IOException {
        PauseMenuModel PauseMenuModel = mock(PauseMenuModel.class);
        menuController = mock(MenuController.class);
        when(PauseMenuModel.validateApplicationState()).thenReturn(ApplicationState.MenuSettings);
        pauseMenuState.setMenuModel(PauseMenuModel);
        pauseMenuState.setMenuController(menuController);

        pauseMenuState.Action(MenuGUI.ACTION.ENTER);

        verify(menuController , times(1)).changeState(ApplicationState.MenuSettings);
    }


    @Test
    void testStartScreen() {
        pauseMenuState.startScreen();
    }
    @Test
    void testIsRunning() {
        assertFalse(pauseMenuState.isRunning());
    }
    @Test
    void testRun() throws IOException {
        menuController = mock(MenuController.class);
        PauseMenuView = mock(PauseMenuView.class);
        menuGui = mock(MenuGUI.class);

        pauseMenuState = new PauseMenuState(menuController , menuGui);

        pauseMenuState.setMenuController(menuController);
        pauseMenuState.setGui(menuGui);
        pauseMenuState.setMenuView(PauseMenuView);

        when(menuController.getApplicationState())
                .thenReturn(ApplicationState.PauseMenu)
                .thenReturn(ApplicationState.PauseMenu)
                .thenReturn(ApplicationState.ExitMenu);

        pauseMenuState.run();

        if(menuController.getApplicationState() == ApplicationState.PauseMenu)
        {
            verify(menuGui, atLeastOnce()).refresh();
            verify(PauseMenuView, atLeastOnce()).draw(any());
        }
    }

}

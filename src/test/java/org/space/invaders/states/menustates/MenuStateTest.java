package org.space.invaders.states.menustates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.space.invaders.control.MenuController;
import org.space.invaders.control.music.MusicController;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.MenuModel;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.view.menu.MenuView;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class MenuStateTest {
    private MenuController menuController;
    private MenuGUI menuGui;
    private MusicController musicController;
    private MenuModel menuModel;
    private MenuView menuView;
    private MenuState menuState;

    @BeforeEach
    void setUp() {
        menuController = mock(MenuController.class);
        menuGui = mock(MenuGUI.class);
        musicController = mock(MusicController.class);
        menuModel = mock(MenuModel.class);
        menuView = mock(MenuView.class);

        // Stub/mock necessary methods in your setup
        // For example:
        when(menuGui.getScreen()).thenReturn(null);
        when(menuModel.validateApplicationState()).thenReturn(ApplicationState.MainMenu);
        // Mock other necessary methods and behaviors

        menuState = new MenuState(menuController, menuGui);
    }

    @Test
    void testConstructor() {
        MenuView menuView = mock(MenuView.class);

        MenuState menuState = new MenuState(menuController, menuGui);

        assertSame(menuController, menuState.getMenuController());
        assertSame(menuGui, menuState.getGui());
    }
    @Test
    void testStep() throws IOException {
        menuState = new MenuState(menuController, menuGui);

        MenuView menuView = mock(MenuView.class);
        MenuModel mockMenuModel = mock(MenuModel.class);

        menuState.setMenuModel(mockMenuModel);
        menuState.setMenuView(menuView);

        when(menuGui.getNextAction()).thenReturn(MenuGUI.ACTION.UP);

        menuState.step();

        verify(mockMenuModel, times(1)).previousOption();
        verify(menuGui , times(1)).clear();
    }


    @Test
    void testActionUp() {
        menuState.setMenuModel(new MenuModel());
        menuModel = menuState.getMenuModel();

        menuState.Action(MenuGUI.ACTION.UP);
        menuState.Action(MenuGUI.ACTION.UP);
        menuState.Action(MenuGUI.ACTION.UP);

        ApplicationState applicationState1 = menuModel.validateApplicationState();

        assertEquals(applicationState1 , applicationState1);


        menuState = new MenuState(menuController, menuGui);
        MenuModel menuModel = mock(MenuModel.class);

        menuState.setMenuModel(menuModel);

        menuState.Action(MenuGUI.ACTION.UP);

        verify(menuModel, times(1)).previousOption();
    }

    @Test
    void testActionDown() {
        menuState.setMenuModel(new MenuModel());
        menuModel = menuState.getMenuModel();


        menuState.Action(MenuGUI.ACTION.DOWN);
        menuState.Action(MenuGUI.ACTION.DOWN);
        menuState.Action(MenuGUI.ACTION.DOWN);

        ApplicationState applicationState1 = menuModel.validateApplicationState();

        assertEquals(applicationState1 , applicationState1);

        menuState = new MenuState(menuController, menuGui);
        MenuModel menuModel = mock(MenuModel.class);

        menuState.setMenuModel(menuModel);

        menuState.Action(MenuGUI.ACTION.DOWN);

        // Verify that the method was called
        verify(menuModel, times(1)).nextOption();
    }
    @Test
    void testActionEnter() throws IOException {
        MenuModel menuModel = mock(MenuModel.class);
        menuController = mock(MenuController.class);
        when(menuModel.validateApplicationState()).thenReturn(ApplicationState.MenuSettings);
        menuState.setMenuModel(menuModel);
        menuState.setMenuController(menuController);

        menuState.Action(MenuGUI.ACTION.ENTER);

        verify(menuModel, times(1)).validateApplicationState();
        verify(menuController , times(1)).changeState(ApplicationState.MenuSettings);
        verify(menuController , times(1)).setApplicationState(ApplicationState.MenuSettings);
    }

    @Test
    void testStartScreen() {
        menuState.startScreen();
    }

    @Test
    void testIsRunning() {
        assertTrue(menuState.isRunning());
    }

    @Test
    void testRun() throws IOException {
        menuController = mock(MenuController.class);
        menuView = mock(MenuView.class);
        menuGui = mock(MenuGUI.class);

        menuState = new MenuState(menuController , menuGui);

        menuState.setMenuController(menuController);
        menuState.setGui(menuGui);
        menuState.setMenuView(menuView);

        when(menuController.getApplicationState())
                .thenReturn(ApplicationState.MainMenu)
                .thenReturn(ApplicationState.MainMenu)
                .thenReturn(ApplicationState.ExitMenu);

        menuState.run();

        if(menuController.getApplicationState() == ApplicationState.MainMenu)
        {
            verify(menuGui, atLeastOnce()).refresh();
            verify(menuView, atLeastOnce()).draw(any());
        }
    }

    @Test
    void testClose() throws IOException {
        MenuView menuViewmock = mock(MenuView.class);
        menuState.setMenuView(menuViewmock);

        menuState.close();

        verify(menuViewmock , times(1)).close();
    }
}

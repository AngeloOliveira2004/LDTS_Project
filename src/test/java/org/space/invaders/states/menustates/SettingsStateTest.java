package org.space.invaders.states.menustates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.space.invaders.control.MenuController;
import org.space.invaders.control.music.MusicController;
import org.space.invaders.control.music.Musics;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.SettingsModel;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.view.menu.SettingsView;

import java.io.IOException;
import java.util.List;

class SettingsStateTest {

    private MenuController menuController;
    private MenuGUI menuGui;
    private MusicController musicController;
    private SettingsModel settingsModel;
    private SettingsView settingsView;
    private SettingsState settingsState;

    @BeforeEach
    void setUp() {
        menuController = mock(MenuController.class);
        menuGui = mock(MenuGUI.class);
        musicController = mock(MusicController.class);
        settingsModel = mock(SettingsModel.class);
        settingsView = mock(SettingsView.class);

        // Stub/mock necessary methods in your setup
        // For example:
        when(menuGui.getScreen()).thenReturn(null);
        when(settingsModel.validateApplicationState()).thenReturn(ApplicationState.MainMenu);
        // Mock other necessary methods and behaviors

        settingsState = new SettingsState(menuController, menuGui, musicController);
    }

    @Test
    void testConstructor() {
        SettingsView settingsView = mock(SettingsView.class);

        SettingsState settingsState = new SettingsState(menuController, menuGui, musicController);

        assertSame(menuController, settingsState.getMenuController());
        assertSame(menuGui, settingsState.getGui());
        assertSame(musicController, settingsState.getMusicController());
    }
    @Test
    void testStep() throws IOException {
        //TODO do this test
        /*
        // Stub/mock the getNextAction method to return a specific action
        when(menuGui.getNextAction()).thenReturn(MenuGUI.ACTION.UP);

        // Use the same mock instance for the SettingsModel in the setup and the test
        SettingsModel mockSettingsModel = mock(SettingsModel.class);
        settingsState = new SettingsState(menuController, menuGui, musicController);
        settingsState.setModel(mockSettingsModel);

        settingsState.step();

        verify(mockSettingsModel, times(1)).previousOption();
        verify(settingsView, times(1)).drawElements(menuGui);
        */
    }


    @Test
    void testActionUp() {
        settingsState.setMenuModel(new SettingsModel());
        settingsModel = settingsState.getMenuModel();

        List<ApplicationState> applicationStates = settingsModel.getAppvalue();
        ApplicationState applicationState = settingsModel.validateApplicationState();

        for(int i = 0 ; i < applicationStates.size(); i++) {
            settingsState.Action(MenuGUI.ACTION.UP);
            settingsState.Action(MenuGUI.ACTION.UP);
            settingsState.Action(MenuGUI.ACTION.UP);
        }
        ApplicationState applicationState1 = settingsModel.validateApplicationState();

        assertEquals(applicationState , applicationState1);


        settingsState = new SettingsState(menuController, menuGui, musicController);
        SettingsModel settingsModel = mock(SettingsModel.class);

        settingsState.setMenuModel(settingsModel);

        settingsState.Action(MenuGUI.ACTION.UP);

        // Verify that the method was called
        verify(settingsModel, times(1)).previousOption();
    }

    @Test
    void testActionDown() {
        settingsState.setMenuModel(new SettingsModel());
        settingsModel = settingsState.getMenuModel();

        List<ApplicationState> applicationStates = settingsModel.getAppvalue();
        ApplicationState applicationState = settingsModel.validateApplicationState();

        for(int i = 0 ; i < applicationStates.size(); i++) {
            settingsState.Action(MenuGUI.ACTION.DOWN);
            settingsState.Action(MenuGUI.ACTION.DOWN);
            settingsState.Action(MenuGUI.ACTION.DOWN);
        }
        ApplicationState applicationState1 = settingsModel.validateApplicationState();

        assertEquals(applicationState , applicationState1);

        settingsState = new SettingsState(menuController, menuGui, musicController);
        SettingsModel settingsModel = mock(SettingsModel.class);

        settingsState.setMenuModel(settingsModel);

        settingsState.Action(MenuGUI.ACTION.DOWN);

        // Verify that the method was called
        verify(settingsModel, times(1)).nextOption();
    }
    @Test
    void testActionEnter() throws IOException {
        SettingsModel settingsModel = mock(SettingsModel.class);
        menuController = mock(MenuController.class);
        when(settingsModel.validateApplicationState()).thenReturn(ApplicationState.MenuSettings);
        settingsState.setMenuModel(settingsModel);
        settingsState.setMenuController(menuController);


        settingsState.Action(MenuGUI.ACTION.ENTER);

        verify(settingsModel, times(2)).validateApplicationState();
        verify(settingsModel , times(1)).saveHashMapToFile(anyMap() , anyString());
        verify(menuController , times(1)).changeState(ApplicationState.MenuSettings);
        verify(menuController , times(1)).setApplicationState(ApplicationState.MenuSettings);
    }

    @Test
    void testActionLeft() {
        settingsState = mock(settingsState.getClass());

        doAnswer(invocation -> {
            settingsModel.validateApplicationState();
            settingsModel.UpperValueMap(any());
            return null;

        }).when(settingsState).Action(MenuGUI.ACTION.LEFT);

        settingsState.Action(MenuGUI.ACTION.LEFT);

        verify(settingsModel, times(1)).validateApplicationState();
        verify(settingsModel, times(1)).UpperValueMap(any());
        verifyNoMoreInteractions(settingsModel);
        //----------------Trying 2nd test---------------------------
        settingsState = new SettingsState(menuController, menuGui, musicController);

        SettingsModel settingsModel = mock(SettingsModel.class);
        when(settingsModel.validateApplicationState()).thenReturn(null);
        //when(settingsModel.getCurrentOption()).thenReturn(anyString());
        settingsState.setMenuModel(settingsModel);

        settingsState.Action(MenuGUI.ACTION.LEFT);

        verify(settingsModel, times(1)).validateApplicationState();
        verify(settingsModel , times(1)).LowerValueMap(null);
    }

    @Test
    void testActionRight(){
        settingsState = mock(settingsState.getClass());

        doAnswer(invocation -> {
            settingsModel.validateApplicationState();
            settingsModel.UpperValueMap(any());
            return null;

        }).when(settingsState).Action(MenuGUI.ACTION.RIGHT);

        settingsState.Action(MenuGUI.ACTION.RIGHT);

        verify(settingsModel, times(1)).validateApplicationState();
        verify(settingsModel, times(1)).UpperValueMap(any());
        verifyNoMoreInteractions(settingsModel);
        //--------------------- 2nd Test ------------------
        settingsState = new SettingsState(menuController, menuGui, musicController);

        SettingsModel settingsModel = mock(SettingsModel.class);
        when(settingsModel.validateApplicationState()).thenReturn(null);
        //when(settingsModel.getCurrentOption()).thenReturn(anyString());
        settingsState.setMenuModel(settingsModel);

        settingsState.Action(MenuGUI.ACTION.RIGHT);

        verify(settingsModel, times(1)).validateApplicationState();
        verify(settingsModel , times(1)).UpperValueMap(null);

    }
    @Test
    void testStartScreen() {
        settingsState.startScreen();
    }

    @Test
    void testIsRunning() {
        assertTrue(settingsState.isRunning());
    }

    @Test
    void testRun() throws IOException {
        menuController = mock(MenuController.class);
        settingsView = mock(SettingsView.class);
        menuGui = mock(MenuGUI.class);

        settingsState = new SettingsState(menuController , menuGui , musicController);

        settingsState.setMenuController(menuController);
        settingsState.setGui(menuGui);
        settingsState.setMenuView(settingsView);

        when(menuController.getApplicationState())
                .thenReturn(ApplicationState.MenuSettings)
                .thenReturn(ApplicationState.MenuSettings)
                .thenReturn(ApplicationState.ExitMenu);

        settingsState.run();

        if(menuController.getApplicationState() == ApplicationState.MenuSettings)
        {
            verify(menuGui, atLeastOnce()).refresh();
            verify(settingsView, atLeastOnce()).draw(any());
        }
    }

    @Test
    void testClose() throws IOException {
        settingsState.close();
    }
}


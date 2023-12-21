package org.space.invaders.states.menustates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.space.invaders.control.MenuController;
import org.space.invaders.control.music.MusicController;
import org.space.invaders.gui.GUI;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.LeaderboardModel;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.view.menu.LeaderboardView;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class LeaderBoardStateTest {
    private MenuController menuController;
    private MenuGUI menuGui;
    private LeaderboardModel LeaderboardModel;
    private LeaderboardView LeaderboardView;
    private LeaderBoardState LeaderBoardState;

    @BeforeEach
    void setUp() {
        menuController = mock(MenuController.class);
        menuGui = mock(MenuGUI.class);
        LeaderboardModel = mock(LeaderboardModel.class);
        LeaderboardView = mock(LeaderboardView.class);

        // Stub/mock necessary methods in your setup
        // For example:
        when(menuGui.getScreen()).thenReturn(null);
        when(LeaderboardModel.validateApplicationState()).thenReturn(ApplicationState.MainMenu);
        // Mock other necessary methods and behaviors

        LeaderBoardState = new LeaderBoardState(menuController, menuGui);
    }

    @Test
    void testConstructor() {
        LeaderboardView leaderboardView = mock(LeaderboardView.class);

        LeaderBoardState LeaderBoardState = new LeaderBoardState(menuController, menuGui);

        assertSame(menuController, LeaderBoardState.getMenuController());
        assertSame(menuGui, LeaderBoardState.getGui());
    }
    @Test
    void testStep() throws IOException {
        LeaderBoardState = new LeaderBoardState(menuController, menuGui);

        LeaderboardView LeaderboardView = mock(LeaderboardView.class);
        LeaderboardModel mockLeaderboardModel = mock(LeaderboardModel.class);
        MenuGUI menuGUI = mock(MenuGUI.class);

        LeaderBoardState.setMenuModel(mockLeaderboardModel);
        LeaderBoardState.setMenuView(LeaderboardView);
        LeaderBoardState.setGui(menuGUI);
        //doNothing().when(LeaderboardView.drawElements(any()));
        when(menuGui.getNextAction()).thenReturn(MenuGUI.ACTION.UP);

        LeaderBoardState.step();

        verify(menuGUI, times(1)).getNextAction();
        verify(menuGUI, times(1)).clear();
        verify(LeaderboardView, times(1)).drawElements(any());

    }
    @Test
    void testActionEnter() throws IOException {
        LeaderboardModel LeaderboardModel = mock(LeaderboardModel.class);
        menuController = mock(MenuController.class);
        when(LeaderboardModel.validateApplicationState()).thenReturn(ApplicationState.MenuLeaderboard);
        LeaderBoardState.setMenuModel(LeaderboardModel);
        LeaderBoardState.setMenuController(menuController);

        LeaderBoardState.Action(MenuGUI.ACTION.ENTER);

        verify(menuController , times(1)).changeState(ApplicationState.MainMenu);
        verify(menuController , times(1)).setApplicationState(ApplicationState.MainMenu);
    }

    @Test
    void testStartScreen() {
        LeaderBoardState.startScreen();
    }

    @Test
    void testIsRunning() {
        assertTrue(LeaderBoardState.isRunning());
    }

    @Test
    void testRun() throws IOException {
        menuController = mock(MenuController.class);
        LeaderboardView = mock(LeaderboardView.class);
        menuGui = mock(MenuGUI.class);

        LeaderBoardState = new LeaderBoardState(menuController , menuGui);

        LeaderBoardState.setMenuController(menuController);
        LeaderBoardState.setGui(menuGui);
        LeaderBoardState.setMenuView(LeaderboardView);

        when(menuController.getApplicationState())
                .thenReturn(ApplicationState.MenuLeaderboard)
                .thenReturn(ApplicationState.MenuLeaderboard)
                .thenReturn(ApplicationState.ExitMenu);

        LeaderBoardState.run();

        if(menuController.getApplicationState() == ApplicationState.MenuLeaderboard)
        {
            verify(menuGui, atLeastOnce()).refresh();
            verify(LeaderboardView, atLeastOnce()).draw(any());
        }
    }

    @Test
    void testClose() throws IOException {
        LeaderBoardState.close();
    }
}

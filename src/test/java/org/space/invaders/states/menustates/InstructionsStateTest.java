package org.space.invaders.states.menustates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.space.invaders.control.MenuController;
import org.space.invaders.control.music.MusicController;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.InstructionsModel;
import org.space.invaders.model.game.menu.InstructionsModel;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.view.menu.InstructionsView;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class InstructionsStateTest {
    private MenuController menuController;
    private MenuGUI menuGui;
    private InstructionsModel InstructionsModel;
    private InstructionsView InstructionsView;
    private InstructionsState InstructionsState;

    @BeforeEach
    void setUp() {
        menuController = mock(MenuController.class);
        menuGui = mock(MenuGUI.class);
        InstructionsModel = mock(InstructionsModel.class);
        InstructionsView = mock(InstructionsView.class);

        // Stub/mock necessary methods in your setup
        // For example:
        when(menuGui.getScreen()).thenReturn(null);
        when(InstructionsModel.validateApplicationState()).thenReturn(ApplicationState.MainMenu);
        // Mock other necessary methods and behaviors

        InstructionsState = new InstructionsState(menuController, menuGui);
    }

    @Test
    void testConstructor() {
        InstructionsState InstructionsState = new InstructionsState(menuController, menuGui);

        assertSame(menuController, InstructionsState.getMenuController());
        assertSame(menuGui, InstructionsState.getGui());
    }
    @Test
    void testStep() throws IOException {
        InstructionsState = new InstructionsState(menuController, menuGui);

        InstructionsView InstructionsView = mock(InstructionsView.class);
        InstructionsModel mockInstructionsModel = mock(InstructionsModel.class);

        InstructionsState.setMenuModel(mockInstructionsModel);
        InstructionsState.setMenuView(InstructionsView);

        //doNothing().when(InstructionsView.drawElements(any()));
        when(menuGui.getNextAction()).thenReturn(MenuGUI.ACTION.UP);

        InstructionsState.step();

        verify(menuGui, times(1)).getNextAction();
        verify(menuGui, times(1)).clear();
        verify(InstructionsView, times(1)).drawElements(any());

    }

    @Test
    void testActionEnter() throws IOException {
        InstructionsModel InstructionsModel = mock(InstructionsModel.class);
        menuController = mock(MenuController.class);
        when(InstructionsModel.validateApplicationState()).thenReturn(ApplicationState.MenuInstructions);
        InstructionsState.setMenuModel(InstructionsModel);
        InstructionsState.setMenuController(menuController);


        InstructionsState.Action(MenuGUI.ACTION.ENTER);

        verify(menuController , times(1)).changeState(ApplicationState.MainMenu);
        verify(menuController , times(1)).setApplicationState(ApplicationState.MainMenu);
    }

    @Test
    void testStartScreen() {
        InstructionsState.startScreen();
    }

    @Test
    void testIsRunning() {
        assertTrue(InstructionsState.isRunning());
    }

    @Test
    void testRun() throws IOException {
        menuController = mock(MenuController.class);
        InstructionsView = mock(InstructionsView.class);
        menuGui = mock(MenuGUI.class);

        InstructionsState = new InstructionsState(menuController , menuGui);

        InstructionsState.setMenuController(menuController);
        InstructionsState.setGui(menuGui);
        InstructionsState.setMenuView(InstructionsView);

        when(menuController.getApplicationState())
                .thenReturn(ApplicationState.MenuInstructions)
                .thenReturn(ApplicationState.MenuInstructions)
                .thenReturn(ApplicationState.ExitMenu);

        InstructionsState.run();

        if(menuController.getApplicationState() == ApplicationState.MenuInstructions)
        {
            verify(menuGui, atLeastOnce()).refresh();
            verify(InstructionsView, atLeastOnce()).draw(any());
        }
    }

    @Test
    void testClose() throws IOException {
        InstructionsState.close();
    }
}

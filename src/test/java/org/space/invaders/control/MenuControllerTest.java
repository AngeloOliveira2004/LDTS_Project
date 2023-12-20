package org.space.invaders.control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.space.invaders.states.ApplicationState;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MenuControllerTest {
/*
    private MenuController menuController;
    @BeforeEach
    void setUp() {
        // Create a mock for MenuController
        menuController = mock(MenuController.class);
    }

    @Test
    public void testChangeStateGame() throws IOException {

        menuController = mock(MenuController.class);

        menuController.changeState(ApplicationState.Game);
        verify(menuController, times(1)).changeState(ApplicationState.Game);
        verify(menuController , times(1)).swtichApplicationState(ApplicationState.Game);
    }

    @Test
    void testChangeStateMenuInstructions() {
        // Mock the behavior of changeState method
        when(menuController.getApplicationState()).thenReturn(ApplicationState.MainMenu);

        // Test changing state to MenuInstructions
        try {
            menuController.changeState(ApplicationState.MenuInstructions);
            verify(menuController, times(1)).changeState(ApplicationState.MenuInstructions);
            assertEquals(ApplicationState.MenuInstructions, menuController.getApplicationState());
            // Add more assertions based on the expected behavior when changing to MenuInstructions state
        } catch (Exception e) {
            fail("Exception thrown while changing state to MenuInstructions: " + e.getMessage());
        }
    }

    // Add similar test methods for other ApplicationState values

    @Test
    void testGetApplicationState() {
        // Mock the behavior of getApplicationState method
        when(menuController.getApplicationState()).thenReturn(ApplicationState.MainMenu);

        // Test getting the application state
        assertEquals(ApplicationState.MainMenu, menuController.getApplicationState());
        // Modify the state and test again
        when(menuController.getApplicationState()).thenReturn(ApplicationState.Game);
        assertEquals(ApplicationState.Game, menuController.getApplicationState());
    }

    // Add more test methods as needed
    */
}

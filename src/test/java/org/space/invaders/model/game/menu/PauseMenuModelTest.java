package org.space.invaders.model.game.menu;

import org.junit.jupiter.api.Test;
import org.space.invaders.states.ApplicationState;
import static org.junit.jupiter.api.Assertions.*;

class PauseMenuModelTest {

    @Test
    void testDefaultConstructor() {
        PauseMenuModel pauseMenuModel = new PauseMenuModel();
        assertEquals(ApplicationState.Game, pauseMenuModel.validateApplicationState());
        assertEquals(2, pauseMenuModel.getNumberOptions());
        assertEquals("Back to Game", pauseMenuModel.getOption(0));
        assertEquals("Back to Menu Without Save", pauseMenuModel.getOption(1));
    }

    @Test
    void testValidateApplicationState() {
        PauseMenuModel pauseMenuModel = new PauseMenuModel();
        assertEquals(ApplicationState.Game, pauseMenuModel.validateApplicationState());
        pauseMenuModel.nextOption();
        assertEquals(ApplicationState.MainMenu, pauseMenuModel.validateApplicationState());
        pauseMenuModel.nextOption();
        assertEquals(ApplicationState.Game, pauseMenuModel.validateApplicationState());
    }
}

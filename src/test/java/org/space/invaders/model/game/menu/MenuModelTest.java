package org.space.invaders.model.game.menu;

import org.junit.jupiter.api.Test;
import org.space.invaders.states.ApplicationState;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MenuModelTest {

    @Test
    void testDefaultConstructor() {
        MenuModel menuModel = new MenuModel();
        assertEquals(ApplicationState.Game, menuModel.validateApplicationState());
        assertEquals(5, menuModel.getNumberOptions());
        assertEquals("New Game", menuModel.getOption(0));
        assertEquals("Instructions", menuModel.getOption(1));
        assertEquals("Settings", menuModel.getOption(2));
        assertEquals("Leaderboard", menuModel.getOption(3));
        assertEquals("Exit", menuModel.getOption(4));
    }

    @Test
    void testValidateApplicationState() {
        MenuModel menuModel = new MenuModel();
        assertEquals(ApplicationState.Game, menuModel.validateApplicationState());
        menuModel.nextOption();
        assertEquals(ApplicationState.MenuInstructions, menuModel.validateApplicationState());
        menuModel.nextOption();
        assertEquals(ApplicationState.MenuSettings, menuModel.validateApplicationState());
        menuModel.nextOption();
        assertEquals(ApplicationState.MenuLeaderboard, menuModel.validateApplicationState());
        menuModel.nextOption();
        assertEquals(ApplicationState.ExitMenu, menuModel.validateApplicationState());
    }
}

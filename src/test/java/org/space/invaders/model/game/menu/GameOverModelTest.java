package org.space.invaders.model.game.menu;

import org.junit.jupiter.api.Test;
import org.space.invaders.states.ApplicationState;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GameOverModelTest {

    @Test
    void testDefaultConstructor() {
        GameOverModel gameOverModel = new GameOverModel();
        assertEquals(ApplicationState.MainMenu, gameOverModel.validateApplicationState());
        assertEquals("Back to Menu", gameOverModel.getOption(0));
    }

    @Test
    void testCustomConstructor() {
        List<String> customOptions = Arrays.asList("Option1", "Option2", "Option3");
        GameOverModel gameOverModel = new GameOverModel(customOptions);
        assertEquals(ApplicationState.MainMenu, gameOverModel.validateApplicationState());
        assertEquals("Option1", gameOverModel.getOption(0));
        assertEquals("Option2", gameOverModel.getOption(1));
        assertEquals("Option3", gameOverModel.getOption(2));
    }

    @Test
    void testNextAndPreviousOptionIndex() {
        GameOverModel gameOverModel = new GameOverModel();
        assertEquals(0, gameOverModel.getCurrentIndex());

        gameOverModel.nextOptionIndex();
        assertEquals(1, gameOverModel.getCurrentIndex());
        gameOverModel.nextOptionIndex();
        assertEquals(2, gameOverModel.getCurrentIndex());
        gameOverModel.nextOptionIndex();
        assertEquals(0, gameOverModel.getCurrentIndex());

        gameOverModel.previousOptionIndex();
        assertEquals(2, gameOverModel.getCurrentIndex());
        gameOverModel.previousOptionIndex();
        assertEquals(1, gameOverModel.getCurrentIndex());
        gameOverModel.previousOptionIndex();
        assertEquals(0, gameOverModel.getCurrentIndex());
    }

    @Test
    void testAcronymOperations() {
        GameOverModel gameOverModel = new GameOverModel();
        assertEquals("A", gameOverModel.getAcronymValue(0));
        assertEquals("B", gameOverModel.getAcronymValue(1));
        assertEquals("C", gameOverModel.getAcronymValue(2));
        gameOverModel.setAcronymletterUP();
        assertEquals("C", gameOverModel.getNamedAcronym()[0]);
        gameOverModel.setAcronymletterUP();
        assertEquals("D", gameOverModel.getNamedAcronym()[0]);
        gameOverModel.setAcronymletterUP();
        assertEquals("E", gameOverModel.getNamedAcronym()[0]);

        gameOverModel.setAcronymletterDOWN();
        assertEquals(3, gameOverModel.getAcronym()[0]);
        gameOverModel.setAcronymletterDOWN();
        assertEquals(2, gameOverModel.getAcronym()[0]);
        gameOverModel.setAcronymletterDOWN();
        assertEquals(1, gameOverModel.getAcronym()[0]);
    }

}

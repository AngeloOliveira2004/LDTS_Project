package org.space.invaders.model.game.menu;

import org.junit.jupiter.api.Test;
import org.space.invaders.states.ApplicationState;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InstructionsModelTest {

    @Test
    void testDefaultConstructor() {
        InstructionsModel instructionsModel = new InstructionsModel();
        assertEquals(ApplicationState.MainMenu, instructionsModel.validateApplicationState());
        assertEquals(1, instructionsModel.getNumberOptions());
        assertEquals("Back to Menu", instructionsModel.getOption(0));
    }

    @Test
    void testCustomConstructor() {
        List<String> customOptions = Arrays.asList("Option1", "Option2", "Option3");
        InstructionsModel instructionsModel = new InstructionsModel(customOptions);
        assertEquals(ApplicationState.MainMenu, instructionsModel.validateApplicationState());
        assertEquals(3, instructionsModel.getNumberOptions());
        assertEquals("Option1", instructionsModel.getOption(0));
        assertEquals("Option2", instructionsModel.getOption(1));
        assertEquals("Option3", instructionsModel.getOption(2));
    }


}

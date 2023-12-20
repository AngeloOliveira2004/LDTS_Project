package org.space.invaders.model.game.menu;

import org.junit.jupiter.api.Test;
import org.space.invaders.states.ApplicationState;
import static org.junit.jupiter.api.Assertions.*;

class SettingsModelTest {

    @Test
    void testDefaultConstructor() {
        SettingsModel settingsModel = new SettingsModel();
        assertEquals(null, settingsModel.validateApplicationState());
        assertEquals(3, settingsModel.getNumberOptions());
        assertEquals("Music Volume:", settingsModel.getOption(0));
        assertEquals("Difficulty:", settingsModel.getOption(1));
        assertEquals("Back to Main Menu", settingsModel.getOption(2));
        assertNotNull(settingsModel.getValuesMap());
        assertEquals(2, settingsModel.getValuesMap().size());
        assertEquals(Integer.valueOf(5), settingsModel.getValuesMap().get("Music Volume:"));
        assertEquals(Integer.valueOf(3), settingsModel.getValuesMap().get("Difficulty:"));
    }

    @Test
    void testLowerValueMap() {
        SettingsModel settingsModel = new SettingsModel();
        settingsModel.LowerValueMap("Music Volume:");
        assertEquals(Integer.valueOf(4), settingsModel.getValuesMap().get("Music Volume:"));
        settingsModel.LowerValueMap("Difficulty:");
        assertEquals(Integer.valueOf(2), settingsModel.getValuesMap().get("Difficulty:"));
    }

    @Test
    void testUpperValueMap() {
        SettingsModel settingsModel = new SettingsModel();
        settingsModel.UpperValueMap("Music Volume:");
        assertEquals(Integer.valueOf(5), settingsModel.getValuesMap().get("Music Volume:"));
        settingsModel.UpperValueMap("Difficulty:");
        assertEquals(Integer.valueOf(4), settingsModel.getValuesMap().get("Difficulty:"));
    }
}

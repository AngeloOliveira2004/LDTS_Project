package org.space.invaders.model.game.menu;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.space.invaders.states.ApplicationState;

import java.io.*;
import java.util.Map;

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
/*
    @Test
    public void testSaveHashMapToFile() {
        SettingsModel settingsModel = new SettingsModel();

        Map<String, Integer> valuesMap = settingsModel.getValuesMap();

        String fileName = "test_sound.txt";

        settingsModel.saveHashMapToFile(valuesMap, fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String[] keyValue = line.split(",");
                if (keyValue.length == 2) {
                    String key = keyValue[0].trim();
                    int intValue = Integer.parseInt(keyValue[1].trim());
                    assertEquals(valuesMap.get(key), intValue, "Mismatch in value at line " + lineNumber);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
*/
}

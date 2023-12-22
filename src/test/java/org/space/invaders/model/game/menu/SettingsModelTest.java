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
        int expected = getSoundVolume();
        int expected2 = getDifficulty();
        assertEquals(expected, settingsModel.getValuesMap().get("Music Volume:"));
        assertEquals(expected2, settingsModel.getValuesMap().get("Difficulty:"));
    }

    @Test
    void testLowerValueMap() {
        SettingsModel settingsModel = new SettingsModel();
        settingsModel.LowerValueMap("Music Volume:");
        int expected = getSoundVolume();
        if (expected == 0) expected = 1;
        assertEquals(expected-1, settingsModel.getValuesMap().get("Music Volume:"));
        settingsModel.LowerValueMap("Difficulty:");
        int expected1 = getDifficulty();
        if(expected1 == 0) expected1 = 1;
        assertEquals(expected1-1, settingsModel.getValuesMap().get("Difficulty:"));
    }

    @Test
    void testUpperValueMap() {
        SettingsModel settingsModel = new SettingsModel();
        settingsModel.UpperValueMap("Music Volume:");
        int expected = getSoundVolume();
        if(expected == 5)
            expected = 4;
        assertEquals(expected + 1, settingsModel.getValuesMap().get("Music Volume:"));
        settingsModel.UpperValueMap("Difficulty:");
        int expected2 = getDifficulty();
        if(expected2 == 5) expected2 = 4 ;
        assertEquals(expected2+1, settingsModel.getValuesMap().get("Difficulty:"));
    }

    private int getDifficulty()
    {
        String fileName = "sound.txt";
        String filePath = System.getProperty("user.dir") + "/src/main/Resources/" + fileName;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Difficulty:")) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        return Integer.parseInt(parts[1].trim());
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return 1;
    }

    private int getSoundVolume()
    {
        String fileName = "sound.txt";
        String filePath = System.getProperty("user.dir") + "/src/main/Resources/" + fileName;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Music Volume:")) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        return Integer.parseInt(parts[1].trim());
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return 1;
    }
}

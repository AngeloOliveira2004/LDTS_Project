package org.space.invaders.model.game.menu;
import org.space.invaders.states.ApplicationState;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingsModel extends Menu {
    List<ApplicationState> appvalue = new ArrayList<>();

    Map<String, Integer> valuesMap = new HashMap<>();
    public SettingsModel(){
        super(new ArrayList<>());
        addMenuOptions("Music Volume:");
        addMenuOptions("Difficulty:");
        addMenuOptions("Back to Main Menu");
        appvalue.add(null);
        appvalue.add(null);
        appvalue.add(ApplicationState.MainMenu);
        valuesMap.put("Music Volume:",5);
        valuesMap.put("Difficulty:",3);
        readValuesFromFile(valuesMap, "sound.txt");

    }

    public void LowerValueMap(String keyString){
        if(valuesMap.get(keyString) > 0) {
            valuesMap.replace(keyString, valuesMap.get(keyString) - 1);
        }
    }

    public void UpperValueMap(String keyString){
        if(valuesMap.get(keyString) < 5) {
            valuesMap.replace(keyString, valuesMap.get(keyString) + 1);
        }
    }

    public void saveHashMapToFile(Map<String, Integer> hashMap, String fileName) {
        fileName = "sound.txt";

        String filePath = System.getProperty("user.dir") + "/src/main/Resources/" + fileName;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readValuesFromFile(Map<String, Integer> hashMap, String fileName) {
        fileName = "sound.txt";

        String filePath = System.getProperty("user.dir") + "/src/main/Resources/" + fileName;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(",");
                if (keyValue.length == 2) {
                    String key = keyValue[0].trim();
                    int intValue = Integer.parseInt(keyValue[1].trim());
                    hashMap.replace(key, intValue);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }


    public SettingsModel(List<String> menuOptions) {
        super(menuOptions);
    }
    @Override
    public ApplicationState validateApplicationState() {
        return appvalue.get(getOptionIndex());
    }

    public Map<String, Integer> getValuesMap(){
        return valuesMap;
    }
}

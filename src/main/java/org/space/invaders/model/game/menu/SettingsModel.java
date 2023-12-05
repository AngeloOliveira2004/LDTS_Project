package org.space.invaders.model.game.menu;

import org.space.invaders.model.Model;
import org.space.invaders.states.ApplicationState;

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
        addMenuOptions("Effects Volume:");
        addMenuOptions("Difficulty:");
        addMenuOptions("Back to Main Menu");
        appvalue.add(null);
        appvalue.add(null);
        appvalue.add(null);
        appvalue.add(ApplicationState.MainMenu);
        valuesMap.put("Music Volume:",5);
        valuesMap.put("Effects Volume:",5);
        valuesMap.put("Difficulty:",3);

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

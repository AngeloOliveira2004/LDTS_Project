package org.space.invaders.model.game.menu;

import org.space.invaders.model.Model;
import org.space.invaders.states.ApplicationState;

import java.util.ArrayList;
import java.util.List;

public class SettingsModel extends Menu {
    List<ApplicationState> appvalue = new ArrayList<>();
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
    }

    public SettingsModel(List<String> menuOptions) {
        super(menuOptions);
    }
    @Override
    public ApplicationState validateApplicationState() {
        return appvalue.get(getOptionIndex());
    }
}

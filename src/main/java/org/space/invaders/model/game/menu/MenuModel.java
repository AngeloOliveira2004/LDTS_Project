package org.space.invaders.model.game.menu;

import org.space.invaders.states.ApplicationState;

import java.util.ArrayList;
import java.util.List;

public class MenuModel extends Menu{
    List<ApplicationState> appvalue = new ArrayList<>();

    public MenuModel() {
        super(new ArrayList<>());
        addMenuOptions("New Game");
        addMenuOptions("Instructions");
        addMenuOptions("Settings");
        addMenuOptions("Leaderboard");
        addMenuOptions("Exit");
        appvalue.add(ApplicationState.Game);
        appvalue.add(ApplicationState.MenuInstructions);
        appvalue.add(ApplicationState.MenuSettings);
        appvalue.add(ApplicationState.MenuLeaderboard);
        appvalue.add(ApplicationState.ExitMenu);
    }
    @Override
    public ApplicationState validateApplicationState() {
        return appvalue.get(getOptionIndex());
    }
}

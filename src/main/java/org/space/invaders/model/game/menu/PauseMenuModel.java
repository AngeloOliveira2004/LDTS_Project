
package org.space.invaders.model.game.menu;

import org.space.invaders.states.ApplicationState;

import java.util.ArrayList;
import java.util.List;

public class PauseMenuModel extends Menu{
    List<ApplicationState> appvalue = new ArrayList<>();
    public PauseMenuModel() {
        super(new ArrayList<>());
        addMenuOptions("Back to Game");
        addMenuOptions("Back to Menu");
        appvalue.add(ApplicationState.Game);
        appvalue.add(ApplicationState.MainMenu);
    }

    @Override
    public ApplicationState validateApplicationState() {
        return appvalue.get(getOptionIndex());
    }
}

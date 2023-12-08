package org.space.invaders.model.game.menu;

import org.space.invaders.states.ApplicationState;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardModel extends Menu {
    public LeaderboardModel() {
        super(new ArrayList<>());
        addMenuOptions("Back to Menu");
    }

    public LeaderboardModel(List<String> menuOptions) {
        super(menuOptions);
    }

    @Override
    public ApplicationState validateApplicationState() {
        return ApplicationState.MainMenu;
    }
}

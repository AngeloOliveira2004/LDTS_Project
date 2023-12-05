package org.space.invaders.model.game.menu;

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
}

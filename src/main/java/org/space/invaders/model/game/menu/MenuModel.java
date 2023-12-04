package org.space.invaders.model.game.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuModel extends Menu{

    public MenuModel() {
        super(new ArrayList<>());
        addMenuOptions("New Game");
        addMenuOptions("Instructions");
        addMenuOptions("Settings");
        addMenuOptions("Leaderboard");
        addMenuOptions("Exit");
    }

    public MenuModel(List<String> menuOptions) {
        super(menuOptions);
    }
}

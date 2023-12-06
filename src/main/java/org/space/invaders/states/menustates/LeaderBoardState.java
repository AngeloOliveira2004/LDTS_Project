package org.space.invaders.states.menustates;

import org.space.invaders.control.MenuController;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.LeaderboardModel;
import org.space.invaders.model.game.menu.MenuModel;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.State;
import org.space.invaders.view.menu.LeaderboardView;
import org.space.invaders.view.menu.MenuView;

import java.io.IOException;

public class LeaderBoardState implements State {

    private final LeaderboardView menuView;
    MenuGUI gui;
    private MenuController menuController;

    private final LeaderboardModel menuModel;

    public LeaderBoardState(MenuController menuController,MenuGUI gui) {
        this.gui = gui;
        this.menuModel = new LeaderboardModel();
        this.menuView = new LeaderboardView(menuModel, this.gui.getScreen());
        this.menuController = menuController;
    }

    @Override
    public void step() {
        MenuGUI.ACTION action;
        try {
            action = gui.getNextAction();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(action != MenuGUI.ACTION.NONE){
            gui.clear();
            Action(action);
            menuView.drawElements(gui);
        }
    }

    public void Action(MenuGUI.ACTION action) {
        if(action != null) {
            switch (action) {
                case ENTER -> {
                    try {
                        menuController.setApplicationState(ApplicationState.MainMenu);
                        menuController.changeState(ApplicationState.MainMenu);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @Override
    public void startScreen() {
        menuView.drawElements(gui);
        gui.refresh();
    }

    @Override
    public boolean isRunning() {
        return true;
    }

    @Override
    public void run() throws IOException {
        while (menuController.getApplicationState() == ApplicationState.MenuLeaderboard)
        {
            menuView.drawElements(gui);
            gui.refresh();
            step();
        }
    }
}

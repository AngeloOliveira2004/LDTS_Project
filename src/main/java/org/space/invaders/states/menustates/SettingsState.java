package org.space.invaders.states.menustates;

import org.space.invaders.control.MenuController;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.LeaderboardModel;
import org.space.invaders.model.game.menu.SettingsModel;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.State;
import org.space.invaders.view.menu.LeaderboardView;
import org.space.invaders.view.menu.SettingsView;

import java.io.IOException;

public class SettingsState implements State {

    private final SettingsView menuView;
    MenuGUI gui;
    private MenuController menuController;

    private final SettingsModel menuModel;

    public SettingsState(MenuController menuController,MenuGUI gui) {
        this.menuController = menuController;
        this.gui = gui;
        this.menuModel = new SettingsModel();
        this.menuView = new SettingsView(menuModel,this.gui.getScreen());
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
                case UP -> menuModel.previousOption();
                case DOWN -> menuModel.nextOption();
                case ENTER -> {
                    if(menuModel.validateApplicationState() != null) {
                        try {
                            menuModel.saveHashMapToFile(menuModel.getValuesMap(),"sound.txt");
                            ApplicationState applicationState = menuModel.validateApplicationState();
                            menuController.setApplicationState(applicationState);
                            menuController.changeState(applicationState);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                case LEFT -> {
                        if(menuModel.validateApplicationState() == null) {
                            menuModel.LowerValueMap(menuModel.getCurrentOption());
                        }
                }
                case RIGHT -> {
                        if(menuModel.validateApplicationState() == null){
                            menuModel.UpperValueMap(menuModel.getCurrentOption());
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

    public void run() throws IOException {
        while (menuController.getApplicationState() == ApplicationState.MenuSettings)
        {
            menuView.drawElements(gui);
            gui.refresh();
            step();
        }
    }
}

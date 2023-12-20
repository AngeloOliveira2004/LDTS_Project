package org.space.invaders.states.menustates;

import org.space.invaders.control.MenuController;
import org.space.invaders.gui.Menu;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.MenuModel;
import org.space.invaders.model.game.menu.PauseMenuModel;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.State;
import org.space.invaders.view.menu.MenuViewer;
import org.space.invaders.view.menu.MenuView;
import org.space.invaders.view.menu.PauseMenuView;

import java.io.IOException;

public class MenuState implements State {
    private MenuView menuView;
    MenuGUI gui;
    private MenuController menuController;
    private  MenuModel menuModel;

    public MenuState(MenuController menuController,MenuGUI gui) {

        this.gui = gui;
        this.menuModel = new MenuModel();
        this.menuView = new MenuView(menuModel, this.gui.getScreen());
        this.menuController = menuController;
    }


    public MenuModel getModel() {
        return menuModel;
    }

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
        }
    }
    public void Action(MenuGUI.ACTION action) {
        if(action != null) {
            switch (action) {
                case UP -> getModel().previousOption();
                case DOWN -> getModel().nextOption();
                case ENTER -> {
                    ApplicationState applicationState = getModel().validateApplicationState();
                    menuController.setApplicationState(applicationState);
                    try {
                        menuController.changeState(applicationState);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    public void run() throws IOException {
        while (menuController.getApplicationState() == ApplicationState.MainMenu)
        {
            menuView.drawElements(gui);
            gui.refresh();
            step();
        }

    }

    @Override
    public void close() throws IOException {
        menuView.close();
    }

    public void startScreen() {
        menuView.drawElements(gui);
        gui.refresh();
    }

    public boolean isRunning() {
        return true;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public MenuGUI getGui() {
        return gui;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }
    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setGui(MenuGUI menuGui) {
        this.gui = menuGui;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }
}

package org.space.invaders.states.menustates;

import org.space.invaders.control.MenuController;
import org.space.invaders.gui.GUI;
import org.space.invaders.gui.Menu;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.MenuModel;
import org.space.invaders.model.game.menu.PauseMenuModel;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.State;
import org.space.invaders.view.menu.PauseMenuView;

import java.io.IOException;

public class PauseMenuState implements State {
    private final PauseMenuView pauseMenuVIew;
    MenuGUI gui;
    private MenuController menuController;
    private final PauseMenuModel pauseMenuModel;

    public PauseMenuState(MenuController menuController) throws Exception {
        this.gui = constructGUI();
        this.pauseMenuModel = new PauseMenuModel();
        this.menuController = menuController;
        this.pauseMenuVIew = new PauseMenuView(pauseMenuModel, this.gui.getScreen());
    }
    public Menu constructGUI() throws Exception {
        return new Menu(30,30);
    }
    public PauseMenuModel getModel() {
        return pauseMenuModel;
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
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @Override
    public void startScreen() {
        pauseMenuVIew.drawElements(gui);
        gui.refresh();
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void run() throws IOException {
        while (menuController.getApplicationState() == ApplicationState.PauseMenu)
        {
            pauseMenuVIew.drawElements(gui);
            gui.refresh();
            step();
        }
    }

    @Override
    public void close() throws IOException {
        pauseMenuVIew.close();
    }
}

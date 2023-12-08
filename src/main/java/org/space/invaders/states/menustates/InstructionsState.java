package org.space.invaders.states.menustates;

import org.space.invaders.control.MenuController;
import org.space.invaders.gui.Menu;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.InstructionsModel;
import org.space.invaders.model.game.menu.MenuModel;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.State;
import org.space.invaders.view.menu.InstructionsView;
import org.space.invaders.view.menu.MenuView;
import org.space.invaders.view.menu.MenuViewer;

import java.io.IOException;

public class InstructionsState implements State {

    private final InstructionsView menuView;
    MenuGUI gui;
    private MenuController menuController;

    private final InstructionsModel menuModel;

    public InstructionsState(MenuController menuController, MenuGUI gui) {
        this.gui = gui;
        this.menuModel = new InstructionsModel();
        this.menuView = new InstructionsView(menuModel, this.gui.getScreen());
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
        while (menuController.getApplicationState() == ApplicationState.MenuInstructions)
        {
            menuView.drawElements(gui);
            gui.refresh();
            step();
        }

    }

    @Override
    public void close() throws IOException {

    }
}

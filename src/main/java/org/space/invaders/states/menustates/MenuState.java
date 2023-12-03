package org.space.invaders.states.menustates;

import org.space.invaders.control.MenuController;
import org.space.invaders.control.menu.MainMenuController;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.MenuModel;
import org.space.invaders.states.State;
import org.space.invaders.view.Viewer;
import org.space.invaders.view.menu.MenuView;

import java.io.IOException;

public class MenuState extends State<MenuModel> {
    private MenuView menuView;

    MenuGUI gui;
    private final MainMenuController mainMenuController;

    private final MenuModel menuModel;


    public MenuState(MenuModel menuModel, MenuGUI gui) {
        super(menuModel);
        try {
            this.gui = gui;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.menuView = new MenuView(menuModel, this.gui.getScreen());
        this.menuModel = menuModel;
        this.mainMenuController = new MainMenuController(menuModel);
    }

    @Override
    public Viewer getViewer() {
        return menuView;
    }

    @Override
    public MenuController getController() {
        return mainMenuController;
    }

    @Override
    public MenuModel getModel() {
        return menuModel;
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
            mainMenuController.step(null, action);
            menuView.drawElements(gui);
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
    public State nextState() {
        //Mudar depois de aplicar próximos states;
        return null;
    }
}

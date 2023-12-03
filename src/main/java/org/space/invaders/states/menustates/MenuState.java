package org.space.invaders.states.menustates;

import org.space.invaders.control.Controller;
import org.space.invaders.control.menu.MenuController;
import org.space.invaders.gui.GUI;
import org.space.invaders.gui.LanternaGUI;
import org.space.invaders.model.game.menu.MenuModel;
import org.space.invaders.states.State;
import org.space.invaders.view.Viewer;
import org.space.invaders.view.menu.MenuView;

import java.io.IOException;

public class MenuState extends State<MenuModel> {
    private MenuView menuView;

    LanternaGUI gui;
    private final MenuController menuController;

    private final MenuModel menuModel;


    public MenuState(MenuView menuView, MenuModel menuModel) {
        super();
        try {
            this.gui = new LanternaGUI(50,50);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.menuView = menuView;
        this.menuModel = menuModel;
        this.menuController = new MenuController(menuModel);
    }

    @Override
    public Viewer getViewer() {
        return menuView;
    }

    @Override
    public Controller getController() {
        return menuController;
    }

    @Override
    public MenuModel getModel() {
        return menuModel;
    }

    @Override
    public void step() {
        GUI.ACTION action;
        try {
            action = gui.getNextAction();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        menuController.step(null, action);

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

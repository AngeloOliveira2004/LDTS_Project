package org.space.invaders.states.menustates;

import org.space.invaders.control.MenuController;
import org.space.invaders.gui.Menu;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.MenuModel;
import org.space.invaders.view.menu.MenuView;
import org.space.invaders.view.menu.MenuViewer;

public class InstructionsState {

    private final MenuView menuView;
    MenuGUI gui;
    private MenuController menuController;

    private final MenuModel menuModel;

    public InstructionsState(MenuController menuController, MenuGUI gui) {
        this.gui = gui;
        this.menuModel = new MenuModel(); //Continuar implementação
        this.menuView = new MenuView(menuModel, this.gui.getScreen()); //Continuar implementação
        this.menuController = menuController;
    }

    public MenuViewer getViewer() {
        return menuView;
    }

    public MenuController getController() {
        return menuController;
    }

    public MenuModel getModel() {
        return menuModel;
    }
}

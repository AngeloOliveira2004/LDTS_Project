package org.space.invaders.control.menu;

import org.space.invaders.Game;
import org.space.invaders.control.MenuController;
import org.space.invaders.gui.GUI;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.MenuModel;

public class MainMenuController extends MenuController<MenuModel> {

    public MainMenuController(MenuModel menuModel) {
        super(menuModel);
    }

    @Override
    public void step(Game game, MenuGUI.ACTION action) {
        if(action != null) {
            switch (action) {
                case UP -> getModel().previousOption();
                case DOWN -> getModel().nextOption();
            }
        }
    }
}

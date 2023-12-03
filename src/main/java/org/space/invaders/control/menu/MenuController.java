package org.space.invaders.control.menu;

import org.space.invaders.Game;
import org.space.invaders.control.Controller;
import org.space.invaders.gui.GUI;
import org.space.invaders.model.game.menu.MenuModel;

public class MenuController extends Controller<MenuModel> {

    public MenuController(MenuModel menuModel) {
        super(menuModel);
    }

    @Override
    public void step(Game game, GUI.ACTION action) {
        switch(action) {
            case UP -> getModel().previousOption();
            case DOWN -> getModel().nextOption();
        }
    }
}

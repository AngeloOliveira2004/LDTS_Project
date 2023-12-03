package org.space.invaders;

import org.space.invaders.control.menu.MainMenuController;
import org.space.invaders.gui.Menu;
import org.space.invaders.model.game.menu.MenuModel;

public class Main {
    public static void main(String[] args) throws Exception {
        // TestClass testClass = new TestClass(200 , 100);
        MenuModel menuModel = new MenuModel();

        Menu gui = new Menu(50,25);
        MainMenuController controller = new MainMenuController(menuModel);
        controller.run(gui);
    }
}
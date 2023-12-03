package org.space.invaders;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import org.space.invaders.control.Controller;
import org.space.invaders.control.menu.MenuController;
import org.space.invaders.gui.GUI;
import org.space.invaders.gui.LanternaGUI;
import org.space.invaders.model.Model;
import org.space.invaders.model.game.menu.Menu;
import org.space.invaders.model.game.menu.MenuModel;
import org.space.invaders.view.menu.MenuView;

public class Main {
    public static void main(String[] args) throws Exception {
        // TestClass testClass = new TestClass(200 , 100);
        MenuModel menuModel = new MenuModel();

        LanternaGUI gui = new LanternaGUI(50,25);
        MenuController controller = new MenuController(menuModel);
        controller.run(gui);
    }
}
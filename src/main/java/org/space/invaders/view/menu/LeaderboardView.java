package org.space.invaders.view.menu;

import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.menu.MenuModel;

public class LeaderboardView extends MenuView {
    public LeaderboardView(MenuModel model, Screen screen) {
        super(model, screen);
    }

    public void drawElements(MenuGUI gui) {
        MenuModel menu = (MenuModel) getModel();
        gui.drawText(new Position(15,8),"I N S T R U C T I O N S","#008000","BLINK");
        String isSelected = menu.getCurrentOption();

        for (int i = 0; i < menu.getNumberOptions(); i++) {

            if (isSelected.equals(menu.getOption(i))) {
                gui.drawSelectedText(new Position(22, 10 + i * 2), menu.getOption(i), "#008000", "BLINK");
            } else {
                gui.drawText(new Position(22, 10 + i * 2), menu.getOption(i), "#008000", "BOLD");
            }
            menu.setCurrentOption();
        }

        gui.refresh();
    }
}

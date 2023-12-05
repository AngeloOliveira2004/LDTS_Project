package org.space.invaders.view.menu;

import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.menu.LeaderboardModel;
import org.space.invaders.model.game.menu.MenuModel;
import org.space.invaders.model.game.menu.SettingsModel;

public class SettingsView extends MenuViewer {

    public SettingsView(SettingsModel model, Screen screen) {
        super(model, screen);

    }
    @Override
    public void drawElements(MenuGUI gui) {
        SettingsModel menu = (SettingsModel) getModel();
        gui.drawText(new Position(16,3),"S E T T I N G S","#008000","BLINK");

        String isSelected = menu.getCurrentOption();

        for (int i = 0; i < menu.getNumberOptions(); i++) {

            if (isSelected.equals(menu.getOption(i))) {
                gui.drawSelectedText(new Position(12, 7 + i * 2), menu.getOption(i), "#008000", "BLINK");
            } else {
                gui.drawText(new Position(12, 7 + i * 2), menu.getOption(i), "#008000", "BOLD");
            }
            menu.setCurrentOption();
        }
        gui.refresh();
    }
}

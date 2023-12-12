
package org.space.invaders.view.menu;

import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.menu.PauseMenuModel;

import java.io.IOException;

public class PauseMenuView extends MenuViewer{

    public PauseMenuView(PauseMenuModel model, Screen screen) {
        super(model, screen);
    }

    @Override
    public void drawElements(MenuGUI gui) {
        PauseMenuModel pauseMenuModel = (PauseMenuModel) getModel();
        gui.drawText(new Position(14,3),"G A M E  P A U S E D","#008000","BLINK");
        String isSelected = pauseMenuModel.getCurrentOption();

        for (int i = 0; i < pauseMenuModel.getNumberOptions(); i++) {

            if (isSelected.equals(pauseMenuModel.getOption(i))) {
                gui.drawSelectedText(new Position(20, 8 + i * 2), pauseMenuModel.getOption(i), "#008000", "BLINK");
            } else {
                gui.drawText(new Position(20, 8 + i * 2), pauseMenuModel.getOption(i), "#008000", "BOLD");
            }
            pauseMenuModel.setCurrentOption();
        }

        gui.refresh();
    }

    public void close() throws IOException {
        screen.close();
    }
}

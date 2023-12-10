
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
        gui.drawText(new Position(14,3),"W o r l d  T h r u s t e r","#008000","BLINK");
        String isSelected = pauseMenuModel.getCurrentOption();


    }

    public void close() throws IOException {
        screen.close();
    }
}

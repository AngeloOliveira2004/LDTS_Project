package org.space.invaders.view.menu;

import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.menu.GameOverModel;
import org.space.invaders.model.game.menu.InstructionsModel;

public class GameOverVIew extends MenuViewer{

    public GameOverVIew(GameOverModel model, Screen screen) {
        super(model, screen);
    }

    @Override
    public void drawElements(MenuGUI gui) {
        GameOverModel menu = (GameOverModel) getModel();
        gui.drawText(new Position(14,3),"G A M E O V E R :)","#008000","BLINK");

        gui.drawSelectedText(new Position(20, 5), menu.getOption(0), "#008000", "BLINK");

        gui.drawText(new Position(10,7),"PRESS ENTER TO RETURN TO MENU","#008000","BOLD");
    }
}

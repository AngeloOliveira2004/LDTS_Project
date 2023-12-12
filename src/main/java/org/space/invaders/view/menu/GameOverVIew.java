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
        gui.drawText(new Position(14,6),"INSERT YOUR ACRONYM","#008000","BLINK");

        int currentIndex = menu.getCurrentIndex();

        for(int i = 0; i < menu.getAcronym().length;i++){
            if(currentIndex == i){
                gui.drawSelectedText(new Position(22 + i,12), menu.getAcronymValue(menu.getAcronym()[i]), "#008000", "BOLD");
            }else{
                gui.drawText(new Position(22 + i,12), menu.getAcronymValue(menu.getAcronym()[i]), "#008000","BOLD");
            }
        }
        gui.drawText(new Position(9,8),"PRESS ENTER TO SAVE YOUR SCORE","#008000","BOLD");
        gui.drawText(new Position(14,9),"AND GO BACK TO MENU","#008000","BOLD");
    }
}

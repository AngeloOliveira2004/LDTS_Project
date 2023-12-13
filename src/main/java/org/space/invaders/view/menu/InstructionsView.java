package org.space.invaders.view.menu;

import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.menu.InstructionsModel;

public class InstructionsView extends MenuViewer{


    public InstructionsView(InstructionsModel model, Screen screen) {
        super(model, screen);
    }
    @Override
    public void drawElements(MenuGUI gui) {
        InstructionsModel menu = (InstructionsModel) getModel();
        gui.drawText(new Position(14,3),"I N S T R U C T I O N S","#008000","BLINK");

        gui.drawSelectedText(new Position(20, 5), menu.getOption(0), "#008000", "BLINK");

        gui.drawText(new Position(10,7),"ARROW KEYS: Move your Spaceship","#008000","BOLD");
        gui.drawText(new Position(10,9),"SHIFT: Morph into Mini Spaceship","#008000","BOLD");
        gui.drawText(new Position(10,11),"SPACE: Normal Shot","#008000","BOLD");
        gui.drawText(new Position(12,16),"Your only motto should be:","#008000","BOLD");
        gui.drawText(new Position(10,17),"Defend the earth or die trying","#008000","BOLD");
        gui.drawText(new Position(17,19),"Good luck pilot","#008000","BOLD");
        gui.drawText(new Position(15,20),"The Planet needs you","#008000","BOLD");
    }
}

package org.space.invaders.view.menu;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import org.space.invaders.gui.GUI;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.menu.MenuModel;
import org.space.invaders.view.Viewer;
import org.w3c.dom.Text;

import java.awt.*;
import java.io.IOException;

public class MenuView extends Viewer{

    public MenuView(MenuModel model, Screen screen) {
        super(model, screen);

    }

    public void drawElements(MenuGUI gui) {
        MenuModel menu = (MenuModel) getModel();
        gui.drawText(new Position(15,8),"W o r l d  T h r u s t e r","#008000","BLINK");
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

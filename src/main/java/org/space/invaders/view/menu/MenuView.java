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
import org.space.invaders.model.Position;
import org.space.invaders.model.game.menu.MenuModel;
import org.space.invaders.view.Viewer;
import org.w3c.dom.Text;

import java.awt.*;
import java.io.IOException;

public class MenuView extends Viewer{

    public MenuView(Object model, Screen screen) {
        super(model, screen);

    }
    /*
    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(22,10),"W o r l d  T h r u s t e r","#008000","BLINK");
        // gui.drawText(new Position(30, 12), "New Game", "#008000","BOLD");
        // gui.drawText(new Position(30, 14), "LEADERBOARD", "#008000","BOLD");
        // gui.drawText(new Position(55,29), "Insert a Coin:","#008000","BLINK");
        gui.refresh();
    }
     */
    protected void drawElements(GUI gui) {
        MenuModel menu = new MenuModel();

        for (int i = 0; i < menu.getNumberOptions(); i++) {
            boolean isSelected = menu.isSelected(menu.getCurrentOption());

            if (isSelected) {
                gui.setBackgroundHighlightColor("#FFFFFF"); // Use the color you want
            } else {
                gui.setBackgroundHighlightColor("#000000"); // Use the default color or another color
            }

            gui.drawText(new Position(22, 10 + i * 2), menu.getOption(i), "#008000", "BLINK");
        }

        gui.refresh();
    }
}

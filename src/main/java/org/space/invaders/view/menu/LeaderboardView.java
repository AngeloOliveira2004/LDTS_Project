package org.space.invaders.view.menu;

import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.menu.LeaderboardModel;
import org.space.invaders.model.game.menu.MenuModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeaderboardView extends MenuViewer {
    public LeaderboardView(LeaderboardModel model, Screen screen) {
        super(model, screen);
    }

    public void drawElements(MenuGUI gui) {
        LeaderboardModel menu = (LeaderboardModel) getModel();
        gui.drawText(new Position(15,3),"L E A D E R B O A R D","#008000","BLINK");

        gui.drawSelectedText(new Position(20, 5), menu.getOption(0), "#008000", "BLINK");

        gui.refresh();

        drawLeaderboard(gui);
    }

    public void drawLeaderboard(MenuGUI gui) {
        String filePath = "/home/angelo/Downloads/Universidade/LDTS/project-l07gr02/src/main/Resources/Leaderboard.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 1;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                gui.drawText(new Position(14, 5 + i * 2),parts[0]+ ". " + parts[1] + " Score: " + parts[2]  , "#008000", "BOLD");
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
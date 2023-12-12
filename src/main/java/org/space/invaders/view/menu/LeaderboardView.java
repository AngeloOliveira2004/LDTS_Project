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
import java.util.ArrayList;
import java.util.List;

public class LeaderboardView extends MenuViewer {
    public LeaderboardView(LeaderboardModel model, Screen screen) {
        super(model, screen);
    }

    public void drawElements(MenuGUI gui) {
        LeaderboardModel menu = (LeaderboardModel) getModel();
        gui.drawText(new Position(16,3),"L E A D E R B O A R D","#008000","BLINK");

        gui.drawSelectedText(new Position(20, 5), menu.getOption(0), "#008000", "BLINK");

        drawLeaderboard(gui);
    }

    public void drawLeaderboard(MenuGUI gui) {
        String filePath = String.format("%s/%s", System.getProperty("user.dir"), "/src/main/Resources/Leaderboard.txt");

        List<String[]> entries = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 2) {
                    continue;
                }

                try {
                    int score = Integer.parseInt(parts[0]);
                    String name = parts[1].trim();
                    entries.add(new String[]{String.valueOf(score), name});
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        entries.sort((entry1, entry2) -> Integer.compare(Integer.parseInt(entry2[0]), Integer.parseInt(entry1[0])));

        int maxEntries = Math.min(5, entries.size());
        for (int i = 0; i < maxEntries; i++) {
            String[] entry = entries.get(i);
            gui.drawText(new Position(16, 8 + i * 2), (i + 1) + ". " + entry[1] + " Score: " + entry[0], "#008000", "BOLD");
        }
    }

}
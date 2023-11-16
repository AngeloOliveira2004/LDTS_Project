package org.space.invaders.spaceInvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stars extends Position{
    private List<Position> starPositions;  // List to store star positions
    public Stars(int x, int y) {
        super(x, y);
        starPositions = new ArrayList<>();

        // Initialize star positions (for example, by generating random positions)
        Random random = new Random();
        while (starPositions.size() < 50) {
            int randomX, randomY;

            // Divide the screen into four quadrants
            int quadrant = random.nextInt(4);

            // Determine the region based on the quadrant
            if (quadrant == 0) {
                randomX = random.nextInt(y);
                randomY = random.nextInt(x / 2);
            } else if (quadrant == 1) {
                randomX = random.nextInt(x / 2) + x / 2;
                randomY = random.nextInt(y / 2);
            } else if (quadrant == 2) {
                randomX = random.nextInt(x);
                randomY = random.nextInt(y / 2) + y / 2;
            } else {
                randomX = random.nextInt(x / 2) + x / 2;
                randomY = random.nextInt(y / 2) + y / 2;
            }

            // Add the star position
            starPositions.add(new StarPosition(randomX, randomY));
        }

    }

    public void draw(TextGraphics screen) {
        for (Position starPosition : starPositions) {
            // Draw stars at their respective positions
            int x = starPosition.getX();
            int y = starPosition.getY();
            TextCharacter character = new TextCharacter('*');
            character = character.withBackgroundColor(TextColor.ANSI.BLACK);
            character = character.withForegroundColor(TextColor.ANSI.YELLOW);
            screen.setCharacter(x, y, character);
        }
    }

    private static class StarPosition extends Position {
        public StarPosition(int x, int y) {
            super(x, y);
        }
    }
}

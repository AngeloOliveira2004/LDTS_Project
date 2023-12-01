package org.space.invaders.model.game.map;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.Dimensions;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stars extends Position implements Dimensions {
    private static final int NUM_STARS = 50;

    private final List<Stars.StarPosition> starPositions;

    public static class StarPosition extends Position {
        public StarPosition(int x, int y) {
            super(x, y);
        }
    }
    public Stars(int x, int y) {
        super(x, y);
        starPositions = generateRandomStarPositions();
    }

    public Stars()
    {
        super(0, 0);
        starPositions = new ArrayList<>();
    }

    private List<Stars.StarPosition> generateRandomStarPositions() {
        List<Stars.StarPosition> positions = new ArrayList<>();
        Random random = new Random();

        int starsPerQuadrant = NUM_STARS / 4;
        int remainingStars = NUM_STARS;

        for (int quadrant = 0; quadrant < 4; quadrant++) {
            int quadrantStars = (quadrant < 2) ? starsPerQuadrant + 1 : starsPerQuadrant;

            for (int i = 0; i < quadrantStars; i++) {
                int randomX, randomY;

                if (quadrant == 0) {
                    randomX = random.nextInt(Dimensions.screenWidth / 2);
                    randomY = random.nextInt(Dimensions.screenHeight);
                } else if (quadrant == 1) {
                    randomX = random.nextInt(Dimensions.screenWidth / 2) + Dimensions.screenWidth / 2;
                    randomY = random.nextInt(Dimensions.screenHeight / 2);
                } else if (quadrant == 2) {
                    randomX = random.nextInt(Dimensions.screenWidth);
                    randomY = random.nextInt(Dimensions.screenHeight / 2) + Dimensions.screenHeight / 2;
                } else {
                    randomX = random.nextInt(Dimensions.screenWidth / 2) + Dimensions.screenWidth / 2;
                    randomY = random.nextInt(Dimensions.screenHeight / 2) + Dimensions.screenHeight / 2;
                }
                positions.add(new Stars.StarPosition(randomX, randomY));
                remainingStars--;
            }
        }

        for (int i = 0; i < remainingStars; i++) {
            int randomX = random.nextInt(Dimensions.screenWidth);
            int randomY = random.nextInt(Dimensions.screenHeight);
            positions.add(new Stars.StarPosition(randomX, randomY));
        }

        return positions;
    }

    public void draw(TextGraphics screen) {
        TextCharacter character = new TextCharacter('*');
        character = character.withBackgroundColor(TextColor.ANSI.BLACK);
        character = character.withForegroundColor(TextColor.ANSI.WHITE);
        for (Stars.StarPosition starPosition : starPositions) {
            int x = starPosition.getX();
            int y = starPosition.getY();

            screen.setCharacter(x, y, character);
        }
    }
    public List<StarPosition> getStarPosition() {
        return starPositions;
    }
}
package org.space.invaders.model.game.map;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.Constants;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.Dimensions;
import org.space.invaders.view.game.StarsView;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stars extends Position implements Dimensions {
    private static final int NUM_STARS = 150;
    public static final double STAR_SPEED = 1;
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
        starPositions = generateRandomStarPositions();
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
                    randomX = random.nextInt(Constants.WIDTH/ 2);
                    randomY = random.nextInt(Constants.HEIGHT);
                } else if (quadrant == 1) {
                    randomX = random.nextInt(Constants.WIDTH / 2) + Constants.WIDTH / 2;
                    randomY = random.nextInt(Constants.HEIGHT / 2);
                } else if (quadrant == 2) {
                    randomX = random.nextInt(Constants.WIDTH);
                    randomY = random.nextInt(Constants.HEIGHT / 2) + Constants.HEIGHT / 2;
                } else {
                    randomX = random.nextInt(Constants.WIDTH / 2) + Constants.WIDTH / 2;
                    randomY = random.nextInt(Constants.HEIGHT / 2) + Constants.HEIGHT / 2;
                }
                positions.add(new Stars.StarPosition(randomX, randomY));
                remainingStars--;
            }
        }

        for (int i = 0; i < remainingStars; i++) {
            int randomX = random.nextInt(Constants.WIDTH);
            int randomY = random.nextInt(Constants.HEIGHT);
            positions.add(new Stars.StarPosition(randomX, randomY));
        }

        return positions;
    }

    public void draw(TextGraphics screen) {
        StarsView starsView = new StarsView(screen, this);
        starsView.draw();
        starsView.moveStars();
    }
    public List<Stars.StarPosition> getStarPosition() {
        return starPositions;
    }
}
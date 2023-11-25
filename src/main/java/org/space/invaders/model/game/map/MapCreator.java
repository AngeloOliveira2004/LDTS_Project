package org.space.invaders.model.game.map;

import org.space.invaders.model.game.Dimensions;

public class MapCreator {
    private final char[][] map1 = new char[Dimensions.screenHeight][Dimensions.screenWidth];
    public void generateBlankMap() {
        for (int i = 0; i < Dimensions.screenHeight; i++) {
            for (int j = 0; j < Dimensions.screenWidth; j++) {
                map1[i][j] = 'B';
            }
        }
    }

}
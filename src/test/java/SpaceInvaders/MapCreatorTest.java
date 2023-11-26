package SpaceInvaders;

import org.junit.jupiter.api.Test;
import org.space.invaders.model.game.Dimensions;
import org.space.invaders.model.game.map.MapCreator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MapCreatorTest{

    @Test
    void generateBlankMap() {
        MapCreator mapCreator = new MapCreator();
        char[][] result = new char[Dimensions.screenHeight][Dimensions.screenWidth];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                assertEquals('B', result[i][j]);
            }
        }
    }
}

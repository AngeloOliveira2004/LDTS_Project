package SpaceInvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.game.map.Stars;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.Dimensions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class StarsTest {
    @InjectMocks
    private Stars stars;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Stars stars = new Stars(0, 0);
    }
    @Test
    void testDraw() {
        TextGraphics mockTextGraphics = mock(TextGraphics.class);
        Stars stars = new Stars(0, 0);
        List<Stars.StarPosition> starPositions = stars.getStarPosition();

        stars.draw(mockTextGraphics);
        for (Stars.StarPosition starPosition : starPositions) {
            int x = starPosition.getX();
            int y = starPosition.getY();

            TextCharacter expectedCharacter = new TextCharacter('*').withBackgroundColor(TextColor.ANSI.BLACK).withForegroundColor(TextColor.ANSI.WHITE);

            verify(mockTextGraphics, times(1)).setCharacter(x, y, expectedCharacter);
        }
    }
}
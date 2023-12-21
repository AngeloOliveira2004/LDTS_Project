package org.space.invaders.view.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.game.map.Stars;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class StarsViewTest {

    @Mock
    private TextGraphics textGraphics;

    @Mock
    private Stars stars;
    private StarsView starsView;

    @Before
    public void setUp() {
        starsView = new StarsView(textGraphics, stars);
    }

    @Test
    public void testDrawMethod() {
        Stars.StarPosition starPosition1 = new Stars.StarPosition(10, 20);
        Stars.StarPosition starPosition2 = new Stars.StarPosition(15, 25);
        List<Stars.StarPosition> starPositions = Arrays.asList(starPosition1, starPosition2);

        when(stars.getStarPosition()).thenReturn(starPositions);

        starsView.draw();

        verify(textGraphics).setCharacter(10, 20, new TextCharacter('*')
                .withBackgroundColor(TextColor.ANSI.BLACK)
                .withForegroundColor(TextColor.ANSI.WHITE));
        verify(textGraphics).setCharacter(15, 25, new TextCharacter('*')
                .withBackgroundColor(TextColor.ANSI.BLACK)
                .withForegroundColor(TextColor.ANSI.WHITE));
    }

    @Test
    public void testMoveStarsMethod() {
        Stars.StarPosition starPosition1 = new Stars.StarPosition(10, 20);
        Stars.StarPosition starPosition2 = new Stars.StarPosition(15, 25);
        List<Stars.StarPosition> starPositions = Arrays.asList(starPosition1, starPosition2);

        when(stars.getStarPosition()).thenReturn(starPositions);

        starsView.moveStars();

        for (Stars.StarPosition starPosition : starPositions) {
            int expectedY = starPosition.getY() + 1;
            verify(textGraphics).setCharacter(starPosition.getX(), expectedY, new TextCharacter('*')
                    .withBackgroundColor(TextColor.ANSI.BLACK)
                    .withForegroundColor(TextColor.ANSI.WHITE));
        }
    }
}

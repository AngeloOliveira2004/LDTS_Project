package org.space.invaders.view.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.map.Stars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.*;

public class StarsViewTest {

    @Mock
    private TextGraphics textGraphics;
    @Mock
    private Stars stars;
    private StarsView starsView;

    @BeforeEach
    public void setUp() {
        stars = mock(Stars.class);
        textGraphics = mock(TextGraphics.class);
        starsView = new StarsView(textGraphics, stars);
    }

    @Test
    public void testDrawMethod() {
        List<Stars.StarPosition> starPositions = new ArrayList<>();
        starPositions.add(new Stars.StarPosition(5,5));
        starPositions.add(new Stars.StarPosition(10,10));
        starPositions.add(new Stars.StarPosition(15,15));
        starPositions.add(new Stars.StarPosition(20,20));

        when(stars.getStarPosition()).thenReturn(starPositions);
        starsView = new StarsView(textGraphics, stars);

        starsView.draw();

        verify(textGraphics).setCharacter(5, 5, new TextCharacter('*')
                .withBackgroundColor(TextColor.ANSI.BLACK)
                .withForegroundColor(TextColor.ANSI.WHITE));
        verify(textGraphics).setCharacter(10, 10, new TextCharacter('*')
                .withBackgroundColor(TextColor.ANSI.BLACK)
                .withForegroundColor(TextColor.ANSI.WHITE));
        verify(textGraphics).setCharacter(15, 15, new TextCharacter('*')
                .withBackgroundColor(TextColor.ANSI.BLACK)
                .withForegroundColor(TextColor.ANSI.WHITE));
        verify(textGraphics).setCharacter(20, 20, new TextCharacter('*')
                .withBackgroundColor(TextColor.ANSI.BLACK)
                .withForegroundColor(TextColor.ANSI.WHITE));
    }

}

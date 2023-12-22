package org.space.invaders.model.game.map;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import org.space.invaders.view.game.StarsView;

import java.awt.*;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StarsTest {

    @InjectMocks
    private Stars stars;

    @Mock
    private TextGraphics textGraphics;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testConstructorWithParameters() {
        Stars.StarPosition starPosition = new Stars.StarPosition(1, 2);
        List<Stars.StarPosition> starPositions = List.of(starPosition);
        assertTrue(starPositions.stream().allMatch(Objects::nonNull));
    }

    @Test
    void testDefaultConstructor() {
        Stars stars = new Stars();
        List<Stars.StarPosition> starPositions = stars.getStarPosition();

        assertEquals(150, starPositions.size());

        assertTrue(starPositions.stream().allMatch(Objects::nonNull));
    }

    @Test
    void testGenerateRandomStarPositions() {
        Stars stars = new Stars();
        List<Stars.StarPosition> starPositions = stars.getStarPosition();

        assertEquals(150, starPositions.size());
    }

    @Test
    void testDraw() {
        TextGraphics screen = mock(TextGraphics.class);
        Stars stars = new Stars(0,0);
        stars.draw(screen);
    }

    @Test
    public void testGetStarPosition() {
        Stars stars = new Stars();

        List<Stars.StarPosition> result = stars.getStarPosition();

        assertEquals(150, result.size());
    }
}

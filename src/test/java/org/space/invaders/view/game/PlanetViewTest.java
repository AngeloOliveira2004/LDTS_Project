package org.space.invaders.view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.UI.Score;
import org.space.invaders.model.game.elements.Planet;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class PlanetViewTest {
    PlanetView planetView;
    @Mock
    Planet planet;
    @Mock
    TextGraphics textGraphics;
    @BeforeEach
    void setup()
    {
        this.planet = mock(Planet.class);
        this.textGraphics = mock(TextGraphics.class);
        this.planetView = new PlanetView(planet , textGraphics);
    }
    @Test
    void ActualDraw() throws IOException {
        when(planet.getPosition()).thenReturn(new Position(5,5));
        planetView.draw();
        planetView = mock(PlanetView.class);
        planetView.draw();
        verify(planetView , times(1)).draw();
    }

    @Test
    void testGetters() {

         final String[] planetModel = new String[]{
                "     bbbbbb     ",
                "   GGbbbbbbAG   ",
                "  AbbbGGbbbbGG  ",
                " AbbGbbGGbbbGbA ",
                " AbGGGGbbbbbbGA ",
                "AbGGGGGbbbbbGGGG",
                "AbGGGbbbbbbbGGGG",
                "AAbGGbbbbbbbbGGG",
                "AAbbGbGGbbbbbbbG",
                "AAAbbGGGGGbbbbbG",
                "AAAbbGGGGGbbbbGG",
                " AAbbGGGGbbbbbG ",
                " AAbbbGGGbbbbbb ",
                "  AAbbGGbbbbbb  ",
                "   AAbGbbbbbb   ",
                "     bbbbbb     ",
        };


        assertEquals(planetModel.length, planetView.getDesign().length);
    }
}

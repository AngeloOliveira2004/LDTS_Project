package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.space.invaders.view.game.DefaultEnemyView;
import org.space.invaders.view.game.PlanetView;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.mock;

class PlanetTest {

    @InjectMocks
    private Planet planet;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDraw() throws IOException {
        TextGraphics textGraphics = mock(TextGraphics.class);

        Planet planet = new Planet();

        PlanetView planetViewMock = mock(PlanetView.class);

        planet.draw(textGraphics);

        Mockito.verify(planetViewMock,Mockito.times(0)).draw();
    }

    @Test
    void testGetDesign() {
        assertArrayEquals(new String[0], planet.getDesign());
    }
}

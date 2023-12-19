package org.space.invaders.model.game.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PlanetTest {

    @InjectMocks
    private Planet planet;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDraw() throws IOException {
    }

    @Test
    void testGetDesign() {
        assertArrayEquals(new String[0], planet.getDesign());
    }
}

package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShotElementTest {

    @InjectMocks
    private ShotElementTestImpl shotElement;

    @Mock
    private TextGraphics textGraphics;

    @BeforeEach
    void setUp() {
        shotElement = new ShotElementTestImpl(new Position(0,0),2,2);
    }

    @Test
    void testGetPosition() {
        Position position = shotElement.getPosition();
        assertNotNull(position);
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
    }

    @Test
    void testGetXPosition() {
        int xPosition = shotElement.getXposition();
        assertEquals(0, xPosition);
    }

    @Test
    void testGetYPosition() {
        int yPosition = shotElement.getYposition();
        assertEquals(0, yPosition);
    }

    @Test
    void testSetPosition() {
        Position newPosition = new Position(5, 10);
        shotElement.setPosition(newPosition);
        assertEquals(newPosition, shotElement.getPosition());
    }

    @Test
    void testSetYPosition() {
        int newY = 15;
        shotElement.setYPosition(newY);
        assertEquals(newY, shotElement.getYposition());
    }

    @Test
    void testGetYVelocity() {
        int yVelocity = shotElement.getYVelocity();
        assertEquals(2, yVelocity);
    }

    @Test
    void testSetYVelocity() {
        int newYVelocity = 5;
        shotElement.setYVelocity(newYVelocity);
        assertEquals(newYVelocity, shotElement.getYVelocity());
    }

    @Test
    void testIsInsideBorders() {
        assertFalse(shotElement.isInsideBorders());
    }

    @Test
    void testDraw() throws IOException {
        shotElement.draw(textGraphics);
    }

    @Test
    void testGetDamage() {
        int damage = shotElement.getDamage();
        assertEquals(2, damage);
    }

    private static class ShotElementTestImpl extends ShotElement {
        public ShotElementTestImpl(Position position, int yVelocity, int damage) {
            super(position, yVelocity, damage);
        }

        @Override
        public void draw(TextGraphics textGraphics) throws IOException {
        }
    }
}

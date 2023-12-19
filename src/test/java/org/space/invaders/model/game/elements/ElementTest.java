package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.space.invaders.model.Position;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ElementTest {

    private TextGraphics textGraphics;
    private Element element;

    @BeforeEach
    void setUp() {
        textGraphics = mock(TextGraphics.class);
        element = new ElementImpl(50, 50, 1, 1, 100, 1, true, 1, 1, 10);
    }

    @Test
    void testGetPosition() {
        Position position = element.getPosition();
        assertNotNull(position);
        assertEquals(50, position.getX());
        assertEquals(50, position.getY());
    }

    @Test
    public void testGetXPosition() {
        int position = element.getXposition();
        assertNotNull(position);
        assertEquals(50, position);
    }

    @Test
    public void testGetYPosition() {
        int position = element.getYposition();
        assertNotNull(position);
        assertEquals(50, position);
    }

    @Test
    void testSetPosition() {
        Position newPosition = new Position(10, 10);
        element.setPosition(newPosition);
        assertEquals(newPosition, element.getPosition());
    }

    @Test
    public void testGetHealth() {
        assertEquals(100, element.getHealth());
    }

    @Test
    public void testSetHealth() {
        element.setHealth(150);
        assertEquals(150, element.getHealth());
    }

    @Test
    public void testGetYVelocity() {
        assertEquals(1, element.getYVelocity());
    }

    @Test
    public void testSetYVelocity() {
        element.setYVelocity(2);
        assertEquals(2, element.getYVelocity());
    }

    @Test
    public void testGetXVelocity() {
        assertEquals(1, element.getXVelocity());
    }

    @Test
    public void testSetXVelocity() {
        element.setXVelocity(2);
        assertEquals(2, element.getXVelocity());
    }


    @Test
    void testMoveForward() {
        Position initialPosition = element.getPosition();

        int expectedX = initialPosition.getX();
        int expectedY = initialPosition.getY() - element.getYVelocity();;

        element.moveFoward();

        assertEquals(expectedX, element.getPosition().getX());
        assertEquals(expectedY, element.getPosition().getY());
    }

    @Test
    void testMoveBackwards() {
        Position initialPosition = element.getPosition();

        int expectedX = initialPosition.getX();
        int expectedY = initialPosition.getY() + element.getYVelocity();;

        element.moveBackwards();

        assertEquals(expectedX, element.getPosition().getX());
        assertEquals(expectedY, element.getPosition().getY());
    }

    @Test
    public void testMoveLeft() {
        Position initialPosition = element.getPosition();

        int expectedX = initialPosition.getX() - element.getXVelocity();
        int expectedY = initialPosition.getY();

        element.moveLeft();

        assertEquals(expectedX, element.getPosition().getX());
        assertEquals(expectedY, element.getPosition().getY());
    }



    @Test
    public void testMoveRight() {
        Position initialPosition = element.getPosition();

        int expectedX = initialPosition.getX() + element.getXVelocity();
        int expectedY = initialPosition.getY();

        element.moveRight();

        assertEquals(expectedX, element.getPosition().getX());
        assertEquals(expectedY, element.getPosition().getY());
    }




    @Test
    void testIsInsideBorders() {
        assertTrue(element.isInsideBorders());
    }

    @Test
    void testSetOccupiedPositions() {
        ArrayList<Position> occupiedPositions = new ArrayList<>();
        occupiedPositions.add(new Position(1, 1));
        occupiedPositions.add(new Position(2, 2));

        element.setOccupiedPositions(occupiedPositions);

        assertEquals(occupiedPositions, element.getOccupiedPositions());
    }

    @Test
    public void testGetScore() {
        assertEquals(10, element.getScore());
    }


    private static class ElementImpl extends Element {
        public ElementImpl(int x, int y, int Yvelocity, int Xvelocity, int Health, int SpawnRate,
                           boolean alive, int height, int width, int score) {
            super(x, y, Yvelocity, Xvelocity, Health, SpawnRate, alive, height, width, score);
        }


        @Override
        public void draw(TextGraphics textGraphics) throws IOException {
        }

        @Override
        public String[] getDesign() {
            return new String[0];
        }
    }
}

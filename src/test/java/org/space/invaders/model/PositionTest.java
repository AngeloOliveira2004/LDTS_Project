package org.space.invaders.model;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void testGetX() {
        Position position = new Position(1, 2);

        assertEquals(1, position.getX());
    }

    @Test
    public void testSetX() {
        Position position = new Position(1, 2);

        position.setX(3);
        assertEquals(3, position.getX());
    }

    @Test
    public void testGetY() {
        Position position = new Position(1, 2);

        assertEquals(2, position.getY());
    }

    @Test
    public void testSetY() {
        Position position = new Position(1, 2);

        position.setY(4);
        assertEquals(4, position.getY());
    }

    @Test
    public void testPositionEquality() {
        Position position1 = new Position(1, 2);
        Position position2 = new Position(1, 2);
        Position position3 = new Position(3, 4);

        assertEquals(position1, position2);
        assertNotEquals(position1, position3);
        assertNotEquals(position2, position3);
    }

    @Test
    public void testPositionClone() {
        Position originalPosition = new Position(1, 2);
        Position clonedPosition = originalPosition.clone();

        assertEquals(originalPosition, clonedPosition);

        assertNotSame(originalPosition, clonedPosition);
    }

    @Test
    public void testPositionHashCode() {
        Position position1 = new Position(1, 2);
        Position position2 = new Position(1, 2);
        Position position3 = new Position(3, 4);

        assertEquals(position1.hashCode(), position2.hashCode());

        assertNotEquals(position1.hashCode(), position3.hashCode());
        assertNotEquals(position2.hashCode(), position3.hashCode());
    }
}

package org.space.invaders.model.game;

import org.junit.jupiter.api.Test;
import org.space.invaders.model.Position;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ColliderTest {

    @Test
    void testCollision() {
        Collider collider = new Collider() {};

        Position position1 = new Position(0, 0);
        String[] object1 = {"**", "**"};

        Position position2 = new Position(1, 1);
        String[] object2 = {"**", "**"};

        assertTrue(collider.collision(position1, object1, position2, object2));
    }

    @Test
    void testNoCollision() {
        Collider collider = new Collider() {};

        Position position1 = new Position(0, 0);
        String[] object1 = {"**", "**"};

        Position position2 = new Position(3, 3);
        String[] object2 = {"**", "**"};

        assertFalse(collider.collision(position1, object1, position2, object2));
    }

    @Test
    void testCheckCollisions() {
        Collider collider = new Collider() {};

        ArrayList<Position> positions1 = new ArrayList<>(Arrays.asList(new Position(1, 1), new Position(2, 2)));
        ArrayList<Position> positions2 = new ArrayList<>(Arrays.asList(new Position(2, 2), new Position(3, 3)));

        assertTrue(collider.checkColisions(positions1, positions2));
    }

    @Test
    void testNoCollisions() {
        Collider collider = new Collider() {};

        ArrayList<Position> positions1 = new ArrayList<>(Arrays.asList(new Position(1, 1), new Position(2, 2)));
        ArrayList<Position> positions2 = new ArrayList<>(Arrays.asList(new Position(3, 3), new Position(4, 4)));

        assertFalse(collider.checkColisions(positions1, positions2));
    }

    @Test
    void testCheckCollisionsWithShots() {
        Collider collider = new Collider() {};

        ArrayList<Position> positions = new ArrayList<>(Arrays.asList(new Position(1, 1), new Position(2, 2)));
        Position position = new Position(2, 2);

        assertTrue(collider.checkColisionsWithShots(positions, position));
    }

    @Test
    void testNoCollisionsWithShots() {
        Collider collider = new Collider() {};

        ArrayList<Position> positions = new ArrayList<>(Arrays.asList(new Position(1, 1), new Position(2, 2)));
        Position position = new Position(3, 3);

        assertFalse(collider.checkColisionsWithShots(positions, position));
    }
}

package org.space.invaders.model.game;

import org.space.invaders.model.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public interface Collider {
    default boolean collision(Position position1, String[] object1, Position position2, String[] object2) {
        Set<Position> positions = new HashSet<>();

        extractNonEmptyPositions(position1, object1, positions);
        return checkCollision(position2, object2, positions);
    }
    private void extractNonEmptyPositions(Position position, String[] object, Set<Position> positions) {
        for (int y = 0; y < object.length; y++) {
            for (int x = 0; x < object[y].length(); x++) {
                if (object[y].charAt(x) != ' ') {
                    positions.add(new Position(x + position.x, y + position.y));
                }
            }
        }
    }

    private boolean checkCollision(Position position, String[] object, Set<Position> positions) {
        for (int y = 0; y < object.length; y++) {
            for (int x = 0; x < object[y].length(); x++) {
                if (object[y].charAt(x) != ' ') {
                    Position arbitraryPosition = new Position(x + position.x, y + position.y);
                    if (positions.contains(arbitraryPosition)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public default boolean checkColisions(ArrayList<Position> positions , ArrayList<Position> positions2)
    {
        if(positions2 == null || positions == null) return false;
        for(Position position : positions)
        {
            if(positions2.contains(position)) return true;
        }
        return false;
    }
    public default boolean checkColisionsWithShots(ArrayList<Position> positions, Position position)
    {
        /*
        for(Position position1 : positions)
        {
            System.out.println(position1.x);
            System.out.println(position1.y);
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.println(position.x);
        System.out.println(position.y);
        */
        return positions.contains(position);
    }
}

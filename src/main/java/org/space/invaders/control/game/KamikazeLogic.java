package org.space.invaders.control.game;

import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.KamikazeEnemy;
import org.space.invaders.model.game.elements.NormalSpaceShip;

import java.util.ArrayList;
import java.util.List;

public class KamikazeLogic implements EnemyLogic , PathFinding {
    private Position spaceshipPosition;
    private KamikazeEnemy kamikazeEnemy;

    public KamikazeLogic(Position position, KamikazeEnemy kamikazeEnemy) {
        this.spaceshipPosition = position;
        this.kamikazeEnemy = kamikazeEnemy;
    }

    @Override
    public List<Position> findPath(Position start, Position goal, Grid grid) {
        // This is a simple implementation without a grid
        List<Position> path = new ArrayList<>();
        path.add(goal);  // Move directly to the goal position
        return path;
    }

    public void move() {
        Position start = kamikazeEnemy.getPosition();
        Position goal = spaceshipPosition;

        // Find the direct path
        List<Position> path = findPath(start, goal, null);

        // Move towards the NormalSpaceShip
        if (path != null && !path.isEmpty()) {
            Position nextPosition = path.get(0);
            kamikazeEnemy.setPosition(nextPosition);
        }
    }
    public void update()
    {
        move();
    }
}

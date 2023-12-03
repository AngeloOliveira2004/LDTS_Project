package org.space.invaders.control.game;

import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.NormalSpaceShip;

import java.util.ArrayList;
import java.util.List;

public class KamikazeLogic implements PathFinding {
    private NormalSpaceShip normalSpaceShip;
    private org.space.invaders.model.game.elements.KamikazeEnemy kamikazeEnemy;

    public KamikazeLogic(NormalSpaceShip normalSpaceShip, org.space.invaders.model.game.elements.KamikazeEnemy kamikazeEnemy) {
        this.normalSpaceShip = normalSpaceShip;
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
        org.space.invaders.model.Position start = kamikazeEnemy.getPosition();
        org.space.invaders.model.Position goal = normalSpaceShip.getPosition();

        // Find the direct path
        List<Position> path = findPath(start, goal, null);

        // Move towards the NormalSpaceShip
        if (path != null && !path.isEmpty()) {
            Position nextPosition = path.get(0);
            kamikazeEnemy.setPosition(nextPosition);
        }
    }
}

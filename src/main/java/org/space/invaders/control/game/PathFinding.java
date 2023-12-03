package org.space.invaders.control.game;

import java.util.List;
import org.space.invaders.model.Position;

public interface PathFinding {
    List<Position> findPath(Position start, Position goal, Grid grid);

    interface Grid {
        boolean isValid(Position position);
        int getCost(Position position);
        void setCost(Position position, int cost);
    }

}



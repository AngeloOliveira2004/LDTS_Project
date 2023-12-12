package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.control.game.DefaultEnemyController;
import org.space.invaders.control.game.MiniSpaceShip;
import org.space.invaders.model.Arena;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.view.game.MiniShotView;
import org.space.invaders.view.game.MiniTrackingShotView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MiniTrackingShot extends ShotElement{
    private MiniTrackingShotView miniTrackingShotView;
    Position position;
    public MiniTrackingShot(Position position, int yVelocity) {
        super(position, yVelocity,5);
    }
    public Position findClosestEnemy(Arena arena,Position Shotposition){
        List<Position> enemyPositions = new ArrayList<>();
        double min_distance = Integer.MAX_VALUE;
        Position resultingPosition = new Position(0,0);
        for(Position enemyposition : enemyPositions){
            double tempMin = enemyposition.calculateDistance(Shotposition);
            if(min_distance > tempMin){
                min_distance = tempMin;
                resultingPosition = enemyposition;
            }
        }
        return resultingPosition;
    }
    @Override
    public void draw(TextGraphics textGraphics) throws IOException {
        miniTrackingShotView = new MiniTrackingShotView(textGraphics, this);
        miniTrackingShotView.draw();
    }
}
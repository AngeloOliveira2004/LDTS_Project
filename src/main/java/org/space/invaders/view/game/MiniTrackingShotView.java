package org.space.invaders.view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.control.game.DefaultEnemyController;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.MiniShot;
import org.space.invaders.model.game.elements.MiniTrackingShot;

import java.io.IOException;
import java.util.ArrayList;

public class MiniTrackingShotView extends View{
    private MiniTrackingShot miniTrackingShot;
    Position position;


    public MiniTrackingShotView(TextGraphics textGraphics, MiniTrackingShot miniShot) {
        super(3, 3,textGraphics);
        this.position = miniShot.getPosition();
    }
    @Override
    public void draw() throws IOException {
            /*
        Position goal = miniTrackingShot.findClosestEnemy();
        Position start = miniTrackingShot.getPosition();

        int dx = goal.getX() - start.getX();
        int dy = goal.getY() - start.getY();

        int newX = start.getX() + MiniTrackingShot.getXVelocity();
        int newY = start.getY() + MiniTrackingShot.getYVelocity();

        MiniTrackingShot.setPosition(new Position(newX, newY))\
            */
    }
}

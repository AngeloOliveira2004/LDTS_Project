package org.space.invaders.view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.control.game.DefaultEnemyController;
import org.space.invaders.control.game.Enemies;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.MiniTrackingShot;

import java.io.IOException;
import java.util.ArrayList;

public class MiniTrackingShotView extends View{
    private ArrayList<DefaultEnemyController> enemies;
    Position position;
    public MiniTrackingShotView(TextGraphics textGraphics, MiniTrackingShot miniShot) {
        super(3, 3,textGraphics);
        this.position = miniShot.getPosition();
    }
    @Override
    public void draw() throws IOException {
        /*
        Position goal = findClosestEnemy(enemies).getPosition(); // implement findClosest enemy or select random enemy on screen
        Position start = miniSpaceShip.getPosition();

        int dx = goal.getX() - start.getX();
        int dy = goal.getY() - start.getY();

        int signX = Integer.compare(dx, 0);
        int signY = Integer.compare(dy, 0);

        int newX = start.getX() + MiniTrackingShot.getXVelocity();
        int newY = start.getY() + MiniTrackingShot.getYVelocity();

        MiniTrackingShot.setPosition(new Position(newX, newY))
         */
    }

}

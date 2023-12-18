package org.space.invaders.control.game;

import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.KamikazeEnemy;
import java.util.ArrayList;
import java.util.List;

public class KamikazeController implements EnemyLogic {
    private Position spaceshipPosition;
    private KamikazeEnemy kamikazeEnemy;
    private int iterations;
    public KamikazeController(Position position, KamikazeEnemy kamikazeEnemy) {
        this.spaceshipPosition = position;
        this.kamikazeEnemy = kamikazeEnemy;
        this.iterations = 0;
    }

    public void move() {
        Position start = kamikazeEnemy.getPosition();
        Position goal = spaceshipPosition;

        // Calculate the vector from the kamikaze enemy to the spaceship
        int dx = goal.getX() - start.getX();
        int dy = goal.getY() - start.getY();

        // Determine the direction (sign) of the velocities
        int signX = Integer.compare(dx, 0);
        int signY = Integer.compare(dy, 0);

        // Set the kamikaze enemy's velocities based on the direction
        kamikazeEnemy.setXVelocity(signX);
        kamikazeEnemy.setYVelocity(signY);

        // Update the kamikaze enemy's position based on velocities
        int newX = start.getX() + kamikazeEnemy.getXVelocity();
        int newY = start.getY() + kamikazeEnemy.getYVelocity();

        kamikazeEnemy.setPosition(new Position(newX, newY));
    }


    public void update()
    {
        if(iterations == 3)
        {
            move();
            iterations = -1;
        }
        iterations++;
    }

    public  int getIterations(){return iterations;}
    public KamikazeEnemy getKamikazeEnemy(){return kamikazeEnemy;}
}

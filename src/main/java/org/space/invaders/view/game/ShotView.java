package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.control.game.ShotController;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.Shot;

import java.io.IOException;

public class ShotView extends View{
    private ShotController shotController;
    int yVelocity = 1;
    private int bool;
    private Shot shot;
    private Position position;
    public ShotView(TextGraphics textGraphics , Shot shot) {
        super(0,0 , textGraphics);
        this.position = shot.getPosition();
        this.yVelocity = 1;
        this.shot = shot;
        shotController = new ShotController(shot);
        this.bool = bool;
    }

    @Override
    public void draw()
    {
        setColor('Y');
        graphics.putString(position.x +4, position.y - yVelocity, "|");
        graphics.fillRectangle(new TerminalPosition((int)(position.x +4),
                        (int)(position.y + yVelocity + 5)),
                new TerminalSize(1,1), ' ');
        shotController.update();
        shot.resetCount();
    }
    public void setShotController(ShotController shotController){this.shotController = shotController;}
}

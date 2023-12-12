package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.control.game.ShotController;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.MiniShot;

import java.io.IOException;

public class MiniShotView extends View{
    private ShotController shotController;
    int yVelocity = 1;
    private Position position;
    public MiniShotView(TextGraphics textGraphics , MiniShot miniShot) {
        super(0,0 , textGraphics);
        this.position = miniShot.getPosition();
        this.yVelocity = 1;
        shotController = new ShotController(miniShot);
    }

    @Override
    public void draw() throws IOException {
        {
            setColor('W');
            graphics.putString(position.x +4, position.y - yVelocity, "|");
            graphics.fillRectangle(new TerminalPosition((int)(position.x +4),
                            (int)(position.y + yVelocity + 5)),
                    new TerminalSize(1,1), ' ');
            shotController.update();

        }
    }
}
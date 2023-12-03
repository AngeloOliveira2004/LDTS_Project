package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import org.space.invaders.model.game.elements.NormalSpaceShip;

import java.io.IOException;

public class Shot extends View{
    private org.space.invaders.model.game.elements.Shot shot;
    int yVelocity = 1;
    int yPosition;
    private NormalSpaceShip normalSpaceShip;
    public Shot(NormalSpaceShip normalSpaceShip) {
        super(0,0);
        this.normalSpaceShip = normalSpaceShip;
        yPosition = normalSpaceShip.getYposition();
        this.yVelocity = 1;
    }

    @Override
    public void draw()
    {
    }
    public void Actualdraw(NormalSpaceShip normalSpaceShip) throws IOException {
        setColor('W');
        graphics.fillRectangle(new TerminalPosition((int)(normalSpaceShip.getPosition().x),
                        (int)(normalSpaceShip.getPosition().y + yVelocity)),
                new TerminalSize(1,1), ' ');
    }
}

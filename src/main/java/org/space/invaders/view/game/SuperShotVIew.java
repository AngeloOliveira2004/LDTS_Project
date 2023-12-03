package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.NormalSpaceShip;
import org.space.invaders.model.game.elements.SuperShot;
import org.space.invaders.Constants;
import org.space.invaders.view.Color;

import java.io.IOException;

import static org.space.invaders.Constants.HEIGHT;

public class SuperShotVIew extends View {
    private SuperShot superShot;
    private static final int CHAR_WIDTH = 3;

    private static final int CHAR_HEIGHT = HEIGHT;
    private static String[] superShotModel =
            {"bWWWWbb"};
    int yVelocity = 1;
    int Yposition;

    public SuperShotVIew(SuperShot superShot)
    {
        super(CHAR_WIDTH , CHAR_HEIGHT);
        this.superShot = superShot;
    }

    public void Actualdraw(NormalSpaceShip normalSpaceShip) throws IOException {
        if(Yposition < HEIGHT)
        {
            for(int y = 0 ; y < superShotModel.length ; y++)
            {
                for(int x = 0 ; x < superShotModel[0].length() ; x++)
                {
                    char c = superShotModel[y].charAt(x);
                    setColor(c);

                    graphics.fillRectangle(new TerminalPosition((int)(normalSpaceShip.getPosition().x*CHAR_WIDTH),
                                    (int)(Yposition + yVelocity)),
                            new TerminalSize(CHAR_WIDTH, CHAR_HEIGHT), ' ');
                    Yposition -= yVelocity;
                }
            }
        }

    }

    @Override
    public void draw() throws IOException {
        if(superShot.getYposition() < HEIGHT)
        {
            if(superShot.getIterations() <= superShot.getCount())
            {
                for(int y = 0 ; y < superShotModel.length ; y++)
                {
                    for(int x = 0 ; x < superShotModel[0].length() ; x++)
                    {
                        char c = superShotModel[y].charAt(x);
                        setColor(c);

                        graphics.fillRectangle(new TerminalPosition((int)(superShot.getXposition()*CHAR_WIDTH),
                                        (int)(superShot.getYposition() + yVelocity)),
                                new TerminalSize(CHAR_WIDTH, CHAR_HEIGHT), ' ');
                        int Yposition = superShot.getYposition() - superShot.getYVelocity();
                        superShot.setYPosition(Yposition);
                        superShot.incrementIterations();
                    }
                }
            }
            else
            {
                superShot.resetCount();
                superShot.resetIterations();
            }
        }
    }
}

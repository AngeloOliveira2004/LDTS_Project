package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.model.game.elements.NormalSpaceShip;

public class SpaceshipView extends View{
    private SpaceShip spaceShip;
    private static final int CHAR_HEIGHT = 5;
    private static final int CHAR_WIDTH = 5;
    private static final String[] SpaceShipModel = {"A" , " "};
    private static final String[] SpaceShipModelWithFlames = {"A" , " "};
    private static final String[] MiniSpaceShipModel = {"A" , " "};
    private static final String[] MiniSpaceShipModelWithFlames = {"A" , " "};
    public SpaceshipView(SpaceShip spaceShip , TextGraphics textGraphics)
    {
        super(CHAR_HEIGHT , CHAR_WIDTH , textGraphics);
        this.spaceShip = spaceShip;
    }
    @Override
    public void draw()
    {
        int x = spaceShip.getPosition().getX();
        int y = spaceShip.getPosition().getY();
        if(spaceShip.isMini())
        {
            drawMiniSpaceShip(x , y);
        }
        else
        {
            drawSpaceShip(x , y);
        }
    }
    private void drawMiniSpaceShip(int spaceshipX , int spaceshipY)
    {
        for(int y = 0 ; y < MiniSpaceShipModel.length ; y++)
        {
            for(int x = 0 ; x < MiniSpaceShipModel[0].length() ; x++)
            {
                char character = MiniSpaceShipModel[y].charAt(x);
                if (character != ' ') {
                    setColor(character);
                    getGraphics().putString(spaceshipX , spaceshipY , "Minispaceship");
                    getGraphics().fillRectangle(new TerminalPosition(spaceshipX * CHAR_WIDTH
                                    , spaceshipY * charHeight)
                            , new TerminalSize(CHAR_WIDTH, CHAR_HEIGHT), ' ');
                }
            }
        }
    }
    private void drawSpaceShip(int spaceshipX , int spaceshipY)
    {
        for(int y = 0 ; y < SpaceShipModel.length ; y++)
        {
            for(int x = 0 ; x < SpaceShipModel[0].length() ; x++)
            {
                char character = SpaceShipModel[y].charAt(x);
                if (character != ' ') {
                    setColor(character);
                    getGraphics().putString(spaceshipX , spaceshipY , "Spaceship");
                    graphics.fillRectangle(new TerminalPosition(spaceshipX * CHAR_WIDTH
                                    , spaceshipY * charHeight)
                            , new TerminalSize(CHAR_WIDTH, CHAR_HEIGHT), ' ');
                }
            }
        }
    }
    public void sendInput()
    {

    }
}

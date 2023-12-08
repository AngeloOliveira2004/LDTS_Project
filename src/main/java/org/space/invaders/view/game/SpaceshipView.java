package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.SpaceShip;

import java.util.ArrayList;

public class SpaceshipView extends View{
    private SpaceShip spaceShip;
    private static final int CHAR_HEIGHT = 5;
    private static final int CHAR_WIDTH = 5;
    private static final String[] SpaceShipModel = new String[]{
            "   A   ",
            "   AAA  ",
            "  AAAAA ",
            " AAAAAAA",
            "AAAAAAAA",
            " AAAAAAA",
            "  AAAAA ",
            "   AAA  ",
            "    A   "
    };

    private static final String[] SpaceShipModelWithFlames = {"A" , " "};
    private static final String[] MiniSpaceShipModel = new String[]{
            " A ",
            "AAA",
            " A "
    };

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
        ArrayList<Position> positions = new ArrayList<>();
        int x = (int)spaceShip.getPosition().getX();
        int y = (int)spaceShip.getPosition().getY();
        drawImage(MiniSpaceShipModel, x, y , positions);
        spaceShip.setOccupiedPositions(positions);
    }
    private void drawSpaceShip(int spaceshipX , int spaceshipY)
    {
        ArrayList<Position> positions = new ArrayList<>();
        int x = (int)spaceShip.getPosition().getX();
        int y = (int)spaceShip.getPosition().getY();
        drawImage(SpaceShipModel, x, y , positions);
        spaceShip.setOccupiedPositions(positions);
    }
    public void sendInput()
    {

    }
    public String[] getDesign(){return  SpaceShipModel;}
}

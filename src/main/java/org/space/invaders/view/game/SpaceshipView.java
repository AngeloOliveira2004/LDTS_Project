package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.SpaceShip;

import java.util.ArrayList;

public class SpaceshipView extends View{
    private SpaceShip spaceShip;
    private static final int CHAR_HEIGHT = 1;
    private static final int CHAR_WIDTH = 1;
    private static final String[] SpaceShipModel = new String[]{
            "            RR            ",
            "           RRRR           ",
            "          CCbbCC          ",
            "         CRCbbCRC         ",
            "         CRRbbRRC         ",
            "         CCCbbCCC         ",
            "        CRCbbbbCRC        ",
            "        CCCbbbbCCC        ",
            " C      CRCbbbbCRC      C ",
            "RcR     CcRCCCCRcC     RcR",
            "RccC    CccRCCRccC    CccR",
            "CccC    CCccRRccCC    CccC",
            "RRRCC  CcCccccccCcC  CCRRR",
            "RRCcCCCCcCCCRRCCCcCCCCcCRR",
            "CcccRcRRCcCCccCCcCRRcRcccC",
            "RcccRccRRCcCccCcCRRccRcccR",
            " RccRcccRRCRRRRCRRcccRccR ",
            " CRccRcccCRccccRCcccRccRC ",
            "  CRccRRCccCCCCccCRRccRC  ",
            "   CRcccCRRccccRRCcccRC   ",
            "    CRcRR CRccRC RRcRC    ",
            "     CCC  CCRRCC  CCC     ",
            "     ROR   CCCC   ROR     ",
            "     OYO   ROOR   OYO     ",
            "      Y   ROYYOR   Y      ",
            "            YY            ",
    };
    private static final String[] InvincibleSpaceShipModel = new String[]{
            "            RR            ",
            "           RRRR           ",
            "          CCbbCC          ",
            "         CRCbbCRC         ",
            "         CRRbbRRC         ",
            "         CCCbbCCC         ",
            "        CRCbbbbCRC        ",
            "        CCCbbbbCCC        ",
            " C      CRCbbbbCRC      C ",
            "RcR     CcRCCCCRcC     RcR",
            "RWWC    CWWRWWRWW    WWCWW",
            "WWWC    WWWRWWWWWW    WWCWW",
            "RRRWW  WWWWWWWWWWWW  WWRRR",
            "RWWWWWWWWWWWWRRWWWWWWWWWWCRR",
            "WWWWRWRRWWWWWWWWWWWWRRWWWWC",
            "RWWWRWWRRWWWWWWWWWWRRWWRWWW",
            " RWRRWRRRWRRRRRWRRRWRRWRR ",
            " CRWWRWRRCRWWWWRCRRWRRWRC ",
            "  CRWWRRWCRWWWWCRWRRWRCW  ",
            "   CRWRRRCWWWWWRWWRCRW   ",
            "    CRWRR WRWWRC RRWRC    ",
            "     CCC  CRRCC  CCC     ",
            "     ROR   CCCW   ROR     ",
            "     OYO   RORR   OYO     ",
            "      Y   RYWYOR   Y      ",
            "            YY            ",
    };

    private static final String[] MiniSpaceShipModel = new String[]{
            "       RR       ",
            "      RRRR      ",
            "      CbbC      ",
            "      CbbC      ",
            "     CRCCRC     ",
            "  C  CcRRcC  C  ",
            " CR  CRCCRC  RC ",
            " CcC CCccCC CcC ",
            " CRcCcRCCRcCcRC ",
            "  CcCRccccRCcC  ",
            "   CcCcRRcCcC   ",
            "  CcRcRccRcRcC  ",
            "  CCCRCRRCRCCC  ",
            "     CCCCCC     ",
            "      ROOR      ",
            "     ROYYOR     ",
    };
    private static final String[] InvincibleMiniSpaceShipModel = new String[]{
            "       RR       ",
            "      RRRR      ",
            "      CbbC      ",
            "      CbbC      ",
            "     CRCCRC     ",
            "  C  CWRRW  C  ",
            " CR  CRCCRC  RW ",
            " CWC CCWWCC WC ",
            " CRWCRWRCRWCRWRC ",
            "  CWCRWWWRWCRW  ",
            "   CWCRWRRWCRW   ",
            "  CWRCRWCCRWCRW  ",
            "  CCCRCRRCRCCC  ",
            "     CCCCCC     ",
            "      ROOR      ",
            "     ROYYOR     ",
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
        if(!spaceShip.isInvincible())
        {
            if(spaceShip.isMini())
            {
                drawMiniSpaceShip();
            }
            else
            {
                drawSpaceShip();
            }

        }else
        {
            if(spaceShip.isMini()) {
                drawWithInvincibilityMini();
            }
            else
            {
                drawWithInvincibilityNormal();
            }
        }
    }
    private void drawMiniSpaceShip()
    {
        ArrayList<Position> positions = new ArrayList<>();
        int x = (int)spaceShip.getPosition().getX();
        int y = (int)spaceShip.getPosition().getY();
        drawImage(MiniSpaceShipModel, x, y , positions);
        spaceShip.setOccupiedPositions(positions);
    }
    private void drawSpaceShip()
    {
        ArrayList<Position> positions = new ArrayList<>();
        int x = (int)spaceShip.getPosition().getX();
        int y = (int)spaceShip.getPosition().getY();
        drawImage(SpaceShipModel, x, y , positions);
        //spaceShip.setOccupiedPositions(positions);
    }
    private void drawWithInvincibilityMini()
    {
        ArrayList<Position> positions = new ArrayList<>();
        int x = (int)spaceShip.getPosition().getX();
        int y = (int)spaceShip.getPosition().getY();
        drawImage(InvincibleMiniSpaceShipModel, x, y , positions);
    }

    private void drawWithInvincibilityNormal()
    {
        ArrayList<Position> positions = new ArrayList<>();
        int x = (int)spaceShip.getPosition().getX();
        int y = (int)spaceShip.getPosition().getY();
        drawImage(InvincibleSpaceShipModel, x, y , positions);
    }
    public String[] getDesign(){return  SpaceShipModel;}
}

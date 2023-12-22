package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.SpaceShip;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SpaceshipViewTest {
    @Mock
    private TextGraphics textGraphics;
    @Mock
    private SpaceShip spaceShip;
    private SpaceshipView spaceshipView;

    @BeforeEach
    public void setUp() throws IOException {
        Font myFont = new Font("Monospaced", Font.PLAIN, 3);
        AWTTerminalFontConfiguration myFontConfiguration = AWTTerminalFontConfiguration.newInstance(myFont);
        DefaultTerminalFactory dtf = new DefaultTerminalFactory();
        dtf.setForceAWTOverSwing(true);
        dtf.setTerminalEmulatorFontConfiguration(myFontConfiguration);
        dtf.setInitialTerminalSize(new TerminalSize(600, 325));

        Terminal terminal = dtf.createTerminal();
        Screen screen = new TerminalScreen(terminal);
        textGraphics = screen.newTextGraphics();

        spaceShip = mock(SpaceShip.class);
        spaceshipView = new SpaceshipView(spaceShip, textGraphics);
    }

    @Test
    void testDraw()
    {
        spaceshipView = mock(spaceshipView.getClass());
        spaceShip = mock(SpaceShip.class);
        spaceshipView.setSpaceShip(spaceShip);
        when(spaceShip.isInvincible()).thenReturn(false);
        when(spaceShip.isMini()).thenReturn(false);
        spaceshipView.draw();

    }
    @Test
    public void testNormalSpaceshipDraw() {
        when(spaceShip.isInvincible()).thenReturn(false);
        when(spaceShip.isMini()).thenReturn(false);
        when(spaceShip.getPosition()).thenReturn(new Position(10, 20));

        spaceshipView.draw();

        verify(spaceShip , times(1)).setOccupiedPositions(any());
    }

    @Test
    public void testNormalInvincibleSpaceshipDraw() {
        when(spaceShip.isInvincible()).thenReturn(true);
        when(spaceShip.isMini()).thenReturn(false);
        when(spaceShip.getPosition()).thenReturn(new Position(10, 20));

        SpaceshipView spaceshipView = new SpaceshipView(spaceShip, textGraphics);


        spaceshipView.draw();

        verify(spaceShip , never()).setOccupiedPositions(any());
    }

    @Test
    public void testMiniSpaceShipDraw() {
        when(spaceShip.isInvincible()).thenReturn(false);
        when(spaceShip.isMini()).thenReturn(true);
        when(spaceShip.getPosition()).thenReturn(new Position(10, 20));

        spaceshipView.draw();

        verify(spaceShip , times(1)).setOccupiedPositions(any());
    }

    @Test
    public void testMiniInvincibleSpaceShipDraw(){
        when(spaceShip.isInvincible()).thenReturn(true);
        when(spaceShip.isMini()).thenReturn(true);
        when(spaceShip.getPosition()).thenReturn(new Position(10, 20));

        SpaceshipView spaceshipView1 = new SpaceshipView(spaceShip, textGraphics);


        spaceshipView1.draw();

        verify(spaceShip , never()).setOccupiedPositions(any());
    }

    @Test
    void testDesigns()
    {
        final String[] SpaceShipModel = new String[]{
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
        final String[] InvincibleSpaceShipModel = new String[]{
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

        final String[] MiniSpaceShipModel = new String[]{
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
        final String[] InvincibleMiniSpaceShipModel = new String[]{
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

        assertEquals(SpaceShipModel.length , spaceshipView.getDesign1().length);
        assertEquals(InvincibleSpaceShipModel.length , spaceshipView.getDesign2().length);
        assertEquals(MiniSpaceShipModel.length , spaceshipView.getDesign3().length);
        assertEquals(InvincibleMiniSpaceShipModel.length , spaceshipView.getDesign4().length);

    }
}
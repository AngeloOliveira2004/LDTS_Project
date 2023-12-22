package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.control.game.ShotController;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.MiniShot;

import java.awt.*;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class MiniShotViewTest {

    @Mock
    private TextGraphics textGraphics;

    @Mock
    private ShotController shotController;

    @Mock
    private MiniShot miniShot;

    @Mock
    private Position position;
    private MiniShotView miniShotView;
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

        miniShot = mock(MiniShot.class);
        miniShotView = new MiniShotView(textGraphics, miniShot);
        miniShotView.setPosition(new Position(10, 10));
    }

    @Test
    public void testDrawMethod() throws IOException {
        shotController = mock(ShotController.class);
        miniShotView.setShotController(shotController);
        miniShotView.draw();
        verify(shotController).update();
    }
}

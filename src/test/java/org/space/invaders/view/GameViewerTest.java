package org.space.invaders.view;

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
import org.space.invaders.control.GameController;
import org.space.invaders.model.Arena;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.StrongEnemy;
import org.space.invaders.model.game.elements.StrongEnemy;
import org.space.invaders.model.game.map.Stars;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class GameViewerTest {

    @Mock
    GameController gameController;
    Screen screen;
    GameViewer gameViewer;
    @BeforeEach
    void setUp() throws IOException {
        Font myFont = new Font("Monospaced", Font.PLAIN, 3);
        AWTTerminalFontConfiguration myFontConfiguration = AWTTerminalFontConfiguration.newInstance(myFont);
        DefaultTerminalFactory dtf = new DefaultTerminalFactory();
        dtf.setForceAWTOverSwing(true);
        dtf.setTerminalEmulatorFontConfiguration(myFontConfiguration);
        dtf.setInitialTerminalSize(new TerminalSize(600, 325));

        Terminal terminal = dtf.createTerminal();
        screen = new TerminalScreen(terminal);

        gameController = mock(GameController.class);
        gameViewer = new GameViewer(gameController);
    }

    @Test
    void testDraw() throws IOException {
        Arena arena = mock(Arena.class);
        arena.getStars();

        gameViewer.drawElements(arena);
    }
}

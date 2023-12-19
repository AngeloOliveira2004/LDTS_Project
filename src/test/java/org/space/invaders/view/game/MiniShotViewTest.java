package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.control.game.ShotController;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.MiniShot;

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

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDrawMethod() throws IOException {
        when(miniShot.getPosition()).thenReturn(position);
        when(position.getX()).thenReturn(10);
        when(position.getY()).thenReturn(20);

        MiniShotView miniShotView = new MiniShotView(textGraphics, miniShot);

        miniShotView.draw();

        verify(textGraphics).putString(14, 19, "|");
        verify(textGraphics).fillRectangle(
                new TerminalPosition(14, 26),
                new TerminalSize(1, 1),
                ' '
        );
        verify(shotController).update();
    }
}

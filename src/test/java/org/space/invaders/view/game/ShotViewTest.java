package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.control.game.ShotController;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.Shot;

import static org.mockito.Mockito.*;

public class ShotViewTest {

    @Mock
    private TextGraphics textGraphics;

    @Mock
    private ShotController shotController;

    @Mock
    private Shot shot;

    @Mock
    private Position position;

    private ShotView shotView;

    @Before
    public void setUp() {
        shotView = new ShotView(textGraphics, shot);
    }

    @Test
    public void testDrawMethod() {
        when(shot.getPosition()).thenReturn(position);
        when(position.getX()).thenReturn(10);
        when(position.getY()).thenReturn(20);

        shotView.draw();

        verify(textGraphics).putString(14, 19, "|");
        verify(textGraphics).fillRectangle(
                new TerminalPosition(14, 26),
                new TerminalSize(1, 1),
                ' '
        );
        verify(shotController).update();
        verify(shot).resetCount();
    }
}

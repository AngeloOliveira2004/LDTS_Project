package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void setUp() {
        shot = mock(Shot.class);
        when(shot.getPosition()).thenReturn(new Position(10 , 10));
        textGraphics = mock(TextGraphics.class);
        shotController = mock(ShotController.class);
        shotView = new ShotView(textGraphics, shot);
        shotView.setShotController(shotController);
    }

    @Test
    public void testDrawMethod() {
        shotView.draw();

        verify(shotController, times(1)).update();
        verify(shot , times(1)).resetCount();
    }
}

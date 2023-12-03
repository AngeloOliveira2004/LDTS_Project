package SpaceInvaders;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Before;
import org.junit.Test;
import org.space.invaders.model.game.elements.Shot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ShotTest {
/*
    private Shot shot;
    private TextGraphics mockTextGraphics;

    @Before
    public void setUp() {
        shot = new Shot(5, 10);
        mockTextGraphics = mock(TextGraphics.class);
        when(mockTextGraphics.getSize()).thenReturn(new TerminalSize(20, 20));
    }

    @Test
    public void testShotPositionUpdate() {
        // Call the draw method multiple times to simulate the update of shot position
        for (int i = 0; i < 5; i++) {
            shot.draw(mockTextGraphics);
        }

        // Check if the Y position is updated correctly
        assertEquals(5, shot.getPositionX());
        assertEquals(5, shot.getPositionY());
    }

    @Test
    public void testShotDrawMethod() {
        shot.draw(mockTextGraphics);

        // Verify that the setCharacter method is called with the expected arguments
        verify(mockTextGraphics, times(2)).setCharacter(eq(5), anyInt(), any(TextCharacter.class));
        verify(mockTextGraphics).setCharacter(5, 9, new TextCharacter('|')
                .withBackgroundColor(TextColor.ANSI.BLACK)
                .withForegroundColor(TextColor.ANSI.YELLOW));
        verify(mockTextGraphics).setCharacter(5, 5, new TextCharacter('|')
                .withBackgroundColor(TextColor.ANSI.BLACK)
                .withForegroundColor(TextColor.ANSI.YELLOW));
    }

 */
}

package SpaceInvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.Shot;
import org.space.invaders.model.game.SpaceShip;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ShotTest {
    @InjectMocks
    private SpaceShip spaceShip;
    @Mock
    private Position positionMock;
    @Test
    public void DrawTest() {
        TextGraphics textGraphicsMock = Mockito.mock(TextGraphics.class);
        Shot shotMock = Mockito.mock(Shot.class);
        when(shotMock.getY()).thenReturn(20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        doNothing().when(textGraphicsMock).setCharacter(anyInt(), anyInt(), any(TextCharacter.class));
        shotMock.draw(textGraphicsMock);
        verify(textGraphicsMock, times(20)).setCharacter(anyInt(), anyInt(), any());
    }
}
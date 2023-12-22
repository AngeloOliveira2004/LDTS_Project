package org.space.invaders.control.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.space.invaders.control.game.KamikazeController;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.KamikazeEnemy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class KamikazeControllerTest {
    @Mock
    private KamikazeController kamikazeController;
    @Mock
    private KamikazeEnemy kamikazeEnemy;
    @BeforeEach
    public void setUp() {
        Position spaceshipPosition = new Position(2, 2);
        kamikazeEnemy = mock(KamikazeEnemy.class);
        kamikazeController = new KamikazeController(spaceshipPosition, kamikazeEnemy);
        when(kamikazeEnemy.getPosition()).thenReturn(new Position(3,3));
    }
    @Test
    public void testMove() {
        kamikazeEnemy = new KamikazeEnemy(0,0,0,0,0,0,true,0,0);
        Position spaceshipPosition = new Position(2, 2);
        kamikazeController = new KamikazeController(spaceshipPosition, kamikazeEnemy);

        kamikazeController.move();

        assertEquals( 1, kamikazeController.getKamikazeEnemy().getPosition().x);
        assertEquals( 1, kamikazeController.getKamikazeEnemy().getPosition().y);

        kamikazeController.move();

        assertEquals( 2, kamikazeController.getKamikazeEnemy().getPosition().x);
        assertEquals( 2, kamikazeController.getKamikazeEnemy().getPosition().y);

        kamikazeController.move();

        assertEquals( 2, kamikazeController.getKamikazeEnemy().getPosition().x);
        assertEquals( 2, kamikazeController.getKamikazeEnemy().getPosition().y);

        kamikazeController.move();

        assertEquals( 2, kamikazeController.getKamikazeEnemy().getPosition().x);
        assertEquals( 2, kamikazeController.getKamikazeEnemy().getPosition().y);

    }

    @Test
    public void testUpdate() {
        assertEquals(0, kamikazeController.getIterations());
        kamikazeController.update();
        assertEquals(1, kamikazeController.getIterations());
        kamikazeController.update();
        assertEquals(2, kamikazeController.getIterations());
        kamikazeController.update();
        assertEquals(3, kamikazeController.getIterations());
        kamikazeController.update();
        assertEquals(0, kamikazeController.getIterations());
    }

    //TODO test if the function is equal
}

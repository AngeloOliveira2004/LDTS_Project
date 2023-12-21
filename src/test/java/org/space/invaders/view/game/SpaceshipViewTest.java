package org.space.invaders.view.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.SpaceShip;

import static org.mockito.Mockito.*;

public class SpaceshipViewTest {

    @Mock
    private TextGraphics textGraphics;

    @Mock
    private SpaceShip spaceShip;
    private SpaceshipView spaceshipView;

    @Before
    public void setUp() {
        spaceshipView = new SpaceshipView(spaceShip, textGraphics);
    }

    @Test
    public void testNormalSpaceshipDraw() {
        when(spaceShip.isInvincible()).thenReturn(false);
        when(spaceShip.isMini()).thenReturn(false);
        when(spaceShip.getPosition()).thenReturn(new Position(10, 20));

        spaceshipView.draw();

        int expectedX = 10;
        int expectedY = 20;

        for (int i = 0; i < SpaceshipView.SpaceShipModel.length; i++) {
            verify(textGraphics, atLeastOnce()).setCharacter(expectedX, expectedY + i, any(TextCharacter.class));
        }
    }

    @Test
    public void testNormalInvincibleSpaceshipDraw() {
        when(spaceShip.isInvincible()).thenReturn(true);
        when(spaceShip.isMini()).thenReturn(false);
        when(spaceShip.getPosition()).thenReturn(new Position(10, 20));

        SpaceshipView spaceshipView = new SpaceshipView(spaceShip, textGraphics);


        spaceshipView.draw();

        int expectedX = 10;
        int expectedY = 20;

        for (int i = 0; i < SpaceshipView.InvincibleSpaceShipModel.length; i++) {
            verify(textGraphics, atLeastOnce()).setCharacter(expectedX, expectedY + i, any(TextCharacter.class));
        }
    }

    @Test
    public void testMiniSpaceShipDraw() {
        when(spaceShip.isInvincible()).thenReturn(false);
        when(spaceShip.isMini()).thenReturn(true);
        when(spaceShip.getPosition()).thenReturn(new Position(10, 20));
        spaceShip.toggleMini(true);
        SpaceshipView spaceshipView = new SpaceshipView(spaceShip, textGraphics);

        spaceshipView.draw();

        int expectedX = 10;
        int expectedY = 20;

        for (int i = 0; i < SpaceshipView.MiniSpaceShipModel.length; i++) {
            verify(textGraphics, atLeastOnce()).setCharacter(expectedX, expectedY + i, any(TextCharacter.class));
        }
    }

    @Test
    public void testMiniInvincibleSpaceShipDraw(){
        when(spaceShip.isInvincible()).thenReturn(true);
        when(spaceShip.isMini()).thenReturn(true);
        when(spaceShip.getPosition()).thenReturn(new Position(10, 20));
        spaceShip.toggleMini(true);
        SpaceshipView spaceshipView = new SpaceshipView(spaceShip, textGraphics);

        spaceshipView.draw();

        int expectedX = 10;
        int expectedY = 20;

        for (int i = 0; i < SpaceshipView.InvincibleMiniSpaceShipModel.length; i++) {
            verify(textGraphics, atLeastOnce()).setCharacter(expectedX, expectedY + i, any(TextCharacter.class));
        }
    }
}
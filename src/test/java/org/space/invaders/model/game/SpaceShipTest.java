package org.space.invaders.model.game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.Test;
import org.space.invaders.view.game.SpaceshipView;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class SpaceShipTest {

    @Test
    void testSetInvincible() {
        SpaceShip spaceShip = new SpaceShip(0, 0, 0, 0, 0, 0, true, 0, 0);

        assertFalse(spaceShip.isInvincible());
        spaceShip.setInvincible(true);
        assertTrue(spaceShip.isInvincible());
    }

    @Test
    void testToggleMini() {
        SpaceShip spaceShip = new SpaceShip(0, 0, 0, 0, 0, 0, true, 0, 0);

        assertFalse(spaceShip.isMini());
        spaceShip.toggleMini(true);
        assertTrue(spaceShip.isMini());
    }

    @Test
    void testDraw() throws IOException {
        TextGraphics textGraphicsMock = mock(TextGraphics.class);
        SpaceShip spaceShip = new SpaceShip(0, 0, 0, 0, 0, 0, true, 0, 0);

        spaceShip.draw(textGraphicsMock);

        verify(textGraphicsMock, times(368)).setBackgroundColor(any(TextColor.class));
    }

    @Test
    void testCalculateInvincibility() throws InterruptedException {
        SpaceShip spaceShip = new SpaceShip(0, 0, 0, 0, 0, 0, true, 0, 0);

        spaceShip.setInvincible(true);
        assertTrue(spaceShip.isInvincible());

        Thread.sleep(3000);

        spaceShip.calculateInvincibility();
        assertFalse(spaceShip.isInvincible());
    }

    @Test
    void getDesignTest(){
        TextGraphics textGraphicsMock = mock(TextGraphics.class);
        SpaceShip spaceShip = new SpaceShip(0, 0, 0, 0, 0, 0, true, 0, 0);
        SpaceshipView spaceshipView = new SpaceshipView(spaceShip,textGraphicsMock);
        spaceShip.setSpaceshipView(spaceshipView);
        spaceShip.getDesign();
        assertNotNull(spaceShip.getDesign());
    }
}

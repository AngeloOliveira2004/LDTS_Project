package org.space.invaders.control.game;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.Shot;
import org.space.invaders.model.game.elements.ShotElement;

import static org.mockito.Mockito.*;

public class ShotControllerTest {

    @Test
    public void testUpdate() {
        // Mock the ShotElement
        ShotElement mockShot = mock(ShotElement.class);
        when(mockShot.getXposition()).thenReturn(10); // replace with your desired X position
        when(mockShot.getYposition()).thenReturn(20); // replace with your desired Y position
        when(mockShot.getYVelocity()).thenReturn(2); // replace with your desired Y velocity

        // Create a ShotController with the mocked ShotElement
        ShotController shotController = new ShotController(mockShot);

        // Call the update method
        shotController.update();

        // Verify that the setPosition method is called with the expected Position argument
        verify(mockShot).setPosition(new Position(10, 18)); // Adjust the expected values based on your logic
        // Optionally, you can verify other interactions or make additional assertions based on your requirements.
    }
}

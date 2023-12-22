package org.space.invaders.view.game;

import net.jqwik.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.control.game.ShotController;
import org.space.invaders.model.Position;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.game.elements.Shot;
import org.space.invaders.view.game.ShotView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ShotViewTestJQWIK {

    @Mock
    private TextGraphics textGraphicsMock;

    @Mock
    private ShotController shotControllerMock;

    @Mock
    private Shot shot;

    @InjectMocks
    private ShotView shotView;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);

        shotView = new ShotView(textGraphicsMock ,shot);
        // Ensure that getGraphics() on the mocked ShotView returns a non-null TextGraphics
        when(shotView.getGraphics()).thenReturn(textGraphicsMock);
    }

    @Property
    void drawShouldUpdateControllerAndResetCount(@ForAll("validPositions") Position position,
                                                 @ForAll int yVelocity,
                                                 @ForAll int bool) {

        shot = createMockShot(position, yVelocity, bool);
        textGraphicsMock = mock(TextGraphics.class);
        shotControllerMock = mock(ShotController.class);
        shotView = new ShotView(textGraphicsMock , shot);
        shotView.setShotController(shotControllerMock);

        shotView.draw();

        verify(shotControllerMock, times(1)).update();
        verify(shot, times(1)).resetCount();
    }

    @Property
    void setPositionShouldUpdatePosition(@ForAll("validPositions") Position initialPosition,
                                         @ForAll("validPositions") Position newPosition,
                                         @ForAll int yVelocity,
                                         @ForAll int bool) {

        shot = createMockShot(newPosition, yVelocity, bool);
        textGraphicsMock = mock(TextGraphics.class);
        shotControllerMock = mock(ShotController.class);
        shotView = new ShotView(textGraphicsMock , shot);
        shotView.setPosition(newPosition);
        assertEquals(newPosition, shot.getPosition());  // Use assertEquals for comparing objects
    }

    private Shot createMockShot(Position position, int yVelocity, int bool) {
        Shot shotMock = mock(Shot.class);
        when(shotMock.getPosition()).thenReturn(position);
        when(shotMock.getYVelocity()).thenReturn(yVelocity);
        // Add any other necessary stubbing for the Shot class
        return shotMock;
    }

    @Provide
    Arbitrary<Position> validPositions() {
        Arbitrary<Integer> xValues = Arbitraries.integers().between(0, 600);
        Arbitrary<Integer> yValues = Arbitraries.integers().between(0, 300);

        return Combinators.combine(xValues, yValues)
                .as(Position::new);
    }
}

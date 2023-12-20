package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import org.space.invaders.view.game.ShotView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ShotTest {

    @InjectMocks
    private Shot shot;

    @Mock
    private TextGraphics textGraphics;

    @Mock
    private ShotView shotView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.shot = new Shot(new Position(0,0),2,2);
    }

    @Test
    void testDraw(){
        shot.addCount();
        shot.draw(textGraphics);
        assertEquals(shot.getCount(),0);
    }

    @Test
    void testAddCount() {
        shot.addCount();
        assertEquals(1, shot.getCount());
    }

    @Test
    void testResetCount() {
        shot.addCount();
        shot.resetCount();
        assertEquals(0, shot.getCount());
    }

    @Test
    void testGetCount() {
        int count = shot.getCount();
        assertEquals(0, count);
    }
}

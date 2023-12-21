package org.space.invaders.view.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.UI.Lifes;
import org.space.invaders.view.game.LifesView;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class LifesViewTest {

    @Mock
    private TextGraphics textGraphics;

    @Mock
    private Lifes lifes;
    @Mock
    private Position position;
    private LifesView lifesView;

    @BeforeEach
    public void setUp() {
        lifesView = new LifesView(lifes, textGraphics);
        position = new Position(500, 295);
    }
    @Test
    public void testActualDraw() {
        String[] model = LifesView.timeString;
        int lifeStringValue = 3;

        lifesView.actualDraw(position, model, lifeStringValue);


        for (int i = 0; i < LifesView.timeString.length; i++) {
            verify(textGraphics, atLeastOnce()).setCharacter(position.getX(), position.getY() + i, any(TextCharacter.class));
        }

        for (int i = 0; i < 3; i++) {
            verify(textGraphics, atLeastOnce()).setCharacter(position.getX() + i * 8, position.getY(), any(TextCharacter.class));
        }

    }
}

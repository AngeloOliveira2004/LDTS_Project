package org.space.invaders.view.menu;

import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.menu.LeaderboardModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.mockito.Mockito.*;

class LeaderboardViewTest {

    @Mock
    private LeaderboardModel mockModel;

    @Mock
    private Screen mockScreen;

    @Mock
    private MenuGUI mockGui;

    private LeaderboardView leaderboardView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        leaderboardView = new LeaderboardView(mockModel, mockScreen);
    }

    @Test
    void testDrawLeaderboard() throws IOException {
        Path tempFilePath = Files.createTempFile("leaderboard", ".txt");
        try (PrintWriter writer = new PrintWriter(tempFilePath.toFile())) {
            writer.println("100,Player1");
            writer.println("90,Player2");
            writer.println("80,Player3");
        }

        when(mockModel.getNumberOptions()).thenReturn(1);
        when(mockModel.getOption(0)).thenReturn(tempFilePath.toString());

        leaderboardView.drawLeaderboard(mockGui);

        verify(mockGui, times(5)).drawText(any(), anyString(), anyString(), anyString());

        Files.delete(tempFilePath);
    }

    @Test
    void testDrawElements() {
        leaderboardView.drawElements(mockGui);

        verify(mockGui).drawText(new Position(16, 3), "L E A D E R B O A R D", "#008000", "BLINK");
    }
}

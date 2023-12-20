package org.space.invaders.model.game.menu;

import org.junit.jupiter.api.Test;
import org.space.invaders.states.ApplicationState;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LeaderboardModelTest {

    @Test
    void testDefaultConstructor() {
        LeaderboardModel leaderboardModel = new LeaderboardModel();
        assertEquals(ApplicationState.MainMenu, leaderboardModel.validateApplicationState());
        assertEquals(1, leaderboardModel.getNumberOptions());
        assertEquals("Back to Menu", leaderboardModel.getOption(0));
    }

    @Test
    void testCustomConstructor() {
        List<String> customOptions = Arrays.asList("Option1", "Option2", "Option3");
        LeaderboardModel leaderboardModel = new LeaderboardModel(customOptions);
        assertEquals(ApplicationState.MainMenu, leaderboardModel.validateApplicationState());
        assertEquals(3, leaderboardModel.getNumberOptions());
        assertEquals("Option1", leaderboardModel.getOption(0));
        assertEquals("Option2", leaderboardModel.getOption(1));
        assertEquals("Option3", leaderboardModel.getOption(2));
    }


}

package org.space.invaders.model.game.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.space.invaders.states.ApplicationState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    private static final List<String> OPTIONS = Arrays.asList("Option1", "Option2", "Option3");
    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new MockMenu(OPTIONS);
    }

    @Test
    void testNextOption() {
        menu.nextOption();
        assertEquals("Option2", menu.getCurrentOption());
        menu.nextOption();
        assertEquals("Option3", menu.getCurrentOption());
    }

    @Test
    void testPreviousOption() {
        menu.previousOption();
        assertEquals("Option3", menu.getCurrentOption());
        menu.previousOption();
        assertEquals("Option2", menu.getCurrentOption());
    }

    @Test
    void testGetCurrentOption() {
        assertEquals("Option1", menu.getCurrentOption());
    }

    @Test
    void testIsSelected() {
        assertTrue(menu.isSelected("Option1"));
        assertFalse(menu.isSelected("Option2"));

        menu.nextOption();
        assertFalse(menu.isSelected("Option1"));
        assertTrue(menu.isSelected("Option2"));
    }

    @Test
    void testGetNumberOptions() {
        assertEquals(3, menu.getNumberOptions());
    }

    @Test
    void testSetCurrentOption() {
        menu.setCurrentOption();
        assertEquals("Option2", menu.getCurrentOption());

        menu.setCurrentOption();
        menu.setCurrentOption();
        assertEquals("Option1", menu.getCurrentOption());
    }

    @Test
    void testGetOptionIndex() {
        assertEquals(0, menu.getOptionIndex());

        menu.nextOption();
        assertEquals(1, menu.getOptionIndex());
    }

    @Test
    void testGetOption() {
        assertEquals("Option1", menu.getOption(0));
        assertEquals("Option2", menu.getOption(1));
        assertEquals("Option3", menu.getOption(2));
        assertThrows(IndexOutOfBoundsException.class, () -> menu.getOption(3));
    }

    @Test
    void testAddMenuOptions() {
        menu.addMenuOptions("Option4");
        assertEquals(4, menu.getNumberOptions());
    }

    private static class MockMenu extends Menu {
        public MockMenu(List<String> menuOptions) {
            super(new ArrayList<>());
            addMenuOptions("Option1");
            addMenuOptions("Option2");
            addMenuOptions("Option3");
        }

        @Override
        public ApplicationState validateApplicationState() {
            return null;
        }
    }
}

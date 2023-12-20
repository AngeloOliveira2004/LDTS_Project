package org.space.invaders.model.game.UI;

import org.junit.jupiter.api.Test;
import org.space.invaders.model.game.UI.NumberEnum;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NumberEnumTest {

    @Test
    void testGetDesignForZero() {
        String[] expectedDesign = {
                "ggggg",
                "gg gg",
                "gg gg",
                "gg gg",
                "ggggg"
        };
        assertArrayEquals(expectedDesign, NumberEnum.ZERO.getDesign());
    }

    @Test
    void testGetDesignForOne() {
        String[] expectedDesign = {
                "   gg",
                " gggg",
                "g ggg",
                "  ggg",
                "  ggg"
        };
        assertArrayEquals(expectedDesign, NumberEnum.ONE.getDesign());
    }

    @Test
    void testGetDesignForTwo() {
        String[] expectedDesign = {
                "ggggg",
                "   gg",
                "ggggg",
                "gg   ",
                "ggggg"
        };
        assertArrayEquals(expectedDesign, NumberEnum.TWO.getDesign());
    }

    @Test
    void testGetDesignForThree() {
        String[] expectedDesign = {
                "ggggg",
                "   gg",
                "ggggg",
                "   gg",
                "ggggg"
        };
        assertArrayEquals(expectedDesign, NumberEnum.THREE.getDesign());
    }

    @Test
    void testGetDesignForFour() {
        String[] expectedDesign = {
                "gg gg",
                "gg gg",
                "ggggg",
                "   gg",
                "   gg"
        };
        assertArrayEquals(expectedDesign, NumberEnum.FOUR.getDesign());
    }

    @Test
    void testGetDesignForFive() {
        String[] expectedDesign = {
                "ggggg",
                "gg   ",
                "ggggg",
                "   gg",
                "ggggg"
        };
        assertArrayEquals(expectedDesign, NumberEnum.FIVE.getDesign());
    }

    @Test
    void testGetDesignForSix() {
        String[] expectedDesign = {
                "ggggg",
                "gg   ",
                "ggggg",
                "gg gg",
                "ggggg"
        };
        assertArrayEquals(expectedDesign, NumberEnum.SIX.getDesign());
    }

    @Test
    void testGetDesignForSeven() {
        String[] expectedDesign = {
                "ggggg",
                "   gg",
                "  gg ",
                " gg  ",
                "gg   "
        };
        assertArrayEquals(expectedDesign, NumberEnum.SEVEN.getDesign());
    }

    @Test
    void testGetDesignForEight() {
        String[] expectedDesign = {
                "ggggg",
                "gg gg",
                "ggggg",
                "gg gg",
                "ggggg"
        };
        assertArrayEquals(expectedDesign, NumberEnum.EIGHT.getDesign());
    }

    @Test
    void testGetDesignForNine() {
        String[] expectedDesign = {
                "ggggg",
                "gg gg",
                "ggggg",
                "   gg",
                "ggggg"
        };
        assertArrayEquals(expectedDesign, NumberEnum.NINE.getDesign());
    }

}

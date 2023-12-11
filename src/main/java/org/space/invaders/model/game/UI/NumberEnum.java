package org.space.invaders.model.game.UI;

public enum NumberEnum {
    ZERO(new String[]{
            "ggggg",
            "gg gg",
            "gg gg",
            "gg gg",
            "ggggg"
    }),

    ONE(new String[]{
            "   gg",
            " gggg",
            "g ggg",
            "  ggg",
            "  ggg"
    }),

    TWO(new String[]{
            "ggggg",
            "   gg",
            "ggggg",
            "gg   ",
            "ggggg"
    }),

    THREE(new String[]{
            "ggggg",
            "   gg",
            "ggggg",
            "   gg",
            "ggggg"
    }),

    FOUR(new String[]{
            "gg gg",
            "gg gg",
            "ggggg",
            "   gg",
            "   gg"
    }),

    FIVE(new String[]{
            "ggggg",
            "gg   ",
            "ggggg",
            "   gg",
            "ggggg"
    }),

    SIX(new String[]{
            "ggggg",
            "gg   ",
            "ggggg",
            "gg gg",
            "ggggg"
    }),

    SEVEN(new String[]{
            "ggggg",
            "   gg",
            "  gg ",
            " gg  ",
            "gg   "
    }),

    EIGHT(new String[]{
            "ggggg",
            "gg gg",
            "ggggg",
            "gg gg",
            "ggggg"
    }),

    NINE(new String[]{
            "ggggg",
            "gg gg",
            "ggggg",
            "   gg",
            "ggggg"
    });

    private final String[] designNum;

    NumberEnum(String[] design) {
        this.designNum = design;
    }

    public String[] getDesign() {
        return designNum;
    }
}

package org.space.invaders.view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.DefaultEnemy;
import org.space.invaders.model.game.elements.Planet;

import java.io.IOException;
import java.util.ArrayList;

public class PlanetView extends View{

    private Planet planet;
    private static final int CHAR_HEIGHT = 2;
    private static final int CHAR_WIDTH = 2;

    private static final String[] planetModel = new String[]{
            "     bbbbbb     ",
            "   GGbbbbbbAG   ",
            "  AbbbGGbbbbGG  ",
            " AbbGbbGGbbbGbA ",
            " AbGGGGbbbbbbGA ",
            "AbGGGGGbbbbbGGGG",
            "AbGGGbbbbbbbGGGG",
            "AAbGGbbbbbbbbGGG",
            "AAbbGbGGbbbbbbbG",
            "AAAbbGGGGGbbbbbG",
            "AAAbbGGGGGbbbbGG",
            " AAbbGGGGbbbbbG ",
            " AAbbbGGGbbbbbb ",
            "  AAbbGGbbbbbb  ",
            "   AAbGbbbbbb   ",
            "     bbbbbb     ",
    };

    public PlanetView(Planet planet, TextGraphics textGraphics) {
        super(CHAR_WIDTH, CHAR_HEIGHT, textGraphics);
        this.planet = planet;
    }

    @Override
    public void draw() throws IOException {
        ArrayList<Position> positions = new ArrayList<>();
        int x = (int) planet.getPosition().getX();
        int y = (int) planet.getPosition().getY();
        drawImage(planetModel, x, y,positions);
        planet.setOccupiedPositions(positions);
    }

    public String[] getDesign() {
        return planetModel;
    }

    }

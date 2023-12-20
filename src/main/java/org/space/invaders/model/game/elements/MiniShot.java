package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;
import org.space.invaders.view.game.MiniShotView;
import org.space.invaders.view.game.ShotView;

import java.io.IOException;

import static org.space.invaders.Constants.HEIGHT;
import static org.space.invaders.Constants.WIDTH;

public class MiniShot extends ShotElement{
    public static int RANGE = 50;
    private MiniShotView miniShotView;
    private final Position initialPosition;
    public MiniShot(Position position, int yVelocity) {
        super(position, yVelocity,2);
        initialPosition = position;
    }

    public MiniShot() {
        super(new Position(0,0), 0,2);
        initialPosition = new Position(0,0);
    }

    @Override
    public void draw(TextGraphics textGraphics) throws IOException {
        miniShotView = new MiniShotView(textGraphics , this);
        miniShotView.draw();
    }
    @Override
    public boolean isInsideBorders(){
        return (getPosition().x > 0 && getPosition().x < WIDTH && getPosition().y > 0 && getPosition().y < HEIGHT && this.getYposition() > initialPosition.getY() - RANGE);
    }

    public void setMiniShotView(MiniShotView miniShotView) {
        this.miniShotView = miniShotView;
    }
}
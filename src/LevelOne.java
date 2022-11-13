//Yuval Avikassis 209329234
import biuoop.DrawSurface;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the first level.
 */
public class LevelOne implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        Velocity velocity = new Velocity(5, 5);
        velocities.add(velocity);
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.black);
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(Color.BLUE);
                d.drawCircle(400, 170, 40);
                d.drawCircle(400, 170, 65);
                d.drawCircle(400, 170, 90);
                d.fillRectangle(270, 170, 270, 2);
                d.fillRectangle(400, 40, 2, 270);
            }

            @Override
            public void timePassed() {
            }
        };
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Block theOnly = new Block(new Rectangle(new Point(380, 150), 40, 40), Color.red);
        blocks.add(theOnly);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}

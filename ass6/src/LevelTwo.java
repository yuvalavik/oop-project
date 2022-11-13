//Yuval Avikassis 209329234.
import biuoop.DrawSurface;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 2.
 */
public class LevelTwo implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Velocity velocity = new Velocity(6, 6);
            velocities.add(velocity);
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 500;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {

        return new Sprite() {

            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.lightGray);
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(Color.orange);
                d.fillCircle(150, 135, 40);
                for (int i = 0; i < 80; i++) {
                  d.drawLine(115 + i, 135, 25 + 8 * i, 230);
                }
                d.setColor(Color.YELLOW);
                d.fillCircle(150, 135, 30);
            }

            @Override
            public void timePassed() {

            }
        };
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Block block = new Block(new Rectangle(new Point(25 + i * 50, 230),
                    50, 25), Color.red);
            blocks.add(block);
        }
        for (int i = 0; i < 2; i++) {
            Block block = new Block(new Rectangle(new Point(125 + i * 50, 230),
                    50, 25), Color.orange);
            blocks.add(block);
        }
        for (int i = 0; i < 2; i++) {
            Block block = new Block(new Rectangle(new Point(225 + i * 50, 230),
                    50, 25), Color.yellow);
            blocks.add(block);
        }
        for (int i = 0; i < 3; i++) {
            Block block = new Block(new Rectangle(new Point(325 + i * 50, 230),
                    50, 25), Color.green);
            blocks.add(block);
        }
        for (int i = 0; i < 2; i++) {
            Block block = new Block(new Rectangle(new Point(475 + i * 50, 230),
                    50, 25), Color.blue);
            blocks.add(block);
        }
        for (int i = 0; i < 2; i++) {
            Block block = new Block(new Rectangle(new Point(575 + i * 50, 230),
                    50, 25), Color.pink);
            blocks.add(block);
        }
        for (int i = 0; i < 2; i++) {
            Block block = new Block(new Rectangle(new Point(675 + i * 50, 230),
                    50, 25), Color.CYAN);
            blocks.add(block);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}

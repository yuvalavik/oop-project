// Yuval Avikassis 209329234.
import biuoop.DrawSurface;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 3.
 */
public class LevelThree implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Velocity velocity = new Velocity(5, 5);
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
        return 100;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {

            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(0, 80, 0));
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(new Color(26, 17, 16));
                d.fillRectangle(60, 430, 130, 170);
                d.setColor(new Color(245, 245, 220));
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        d.fillRectangle(74 + j * 22, 445 + i * 30, 15, 25);
                    }

                }
                d.setColor(new Color(52, 52, 52));
                d.fillRectangle(110, 385, 30, 45);
                d.setColor(new Color(85, 85, 85));
                d.fillRectangle(120, 235, 10, 150);
                d.setColor(new Color(252, 255, 164));
                d.fillCircle(125, 230, 10);
                d.setColor(Color.red);
                d.fillCircle(125, 230, 6);
                d.setColor(Color.white);
                d.fillCircle(125, 230, 3);
            }

            @Override
            public void timePassed() {

            }
        };
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Point uppLeft = new Point(775, 250);
        Color[] arrCol = {Color.white, Color.blue, Color.yellow, Color.red, Color.GRAY};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 6; j++) {
                Point temp1 = new Point(uppLeft.getX() - (j + 1) * 50, uppLeft.getY());
                Block temp = new Block(new Rectangle(temp1, 50, 25), arrCol[i]);
                blocks.add(temp);
            }
            uppLeft = new Point(775, uppLeft.getY() - 25);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
}

//Yuval Avikassis 209329234.
import biuoop.DrawSurface;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class LevelFour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Velocity velocity = new Velocity(5, -5);
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {

            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(0, 128, 255));
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(Color.red);
                d.fillCircle(400, 750, 400);
                d.setColor(Color.ORANGE);
                d.fillCircle(400, 750, 375);
                d.setColor(Color.yellow);
                d.fillCircle(400, 750, 350);
                d.setColor(Color.green);
                d.fillCircle(400, 750, 325);
                d.setColor(Color.blue);
                d.fillCircle(400, 750, 300);
                d.setColor(Color.pink);
                d.fillCircle(400, 750, 275);
                d.setColor(new Color(148, 0, 211));
                d.fillCircle(400, 750, 250);
                d.setColor(new Color(0, 128, 255));
                d.fillCircle(400, 750, 225);


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
        Color[] arrCol = {Color.cyan, Color.pink, Color.white, Color.green, Color.yellow, Color.red, Color.GRAY};
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 15; j++) {
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
        return 105;
    }
}

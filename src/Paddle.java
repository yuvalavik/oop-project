// Yuval Avikassis 209329234.
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;
import geometryprimitives.Line;

public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Block paddle;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BORDER_SIZE = 25;
    private static final double MOVEMENT = 5;
    private static final double PADDLE_HEIGHT = 20;

    /**
     * a constructor.
     * @param rect of the paddle.
     * @param color of the paddle.
     * @param key for the paddle.
     */
    public Paddle(Rectangle rect, Color color, KeyboardSensor key) {
        this.paddle = new Block(rect, color);
        this.keyboard = key;
    }

    /**
     * move the puddle to the left.
     */
    public void moveLeft() {
        Rectangle surf = this.getCollisionRectangle();
        if (surf.getUpperLeft().getX() - MOVEMENT < BORDER_SIZE) { // if it will get out the borders
            this.paddle.getCollisionRectangle().setUpperLeft(new Point(BORDER_SIZE,
                    HEIGHT - BORDER_SIZE - PADDLE_HEIGHT));
        } else {
            this.paddle.getCollisionRectangle().setUpperLeft(new Point(surf.getUpperLeft().getX() - MOVEMENT,
                    HEIGHT - BORDER_SIZE - PADDLE_HEIGHT));
        }
    }

    /**
     * move the paddle to the right.
     */
    public void moveRight() {
        Rectangle surf = this.getCollisionRectangle();
        if (surf.getUpperLeft().getX() + this.paddle.getCollisionRectangle().getWidth()
                + MOVEMENT > WIDTH - BORDER_SIZE) {
            // if it will get out the borders
            this.paddle.getCollisionRectangle().setUpperLeft(new Point(WIDTH - BORDER_SIZE
                    - this.paddle.getCollisionRectangle().getWidth(),
                    HEIGHT - BORDER_SIZE - PADDLE_HEIGHT));
        } else {
            this.paddle.getCollisionRectangle().setUpperLeft(new Point(surf.getUpperLeft().getX() + MOVEMENT,
                    HEIGHT - BORDER_SIZE - PADDLE_HEIGHT));
        }

    }

    /**
     * notify the paddle how to move according the time.
     */
    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * drawing the paddle.
     * @param d draw the paddle.
     */
    @Override
    public void drawOn(DrawSurface d) {
        this.paddle.drawOn(d);
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.paddle.getCollisionRectangle();
    }
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Rectangle surface = this.getCollisionRectangle();
        Point start = surface.getUpperLeft();
        Point end = new Point(surface.getUpperLeft().getX() + surface.getWidth(), surface.getUpperLeft().getY());
        Line paddleTop = new Line(start, end);
        if (!paddleTop.pointOnLine(collisionPoint)) {
            return this.paddle.hit(hitter, collisionPoint, currentVelocity);
        }

        // if the ball hits the paddle top, changing its direction depending on where it hit
        double zero = start.getX(), sectionLength = paddleTop.length() / 5, x = collisionPoint.getX() - zero;
        int sectionIndex = (int) (x / sectionLength);
        double angle = (300 + sectionIndex * 30) % 360;
        if (angle == 0) { // if the ball hit the center of the paddle top the impact was defined to be as a block's
            Velocity newVelocity = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
            return newVelocity;
        }
        return Velocity.fromAngleAndSpeed(angle, currentVelocity.getSpeed());
    }


    /**
     * Add this paddle to the game.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
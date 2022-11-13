//209329234 Yuval Avikassis.

import biuoop.DrawSurface;
import geometryprimitives.Line;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;

import java.awt.Color;

/**
 * class of a Ball.
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private final java.awt.Color color;
    private Velocity ballVel;
    private GameEnvironment environment;

    /**
     * set the ball game environment.
     *
     * @param gameEnvironment of the game.
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.environment = gameEnvironment;
    }

    /**
     * constructor of a Ball that gets Characteristics of the ball and define the Ball.
     *
     * @param center of point that is the center of the ball.
     * @param r      of int that is the size of the Ball.
     * @param color  that is the color of the Ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.ballVel = new Velocity(0, 0);
    }

    /**
     * constructor of a Ball that gets Characteristics of the ball and define the Ball.
     *
     * @param x     of double that is the x of the center Point of the ball.
     * @param y     of double that is the y of the center Point of the ball.
     * @param r     of int that is the size of the Ball.
     * @param color that is the color of the Ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.ballVel = new Velocity(0, 0);
    }

    /**
     * this function return the x of the Point of the center.
     *
     * @return the x of the Point of the center.
     */
    public double getX() {
        return (int) center.getX();
    }

    /**
     * this function return the y of the Point of the Ball center.
     *
     * @return the y of the Point of the Ball center.
     */
    public double getY() {
        return (int) center.getY();
    }

    /**
     * this function return the size of the Ball.
     *
     * @return the size of the Ball.
     */
    public int getSize() {
        return r;
    }

    /**
     * this function return the color of the Ball.
     *
     * @return the function of the Ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * this function draw the ball on the given DrawSurface.
     *
     * @param surface of the Ball.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.getX(), (int) this.getY(), r);
        surface.setColor(Color.black);
        surface.drawCircle((int) this.getX(), (int) this.getY(), r);
    }

    /**
     * this function set the center of the ball.
     *
     * @param x of double of the center Point.
     * @param y of double of the center Point.
     */
    public void setCenter(double x, double y) {
        this.center = new Point(x, y);
    }

    /**
     * this function gets velocity and set the ball velocity.
     *
     * @param v of Velocity to set the Ball.
     */
    public void setVelocity(Velocity v) {
        this.ballVel = v;
    }

    /**
     * this function set the velocity of the Ball.
     *
     * @param dx of double for the velocity.
     * @param dy of double for the velocity.
     */
    public void setVelocity(double dx, double dy) {
        this.ballVel = new Velocity(dx, dy);
    }

    /**
     * this function return the Ball velocity.
     *
     * @return the Ball velocity.
     */
    public Velocity getVelocity() {
        return ballVel;
    }

    /**
     * this function define how the ball move in the frame.
     */
    public void moveOneStep() {
        Line trajectory = new Line(this.center, this.ballVel.applyToPoint(this.center));
        CollisionInfo col = this.environment.getClosestCollision(trajectory);
        if (col == null) {
            getOut();
            this.center = this.ballVel.applyToPoint(this.center);
        } else {
            this.ballVel = col.collisionObject().hit(this, col.collisionPoint(), this.ballVel);
            Line[] lines = col.collisionObject().getCollisionRectangle().sizes();
            // making the ball almost hit.
            if (lines[0].pointOnLine(col.collisionPoint())) {
                this.center = new Point(col.collisionPoint().getX(), col.collisionPoint().getY() - 1);
            }
            if (lines[1].pointOnLine(col.collisionPoint())) {
                this.center = new Point(col.collisionPoint().getX() - 1, col.collisionPoint().getY());
            }
            if (lines[2].pointOnLine(col.collisionPoint())) {
                this.center = new Point(col.collisionPoint().getX(), col.collisionPoint().getY() + 1);
            }
            if (lines[3].pointOnLine(col.collisionPoint())) {
                this.center = new Point(col.collisionPoint().getX() + 1, col.collisionPoint().getY());
            }
        }
    }
  /**
     * notify the ball about the time by his movement.
     */
    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * adding the ball to the game.
     *
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * get out the paddle.
     */
    public void getOut() {
        Rectangle pad = this.environment.getPaD();
        double xPoint = this.getX(), yPoint = this.getY();
        double leftDis = center.distance(pad.getUpperLeft());
        double xRight = pad.getUpperLeft().getX() + pad.getWidth();
        double rightDis = center.distance(new Point(xRight, pad.getUpperLeft().getY()));
        if (this.center.inRec(pad)) {
           if (rightDis > leftDis) {
               this.center = new Point(pad.getUpperLeft().getX() - 5, pad.getUpperLeft().getY());
           } else if (rightDis < leftDis) {
               this.center = new Point(xRight + 3, pad.getUpperLeft().getY());
               this.ballVel = new Velocity(-ballVel.getDx(), -ballVel.getDy());
           }
        }
    }
    /**
     * remove the object.
     * @param game the game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}



//209329234 Yuval Avikassis.
import geometryprimitives.Point;
/**
 * class of velocity.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor that gets dx and dy for the velocity.
     *
     * @param dx of double of the velocity.
     * @param dy of double of the velocity.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * function to get the dx.
     *
     * @return dx of double of the velocity.
     */
    public double getDx() {
        return dx;
    }

    /**
     * function to get the dy.
     *
     * @return dy of double of the velocity.
     */
    public double getDy() {
        return dy;
    }

    /**
     * this function get speed and angle and calculate the dx and the dy.
     *
     * @param angle of the velocity of the ball.
     * @param speed of the ball.
     * @return the new velocity by dx and dy.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = speed * -Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }

    /**
     * Take a point with position (x,y) and return a new point  with position (x+dx, y+dy).
     *
     * @param p of point of the ball.
     * @return new point after calculating with dx and dy.
     */
    public Point applyToPoint(Point p) {
        return new Point(dx + p.getX(), dy + p.getY());
    }

    /**
     *  calculate the speed.
     * @return the speed.
     */
    public double getSpeed() {
        return Math.sqrt(Math.pow(this.getDx(), 2) + Math.pow(this.getDy(), 2));
    }
}

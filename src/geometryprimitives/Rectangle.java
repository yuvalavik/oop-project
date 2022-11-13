// Yuval Avikassis 209329234.
package geometryprimitives;
import java.util.ArrayList;
import java.util.List;


public class Rectangle {
    private Point upperLeft;
    private final double width;
    private final double height;
    private Point upperRight;
    private Point downLeft;
    private Point downRight;

    /**
     * Create a new rectangle with location and width/height.
     * @param upperLeft the upper left point.
     * @param width the width.
     * @param height the height.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;

    }
    /**
     * arr of the lines of the rectangle.
     * @return arr of the lines of the rectangle.
     */
    public Line[] sizes() {
        this.upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        this.downLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        this.downRight = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        Line[] sides = new Line[4];
        sides[0] = new Line(upperLeft, upperRight);
        sides[1] = new Line(upperLeft, downLeft);
        sides[2] = new Line(downLeft, downRight);
        sides[3] = new Line(upperRight, downRight);
        return sides;
    }

    /**
     *  get the down right point.
     * @return point.
     */
    public Point getDownRight() {
        return downRight;
    }

    /**
     * set the left up point.
     * @param up point.
     */
    public void setUpperLeft(Point up) {
        this.upperLeft = up; }



    /**
     * Return a (possibly empty) List of intersection points
     * with the specified line.
     * @param line line we want to check.
     * @return intersection points with the line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        Line[] rectangleSides = this.sizes();
        List<Point> intersectionPoints = new ArrayList<Point>();
        Point hitPoint;
        for (int i = 0; i < 4; i++) {
            hitPoint = rectangleSides[i].intersectionWith(line);
            if (hitPoint != null) {
                intersectionPoints.add(hitPoint);
            }
        }
        return intersectionPoints;
    }

    /**
     * Return the width of the rectangle.
     * @return width.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Return the  height of the rectangle.
     * @return the height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returns the upper-left point of the rectangle.
     * @return up point.
     */
    public Point getUpperLeft() {
        return this.upperLeft; }

}
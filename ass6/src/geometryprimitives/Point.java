//209329234 Yuval Avikassis.
package geometryprimitives;
import java.util.ArrayList;
import java.util.List;


/**
 * class of a Point.
 */
public class Point {
    private final double x;
    private final double y;
    static final double ERROR = Math.pow(10, -10);

    /**
     * constructor that gets 2 numbers and define the x and the y of the new point.
     *
     * @param x of double that we want to define as the x of the point.
     * @param y of double that we want to define as the y of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This function gets 2 Points and calculate the distance between them.
     *
     * @param other of Point that we want to find the distance from her.
     * @return the distance between the 2 Points.
     */
    public double distance(Point other) {
        double temp1 = ((this.x - other.x) * (this.x - other.x));
        double temp2 = ((this.y - other.y) * (this.y - other.y));
        return Math.sqrt(temp1 + temp2);
    }

    /**
     * This function gets 2 Points and check if they are equal.
     *
     * @param other of Point that we want to find the distance from her.
     * @return true if they are the same Points and false if not.
     */
    public boolean equals(Point other) {
        return Math.abs(this.x - other.getX()) < ERROR && Math.abs(this.y - other.getY()) < ERROR;
    }

    /**
     * This function return the x value of the Point.
     *
     * @return x value of the point.
     */
    public double getX() {
        return x;
    }

    /**
     * This function return the y value of the Point.
     *
     * @return y value of the point.
     */
    public double getY() {
        return y;
    }

    /**
     * checking if point in the rec.
     * @param rect the rect
     * @return true or false.
     */
    public boolean inRec(Rectangle rect) {
        double x = this.x;
        double y = this.y;
        return rect.getUpperLeft().getX() <= x && x <= rect.getUpperLeft().getX() + rect.getWidth()
                && rect.getUpperLeft().getY() <= y && y <= rect.getUpperLeft().getY() + rect.getHeight();
    }

    /**
     * checking the closest point from the list to our point.
     * @param pointList list of points.
     * @return the closest point.
     */
    public Point closest(List<Point> pointList) {
        if (pointList == null || pointList.size() == 0) {
            return null;
        }
        double length = pointList.size();
        List<Double> distances = new ArrayList<Double>();
        for (int i = 0; i < length; i++) {
            if (pointList.get(i) != null) {
                distances.add(pointList.indexOf(pointList.get(i)), this.distance(pointList.get(i)));
            }
        }
        int min = 0;
        for (int i = 1; i < distances.size(); i++) {
            if (distances.get(i) < distances.get(min)) {
                min = i;
            }
        }
        return pointList.get(min);
    }

}

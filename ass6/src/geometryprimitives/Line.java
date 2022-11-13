//209329234 Yuval Avikassis.
package geometryprimitives;

/**
 * class of a Line.
 */
public class Line {
    private final Point start;
    private final Point end;
    static final double ERROR = Math.pow(10, -10);

    /**
     * constructor that gets 2 Points and define the start and the end of the new line.
     *
     * @param start of Point that we want to define as the start of the Line.
     * @param end   of Point that we want to define as the end of the Line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * constructor that gets 4 numbers and define the start Point and the end Point of the new line.
     *
     * @param x1 of double that we want to define as the x of the Point that start the Line.
     * @param y1 of double that we want to define as the y of the Point that start the Line.
     * @param x2 of double that we want to define as the x of the Point that end the Line.
     * @param y2 of double that we want to define as the y of the Point that end the Line.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * This function return the length of the line.
     *
     * @return the length of the LIne.
     */
    public double length() {
        return end.distance(start);
    }

    /**
     * This function return the middle Point of the line.
     *
     * @return the middle Point of the Line.
     */
    public Point middle() {
        double midX = (this.start.getX() + this.end.getX()) / 2;
        double midY = (this.start.getY() + this.end.getY()) / 2;
        return new Point(midX, midY);
    }

    /**
     * This function gets 2 Points and calculate the slope of the Line between them.
     *
     * @param start of Point of the Line.
     * @param end   of Point of the Line.
     * @return the slope of the Line.
     */
    public double slope(Point start, Point end) {
        double tempY = start.getY() - end.getY();
        double tempX = start.getX() - end.getX();
        double sum = tempY / tempX;
        if (sum == Double.NEGATIVE_INFINITY) {
            sum = Double.POSITIVE_INFINITY;
        }

        return sum;
    }

    /**
     * This function return the start Point of the Line.
     *
     * @return the start Point of the Line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * This function return the end Point of the Line.
     *
     * @return the end Point of the Line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * This function gets 2 Points and calculate the y intercept of the Line between them.
     *
     * @param start of Point of the Line.
     * @param end   of Point of the Line.
     * @return the y intercept of the Line.
     */
    public double yIntercept(Point start, Point end) {
        double slope1 = slope(start, end);
        return start.getY() - slope1 * start.getX();
    }

    /**
     * This function gets Line and check if it is intersecting with the other.
     *
     * @param other of Line that we want to check if it is intersecting.
     * @return true if they are intersecting and false if not.
     */
    public boolean isIntersecting(Line other) {
        double maxY1 = Math.max(this.start.getY(), this.end.getY());
        double minY1 = Math.min(this.start.getY(), this.end.getY());
        double maxY2 = Math.max(other.start.getY(), other.end.getY());
        double minY2 = Math.min(other.start.getY(), other.end.getY());
        double minThisX = Math.min(this.start.getX(), this.end.getX());
        double maxThisX = Math.max(this.start.getX(), this.end.getX());
        double minOtherX = Math.min(other.start.getX(), other.end.getX());
        double maxOtherX = Math.max(other.start.getX(), other.end.getX());
        // checks if 2 lines are vertical.
        if (Math.abs(other.start.getX() - other.end.getX()) < ERROR && Math.abs(this.start.getX()
                - this.end.getX()) < ERROR) {
            // if one of them has different x value than the other.
            if (other.end.getX() != this.end.getX()) {
                return false;
            }
            return !(maxY1 < minY2) && !(maxY2 < minY1);
        }
        // checks if just one line is vertical and the other is not.
        if (Math.abs(other.start.getX() - other.end.getX()) < ERROR) {
            double inter = slope(this.start, this.end) * other.end.getX() + yIntercept(this.start, this.end);
            if (maxThisX < other.start.getX() || other.start.getX() < minThisX) {
                return false;
            }
            return minY2 <= inter && inter <= maxY2;
        }
        // checks if just one line is vertical and the other is not.
        if (Math.abs(this.start.getX() - this.end.getX()) < ERROR) {
            double inter2 = slope(other.start, other.end) * this.end.getX() + yIntercept(other.start, other.end);
            if (maxOtherX < this.start.getX() || this.start.getX() < minOtherX) {
                return false;
            }
            return minY1 <= inter2 && inter2 <= maxY1;
        }
        // checks if they both have the same slope.
        if (Math.abs(slope(other.start, other.end) - slope(this.start, this.end)) < ERROR) {
            // checks if they have the same y intercept point and if they are intercepting.
            if (yIntercept(other.start, other.end) != yIntercept(other.start, other.end)) {
                return false;
            }
            return !(maxOtherX < minThisX) && !(maxThisX < minOtherX);
        }
        // the last case checks if they both not vertical,and they do not have the same slope.
        double x = slope(this.start, this.end) - slope(other.start, other.end);
        double y = yIntercept(other.start, other.end) - yIntercept(this.start, this.end);
        double xInter = y / x;
        return !(xInter < minThisX) && !(maxThisX < xInter) && !(xInter < minOtherX) && !(maxOtherX < xInter);
    }

    /**
     * This function gets Line and calculate the intersecting Point with the other.
     *
     * @param other of Line that we want to calculate the Point of the intersecting.
     * @return the intercepting Point if between them is or null if there are not.
     */
    public Point intersectionWith(Line other) {
        double minThisX = Math.min(this.start.getX(), this.end.getX());
        double maxThisX = Math.max(this.start.getX(), this.end.getX());
        double minOtherX = Math.min(other.start.getX(), other.end.getX());
        double maxOtherX = Math.max(other.start.getX(), other.end.getX());
        double minThisY = Math.min(this.start.getY(), this.end.getY());
        double maxThisY = Math.max(this.start.getY(), this.end.getY());
        double minOtherY = Math.min(other.start.getY(), other.end.getY());
        double maxOtherY = Math.max(other.start.getY(), other.end.getY());
        if (!isIntersecting(other)) {
            return null;
        }
        // checks the case if they both vertical.
        if (Math.abs(other.start.getX() - other.end.getX()) < ERROR && Math.abs(this.start.getX()
                - this.end.getX()) < ERROR) {
            // the case if one is continuing the other and return the intercepting point.
            if (maxOtherY == minThisY) {
                if (Math.abs(maxOtherY - other.end.getY()) < ERROR) {
                    return other.end;
                } else {
                    return other.start;
                }
                // the other case if one is continuing the other and return the intercepting point.
            } else if (Math.abs(maxThisY - minOtherY) < ERROR) {
                if (maxThisY == this.start.getY()) {
                    return this.start;
                } else {
                    return this.end;
                }
            } else {
                return null;
            }
        }
        // if one of the lines is vertical.
        if (Math.abs(other.start.getX() - other.end.getX()) < ERROR) {
            double slopeThis = slope(this.start, this.end);
            double yThis = yIntercept(this.start, this.end);
            return new Point(other.start.getX(), other.start.getX() * slopeThis + yThis);
        }
        // if the other line is vertical.
        if (Math.abs(this.start.getX() - this.end.getX()) < ERROR) {
            double slopeOther = slope(other.start, other.end);
            double yOther = yIntercept(other.start, other.end);
            return new Point(this.start.getX(), this.start.getX() * slopeOther + yOther);
        }
        double slopeThis = slope(this.start, this.end);
        double slopeOther = slope(other.start, other.end);
        // if they have the same slope.
        if (Math.abs(slopeOther - slopeThis) < ERROR) {
            // the case if one is continuing the other and return the intercepting point.
            if (Math.abs(maxOtherX - minThisX) < ERROR) {
                if (Math.abs(maxOtherX - other.end.getX()) < ERROR) {
                    return other.end;
                } else {
                    return other.start;
                }
                // the other case if one is continuing the other and return the intercepting point.
            } else if (Math.abs(maxThisX - minOtherX) < ERROR) {
                if (Math.abs(maxThisX - this.start.getX()) < ERROR) {
                    return this.start;
                } else {
                    return this.end;
                }
            } else {
                return null;
            }
        }
        // calculating the intercepting point and return it.
        double yThis = yIntercept(this.start, this.end);
        double yOther = yIntercept(other.start, other.end);
        double xPoint = (yOther - yThis) / (slopeThis - slopeOther);
        double yPoint = xPoint * slopeThis + yThis;
        return new Point(xPoint, yPoint);
    }

    /**
     * This function gets Line and checks if they are the same.
     *
     * @param other of Line that we want to check.
     * @return true if they are the same and false otherwise.
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start) && this.end.equals(other.end))
                || (this.start.equals(other.end) && this.end.equals(other.start));
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     * @param rect the rectangle.
     * @return closest point.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        return this.start.closest(rect.intersectionPoints(this));
    }

    /**
     * check if the point is on the line.
     * @param check the point we want to check.
     * @return true or false.
     */
    public boolean pointOnLine(Point check) {
        return this.start.distance(check) + this.end.distance(check) == this.start.distance(end);
    }
}

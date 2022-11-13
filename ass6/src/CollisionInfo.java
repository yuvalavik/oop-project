import geometryprimitives.Point;

// Yuval Avikassis 209329234.

/**
 * class of col info.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * constructor.
     * @param collisionPoint the collision Point.
     * @param collisionObject collision Object.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * the point at which the collision occurs.
     * @return the collision Point.
     */
    // the point at which the collision occurs.
    public Point collisionPoint() {
        return this.collisionPoint; }
    /**
     * the collidable object involved in the collision.
     * @return the collision Object.
     */
    public Collidable collisionObject() {
        return this.collisionObject; }
}
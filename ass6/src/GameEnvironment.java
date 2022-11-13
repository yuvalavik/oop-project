// Yuval Avikassis 209329234.
import java.util.LinkedList;
import geometryprimitives.Point;
import geometryprimitives.Line;
import geometryprimitives.Rectangle;
/**
 * class of the game environment.
 */
public class GameEnvironment {
    private LinkedList<Collidable> collection;
    private static final double PADDLE_HEIGHT = 20;

    /**
     * constructor.
      */
    public GameEnvironment() {
        this.collection = new LinkedList<Collidable>();
    }

    /**
     * function to get the paddle from the list.
     * @return the paddle.
     */
    public Rectangle getPaD() {
        for (Collidable col : collection) {
          if (col.getCollisionRectangle().getUpperLeft().getY() == 555) {
              return col.getCollisionRectangle();
          }
        }
        return null;
    }

    /**
     * add the given collidable to the environment.
     * @param c Collidable thing.
     */
    public void addCollidable(Collidable c) {
        this.collection.add(c); }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     * @param trajectory of the ball vel.
     * @return collision info.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        if (this.collection == null || this.collection.size() == 0) {
            return null;
        }
        LinkedList<Point> collisionPoints = new LinkedList<>();
        for (Collidable collidable : this.collection) {
            collisionPoints.addAll(collidable.getCollisionRectangle().intersectionPoints(trajectory));
        }
        if (collisionPoints.isEmpty()) {
            return null;
        }
        Point closestCollisionPoint = trajectory.start().closest(collisionPoints);
        Collidable colObject = null;
        for (Collidable collidable : this.collection) {
            for (int i = 0; i < collidable.getCollisionRectangle().intersectionPoints(trajectory).size(); i++) {
                if (collidable.getCollisionRectangle().intersectionPoints(trajectory).get(i)
                        .equals(closestCollisionPoint)) {
                    colObject = collidable;
                    break;
                }
            }
        }
        return new CollisionInfo(closestCollisionPoint, colObject);
    }

    /**
     * remove the coll from the list.
     * @param c the call.
     */
    public void remove(Collidable c) {
        this.collection.remove(c);
    }
}

// Yuval Avikassis 209329234.
import geometryprimitives.Point;
import geometryprimitives.Rectangle;
public interface Collidable {
    /**
     * Return the "collision shape" of the object.
     * @return the shape.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     * @param collisionPoint point of collosion.
     * @param currentVelocity the vel.
     * @param  hitter the ball.
     * @return the new vel.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
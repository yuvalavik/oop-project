// Yuval Avikassis 209329234
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import geometryprimitives.Rectangle;
import geometryprimitives.Point;
public class Block implements Collidable, Sprite, HitNotifier {

    private final Rectangle surface;
    private final Color color;
    static final double ERROR = Math.pow(10, -10);
    private List<HitListener> hitListeners = new ArrayList<>();

    /**
     *  constructor that gets to things and define the block.
     * @param surface the surface of the block.
     * @param color the color of the block
     */
    public Block(Rectangle surface, Color color) {
        this.color = color;
        this.surface = surface;
    }

    /**
     * Return the collision shape of the block.
     * @return the collision shape.
     */
    public Rectangle getCollisionRectangle() {
        return this.surface;
    }

    /**
     *
     * @param hitter
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
    /**
     *  Notify the block that we collided with it at collisionPoint with a given velocity and change the
     *  velocity.
     * @param collisionPoint the point of collision.
     * @param currentVelocity the velocity before.
     * @param hitter the ball.
     * @return the new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double xColl = collisionPoint.getX(), yColl = collisionPoint.getY();
        double x1 = this.surface.getUpperLeft().getX(), x2 = this.surface.getDownRight().getX();
        double y1 = this.surface.getUpperLeft().getY(), y2 = this.surface.getDownRight().getY();
        double tempDx = currentVelocity.getDx(), tempDy = currentVelocity.getDy();

        if (Math.abs(xColl - x1) < ERROR || Math.abs(xColl - x2) < ERROR) {
            currentVelocity = new Velocity(-tempDx, tempDy);
        }
        if (Math.abs(yColl - y1) < ERROR || Math.abs(yColl - y2) < ERROR) {
            currentVelocity = new Velocity(tempDx, -tempDy);
        }
        this.notifyHit(hitter);
        return currentVelocity;
    }
    @Override
    public void drawOn(DrawSurface surf) {
        surf.setColor(this.color);
        Rectangle rect = this.surface;
        surf.fillRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(),
                (int) rect.getWidth(), (int) rect.getHeight());
        surf.setColor(Color.BLACK);
        surf.drawRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(), (int) rect.getWidth(),
                (int) rect.getHeight());
    }
    @Override
    public void timePassed() { }

    /**
     * adding the object to the game.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * remove the object.
     * @param game the game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * make the block deathly to the ball.
     * @param game the game.
     * @param remBalls the ball.
     */
    public void makeDeathly(GameLevel game, Counter remBalls) {
        BallRemover ballRem = new BallRemover(game, remBalls);
        this.addHitListener(ballRem);
    }
}

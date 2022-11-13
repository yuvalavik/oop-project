//Yuval Avikassis 209329234

/**
 * interface of hil listener.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * @param beingHit the block.
     * @param hitter the ball.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
// Yuval Avikassis 209329234.
import biuoop.DrawSurface;

/**
 * the sprite interface.
 */
public interface Sprite {
    /**
     * draw the sprite on the screen.
     * @param d draw surface.
     */
    void drawOn(DrawSurface d);
    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}
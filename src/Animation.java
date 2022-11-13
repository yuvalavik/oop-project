// Yuval Avikassis 209329234.
import biuoop.DrawSurface;

/**
 * a class of the animation.
 */
public interface Animation {
    /**
     * do one frame of the Animation.
     * @param d the DrawSurface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * check if the animation should stop or continue.
     * @return true or false.
     */
    boolean shouldStop();
}
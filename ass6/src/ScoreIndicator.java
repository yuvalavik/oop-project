//Yuval Avikassis 209329234.
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * a class of the score indicator.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;
    private static final int XPLACE = 380;
    private static final int YPLACE = 15;
    private static final int FONTSIZE = 15;

    /**
     * a constructor.
     * @param counter the score counter.
     */
    public ScoreIndicator(Counter counter) {
        this.score = counter;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(XPLACE, YPLACE, "score: " + this.score.getValue(), FONTSIZE);
    }

    @Override
    public void timePassed() { }


}

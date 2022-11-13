// Yuval Avikassis 209329234.
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * a class of countdown at the start of each level.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private int frame;

    /**
     * a constructor.
     * @param numOfSeconds the num of sec on the screen.
     * @param countFrom the num of the start.
     * @param gameScreen the sprite collection.
     */
    public CountdownAnimation(double numOfSeconds,
                              int countFrom,
                              SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.frame = (int) ((numOfSeconds) * 60);
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.white);
        d.drawText(380, 350, String.valueOf((this.frame / 60) + 1), 50);
        frame--;
        if (this.frame == 0) {
            this.stop = true;
        }
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
//Yuval Avikassis 209329234.
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * the live in the game.
 */
public class Lives implements Sprite {
    private Counter lives;

    /**
     * a constructor.
     * @param counter the lives in the game.
     */
    public Lives(Counter counter) {
        this.lives = counter;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(200, 15, "Lives: " + this.lives.getValue(), 15);
    }

    @Override
    public void timePassed() {
    }
}

// Yuval Avikassis 209329234.
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * a class of the pause screen.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private KeyPressStoppableAnimation stopNow;

    /**
     * a constructor.
     * @param k the KeyboardSensor of the game
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
        this.stopNow = new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, this);
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.fillCircle(400, d.getHeight() / 2, 70);
        d.setColor(Color.BLUE);
        d.fillRectangle(370, d.getHeight() / 2 - 40, 20, 80);
        d.fillRectangle(410, d.getHeight() / 2 - 40, 20, 80);
        d.drawText(150, d.getHeight() / 2 - 100, "paused -- press space to continue", 30);
        this.stopNow.doOneFrame(d);
        this.stop = this.stopNow.shouldStop();
    }
    @Override
    public boolean shouldStop() {
        return this.stop; }
}
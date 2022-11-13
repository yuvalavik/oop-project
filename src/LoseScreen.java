//Yuval Avikassis 209329234.
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * the screen if you lose.
 */
public class LoseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private int score;
    private KeyPressStoppableAnimation stopNow;

    /**
     * a constructor.
     * @param keyboardSensor the keyboardSensor of the game.
     * @param scr the score in the game.
     */
    public LoseScreen(KeyboardSensor keyboardSensor, int scr) {
        this.keyboard = keyboardSensor;
        this.stop = false;
        this.score = scr;
        this.stopNow = new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, this);
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.YELLOW);
        d.fillCircle(400, d.getHeight() / 2, 70);
        d.setColor(Color.black);
        d.fillCircle(375, d.getHeight() / 2 - 20, 10);
        d.fillCircle(425, d.getHeight() / 2 - 20, 10);
        d.fillCircle(400, d.getHeight() / 2 + 30, 12);
        d.setColor(Color.YELLOW);
        d.fillCircle(400, d.getHeight() / 2 + 30, 7);
        d.drawText(210, d.getHeight() / 2 - 100, "Game Over. Your score is " + this.score, 30);
        this.stopNow.doOneFrame(d);
        this.stop = this.stopNow.shouldStop();
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}

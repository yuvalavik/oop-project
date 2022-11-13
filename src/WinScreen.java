//Yuval Avikassis 209329234.
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

public class WinScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private int score;
    private KeyPressStoppableAnimation stopNow;

    /**
     * a constructor.
     * @param keyboardSensor the keyboard.
     * @param scr the score.
     */
    public WinScreen(KeyboardSensor keyboardSensor, int scr) {
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
        d.fillCircle(400, d.getHeight() / 2 + 30, 15);
        d.setColor(Color.YELLOW);
        d.fillCircle(400, d.getHeight() / 2 + 30, 7);
        d.fillRectangle(380, d.getHeight() / 2, 35, 30);
        d.setColor(Color.black);
        d.drawText(210, d.getHeight() / 2 - 100, "You Win!! Your score is " + this.score, 30);
        this.stopNow.doOneFrame(d);
        this.stop = this.stopNow.shouldStop();
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}

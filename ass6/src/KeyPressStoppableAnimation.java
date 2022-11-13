//Yuval Avikassis 209329234.
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * a class for all the times that we need to press space.
 */
public class KeyPressStoppableAnimation implements Animation {
    private String k;
    private KeyboardSensor keyboardSensor;
    private Animation anim;
    private Boolean stop;
    private boolean isAlreadyPressed;

    /**
     * a constructor.
     * @param sensor the KeyboardSensor that we use.
     * @param key the letter that need to press.
     * @param animation the animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.k = key;
        this.anim = animation;
        this.keyboardSensor = sensor;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.keyboardSensor.isPressed(k) && isAlreadyPressed) {
            return;
        }
        if (this.keyboardSensor.isPressed(k)) {
            this.stop = true;
        }
        if (!this.keyboardSensor.isPressed(k)) {
            this.isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
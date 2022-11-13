//Yuval Avikassis 209329234
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * a class for the level name.
 */
public class LevelName implements Sprite {
    private LevelInformation information;

    /**
     * a constructor.
     * @param info the current level information.
     */
    public LevelName(LevelInformation info) {
        this.information = info;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(550, 15, "Level Name: " + this.information.levelName(), 15);
    }

    @Override
    public void timePassed() {

    }
}

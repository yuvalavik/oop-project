//Yuval avikassis 209329234
import biuoop.DrawSurface;

import java.util.LinkedList;

/**
 * class of sprite collection.
 */
public class SpriteCollection {
    private LinkedList<Sprite> spriteCollection;

    /**
     * a constructor.
      */
    public SpriteCollection() {
        this.spriteCollection = new LinkedList<>();
    }

    /**
     *adding the sprite to the collection.
     * @param s sprite.
     */
    public void addSprite(Sprite s) {
    this.spriteCollection.add(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        LinkedList<Sprite> spriteCollection2 = new LinkedList<Sprite>(this.spriteCollection);
        for (Sprite sprite : spriteCollection2) {
            sprite.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     * @param d the draw surface.
     */

    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : this.spriteCollection) {
            sprite.drawOn(d);
        }
    }

    /**
     * remove the sprite from the list.
     * @param s the sprite.
     */
    public void remove(Sprite s) {
        this.spriteCollection.remove(s);
    }
}
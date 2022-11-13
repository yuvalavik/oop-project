// Yuval Avikassis 209329234.
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * a class that runs all the list of levels.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter score;
    private Counter lives;
    private GUI gui;

    /**
     * a constructor.
     * @param ar the animation runner of the game.
     * @param ks the KeyboardSensor of the game.
     * @param gui1 the gui of the game.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui1) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.score = new Counter();
        this.lives = new Counter(7);
        this.gui = gui1;
    }

    /**
     * this function runs the list of the levels.
     * @param levels all the levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        int sum = 0;
        for (LevelInformation levelInfo : levels) {
            sum = sum + 5 * levelInfo.numberOfBlocksToRemove() + 100;
        }
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor,
                    this.animationRunner, this.score, this.lives, this.gui);

            level.initialize();
            while (level.getNumBalls() > 0 && level.getNumBlocks() > 0) {
                level.run();
            }

            if (level.getNumBalls() == 0) {
                break;
            }
            if (sum == this.score.getValue()) {
                animationRunner.run(new WinScreen(this.keyboardSensor, this.score.getValue()));
                gui.close();
            }

        }
    }
}
//Yuval Avikassis 209329234.
import java.util.List;

/**
 * a class for information of each level.
 */
public interface LevelInformation {
    /**
     * get the number of balls in the level.
     * @return the number of balls in the level
     */
    int numberOfBalls();
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()

    /**
     *The initial velocity of each ball.
     * @return list of velocity of the balls.
     */
    List<Velocity> initialBallVelocities();

    /**
     * get the paddle speed.
     * @return the paddle speed.
     */
    int paddleSpeed();
    /**
     *  get the paddle width.
     * @return the paddle width.
     */
    int paddleWidth();
    /**
     * get the level name will be displayed at the top of the screen.
     * @return the level name.
     */
    String levelName();
    /**
     * Returns a sprite with the background of the level.
     * @return the Background.
     */
    Sprite getBackground();
    // The Blocks that make up this level, each block contains
    // its size, color and location.

    /**
     * The Blocks that make up this level, each block contains
     *its size, color and location.
     * @return list of the blocks.
     */
    List<Block> blocks();
    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();

    /**
     *Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * @return the number of blocks.
     */
    int numberOfBlocksToRemove();
}
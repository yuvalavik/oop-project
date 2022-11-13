// Yuval Avikassis 209329234.

import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.Color;
import biuoop.KeyboardSensor;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;

/**
 * class of game.
 */
public class GameLevel implements Animation {
    private LevelInformation levInfo;
    private AnimationRunner runner;
    private boolean running;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter blocks;
    private Counter balls;
    private  Counter score;
    private ScoreIndicator scoreIndicator;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BORDER_SIZE = 25;
    private static final double PADDLE_HEIGHT = 20;
    private KeyboardSensor keyboard;
    private Counter lives;
    private Lives live;
    private Paddle pad;
    private GUI gui;


    /**
     * a constructor.
     * @param info the info of the current level.
     * @param keyboardSensor the KeyboardSensor of the game.
     * @param ar the animation runner of the game
     * @param score1 the score in the game.
     * @param live the lives in the game.
     * @param gui1 the gui of the game.
     */
    public GameLevel(LevelInformation info, KeyboardSensor keyboardSensor, AnimationRunner ar, Counter score1,
                     Counter live, GUI gui1) {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.blocks = new Counter();
        this.balls = new Counter();
        this.runner = ar;
        this.keyboard = keyboardSensor;
        this.levInfo = info;
        this.score = score1;
        this.lives = live;
        this.gui = gui1;
    }

    /**
     * add Collidable to the environment.
     * @param c Collidable.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * add sprite to the sprite collection.
     *
     * @param s sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them to the game.
     */
    public void initialize() {
        Sprite sprite = this.levInfo.getBackground();
        this.sprites.addSprite(sprite);
        creatPaddle();
        Block[] borders = borders();
        for (Block border : borders) {
            border.addToGame(this);
        }
        blocks();
        creatBalls();
        scoreIndicator = new ScoreIndicator(score);
        addSprite(scoreIndicator);
        LevelName name = new LevelName(this.levInfo);
        this.sprites.addSprite(name);
        live = new Lives(lives);
        addSprite(live);
    }

    /**
     * creating the paddle.
     */
    public void creatPaddle() {
        KeyboardSensor p = this.keyboard;
        Paddle paddle = new Paddle(new Rectangle(new Point((double) (WIDTH / 2 - this.levInfo.paddleWidth() / 2),
                (double) HEIGHT - BORDER_SIZE - PADDLE_HEIGHT), this.levInfo.paddleWidth(), (double) PADDLE_HEIGHT),
                Color.ORANGE, p);
        this.pad = paddle;
        paddle.addToGame(this);
    }
    @Override
    public void doOneFrame(DrawSurface d) {
      this.sprites.drawAllOn(d);
      this.sprites.notifyAllTimePassed();
      if (this.blocks.getValue() == 0) {
          this.score.increase(100);
          this.running = false;
      } else if (this.balls.getValue() == 0) {
          lives.decrease(1);
          if (lives.getValue() > 0) {
              creatBalls();
              this.sprites.remove(pad);
              this.removeCollidable(pad);
              creatPaddle();
              this.runner.run(new CountdownAnimation(3, 3, this.sprites));
          } else {
              this.runner.run(new LoseScreen(this.keyboard, this.score.getValue()));
              gui.close();
          }
      }
      if (this.keyboard.isPressed("p")) {
          this.runner.run(new PauseScreen(this.keyboard));
      }
  }
    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * get the number of balls.
     * @return the number of balls.
     */
    public int getNumBalls() {
        return this.balls.getValue();
    }
    /**
     * get the number of blocks.
     * @return the number of blocks.
     */
    public int getNumBlocks() {
        return this.blocks.getValue();
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(3, 3, this.sprites));
        this.running = true;
        this.runner.run(this);
    }

    /**
     * this function create all the blocks and add them to the game.
     */
    public void blocks() {
        BlockRemover blockRemover = new BlockRemover(this, this.blocks);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        for (Block block : this.levInfo.blocks()) {
                block.addToGame(this);
                block.addHitListener(blockRemover);
                block.addHitListener(scoreTrackingListener);
                this.blocks.increase(1);
            }
    }

    /**
     * this function create all the borders and return arr of them.
     *
     * @return arr of borders.
     */
    public Block[] borders() {
        Block upBorder = (new Block(new Rectangle(new Point(0, 20), WIDTH, BORDER_SIZE), Color.GRAY));
        Block leftBorder = (new Block(new Rectangle(new Point(0, 20), BORDER_SIZE, HEIGHT), Color.GRAY));
        Block downBorder = (new Block(new Rectangle(new Point(0, HEIGHT), WIDTH, BORDER_SIZE),
                Color.GRAY));
        Block rightBorder = (new Block(new Rectangle(new Point(WIDTH - BORDER_SIZE, 20), BORDER_SIZE, HEIGHT),
                Color.GRAY));
        Block score = (new Block(new Rectangle(new Point(0, 0), WIDTH, 20), Color.WHITE));
        downBorder.makeDeathly(this, this.balls);
        return new Block[]{upBorder, leftBorder, downBorder, rightBorder, score};

    }

    /**
     * these function create all the balls and add them to the game.
     */
    public void creatBalls() {
        double angle = (double) 180 / (this.levInfo.numberOfBalls() + 1);
        for (int i = 1; i < this.levInfo.numberOfBalls() + 1; i++) {
            Ball ball1 = new Ball(new Point(400, 555 - 30), 6, Color.white);
            ball1.setVelocity(5 * Math.cos(Math.toRadians(angle * i)),
                    -5 * Math.sin(Math.toRadians(angle * i)));
            ball1.setGameEnvironment(this.environment);
            ball1.addToGame(this);
            this.balls.increase(1);
        }
    }

    /**
     * remove coll from the list.
     *
     * @param c the coll.
     */
    public void removeCollidable(Collidable c) {
        this.environment.remove(c);
    }

    /**
     * remove sprite from the list.
     *
     * @param s the sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }
}

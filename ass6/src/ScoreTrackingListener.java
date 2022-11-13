//Yuval Avikassis 209329234
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * a constructor.
     * @param scoreCounter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }
}
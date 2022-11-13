// Yuval Avikassis 209329234

/**
 * class of counter.
 */
public class Counter {
    private int counter;

    /**
     * a constructor.
     */
    public Counter() {
        this.counter = 0;
    }

    /**
     * second constructor.
     * @param num the beginning number.
     */
    public Counter(int num) {
        this.counter = num;
    }
    /**
     * add number to current count.
     * @param number the number we need to add.
     */
    public void increase(int number) {
        this.counter = this.counter + number;
    }
    /**
     * subtract number from current count.
     * @param number the number.
     */
    public void decrease(int number) {
        this.counter = this.counter - number;
    }
    /**
     * get current count.
     * @return the count.
     */
    public int getValue() {
        return this.counter;
    }
}
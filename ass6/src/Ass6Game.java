// Yuval Avikassis 209329234.

import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.ArrayList;
import java.util.List;

/**
 * the class of the game.
 */
public class Ass6Game {
    /**
     * a class that make a list of the levels according to the user choice.
     * @param args the user choice.
     * @return a list of levels.
     */
    public static List<LevelInformation> makeList(String[] args) {
        List<LevelInformation> list = new ArrayList<>();
        for (String str : args) {
            if (str.equals("1")) {
                list.add(new LevelOne());
            }
            if (str.equals("2")) {
                list.add(new LevelTwo());
            }
            if (str.equals("3")) {
                list.add(new LevelThree());
            }
            if (str.equals("4")) {
                list.add(new LevelFour());
            } else {
                continue;
            }
        }
        return list;
    }
    /**
     * starting the game.
     * @param args from the user.
     */
    public static void main(String[] args) {
        List<LevelInformation> list = makeList(args);
        if (list.size() == 0) {
            list.add(new LevelOne());
            list.add(new LevelTwo());
            list.add(new LevelThree());
            list.add(new LevelFour());
        }
        GUI gui = new GUI("arc", 800, 600);
        KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        AnimationRunner ar = new AnimationRunner(gui);
        GameFlow gameFlow = new GameFlow(ar, keyboardSensor, gui);
        gameFlow.runLevels(list);
    }
}

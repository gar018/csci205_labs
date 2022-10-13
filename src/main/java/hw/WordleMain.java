/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 10/7/22* Time: 11:14 AM
 *
 * Project: csci205_labs
 * Package: hw
 * Class: WordleMain
 *
 * Description:
 *
 *
 ****************************************
 */

package hw;

import java.io.IOException;

public class WordleMain {

    /**
     * The main method for the Wordle Program
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Game wordleGame = new Game();
        wordleGame.startGame();
    }
}

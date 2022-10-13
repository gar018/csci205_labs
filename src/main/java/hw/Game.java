/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 10/7/22* Time: 11:19 AM
 *
 * Project: csci205_labs
 * Package: hw
 * Class: Game
 *
 * Description:
 *
 *
 ****************************************
 */

package hw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * enum class to classify proximity types
 * EXACT
 */
public class Game {

    /**
     * default guess limit for wordle is 6
     */
    private static final int DEFAULT_GUESS_LIMIT = 6;

    /**
     * the size of the words in play are supposed to be
     */
    public static final int GAME_WORD_LENGTH = 5;

    /**
     * the secret word that must be found to win
     */
    private String secretWord;

    /**
     * the number of guesses the user has tried
     */
    private int guessesMade;

    /**
     * the amount of guesses allowed in a round of the game
     */
    private int guessLimit;

    /**
     * an array list containing all valid words that may be used within the game
     */
    private ArrayList<String> validWords;

    /**
     * constructor class for Game
     */
    public Game() throws IOException {
        this.guessesMade = 0;
        this.guessLimit = DEFAULT_GUESS_LIMIT;
        this.validWords = readValidDictionary();
        this.secretWord=createSecretWord();

    }

    /**
     * randomly generates a secret word to be used in the game
     * @return
     */
    private String createSecretWord() {
        Random rand = new Random();
        String secret = validWords.get(rand.nextInt(0,validWords.size()));
        return secret;
    }

    /**
     * reads the words.txt file and appends them to an array list. if words.txt does not exist, it will generate a new one
     * @return validWords
     */
    private ArrayList<String> readValidDictionary() throws IOException /*throws FileNotFoundException*/ {
        ArrayList<String> validWords = new ArrayList<>();

        //this segment of code is partially derived from:
        //https://stackoverflow.com/questions/1816673/how-do-i-check-if-a-file-exists-in-java
        File f = new File("words.txt");
        if(f.exists() && !f.isDirectory()) {
            String response = askForInput("PROMPT!:\n A valid word dictionary has already been created.\n" +
                    "Would you like to regenerate the file? [y/n]", "y", "n");
            if (response.equals("y")) {
                constructDictionary();
            }
        }
        else {
            System.out.println("No valid word dictionary was found, generating new file.");
            constructDictionary();
        }

        FileInputStream in = new FileInputStream("words.txt");
        Scanner sc = new Scanner(in);

        while (sc.hasNext()){
            validWords.add(sc.nextLine().strip());
        }

        return validWords;
    }

    /**
     * constructs the words.txt file used in the construction of the valid words list
     * @throws IOException
     */
    private static void constructDictionary() throws IOException {
        System.out.println("Constructing! (This may take several seconds..)");
        ValidDictionary dict = new ValidDictionary();
        for (String resource : dict.getResources()) {
            dict.appendResource(resource);
        }
        dict.listWords();
    }

    /**
     * initiates the game for this Game class, ends when the user guesses the correct word or when the user runs out of guesses
     */
    public void startGame() {
        //introduction and instructions

        //initialize some variables
        boolean secretWordFound = false;
        //start first round... repeat till word guessed or out of guesses
        while(guessesMade < guessLimit && secretWordFound == false) {
            secretWordFound = guess("Round " + (guessesMade+1) + " Guess:");
        }
        System.out.printf("Game has ended! (Guess %d/%d used)%n",guessesMade, guessLimit);
        System.out.printf("Answer: %s",secretWord);

    }

    /**
     * prints a specific statement from the parameters, then scans for user input, then returns it
     * @param statement
     * @return userInput
     */
    private String askForInput(String statement) {
        Scanner sc = new Scanner(System.in);
        System.out.println(statement);
        String userInput = sc.nextLine();
        return userInput;
    }

    /**
     * prints a specific statement from the parameters, then scans for user input, then returns it
     * allows only two possible inputs, if the response is not one of these two inputs, it reruns the statement and prompts
     * @param statement
     * @return
     */
    private String askForInput(String statement, String response1, String response2) {
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println(statement);
            userInput = sc.nextLine();
        } while (!userInput.equals(response1) && !userInput.equals(response2));

        return userInput;
    }

    /**
     * takes an input and checks to see if its a valid word
     * the word must be exactly 5 characters long and a registered valid word in validWords
     * @param guess
     * @return
     */
    private boolean isValidGuess(String guess) {
        if (guess.length() == GAME_WORD_LENGTH) {
            for(String word : validWords) {
                if (guess.equals(word)) {
                    return true;
                }
            }
            System.out.println("Not a valid guess (not found in valid word dictionary), try again!");
        }
        else{
            System.out.println("Not a valid guess (not 5 characters), try again!");
        }
        return false;
    }

    /**
     * congregation of multiple methods used during startGame
     * 1. askForInput to get user's guess
     * 2. isValidGuess to determine if it's a size of 5 and a valid word
     * 3. printProximity to show its similarity to the secret word
     * 4. Increments guessesMade Count by 1
     * 5. Checks if the guess was the secret word
     * @param statement
     */
    private boolean guess(String statement) {
        String guess = "";
        do {
            guess = askForInput(statement);
            guess = guess.toLowerCase().strip();
        } while(!isValidGuess(guess));
        System.out.println(printProximity(guess));
        guessesMade++;
        if (guess.equals(this.secretWord)) {
            return true;
        }
        return false;
    }

    /**
     * determines how close the guess input was
     * @param guess
     * @return
     */
    public String printProximity(String guess) throws IllegalArgumentException{

        if (secretWord.length() != guess.length()) {
            throw new IllegalArgumentException("The guess and secret word had mismatched lengths! This is a problem with the code.");
        }
        char[] secretWordCharArray = new char[secretWord.length()];
        char[] guessCharArray = new char[guess.length()];
        for (int i = 0; i < secretWord.length(); i++) {
            secretWordCharArray[i] = secretWord.charAt(i);
            guessCharArray[i] = guess.charAt(i);
        }

        for (int i = 0; i < guessCharArray.length; i++) {
            char guessCharacter = guessCharArray[i];
            guessCharArray[i] = '-';
            for (int j = 0; j<secretWordCharArray.length; j++) {
                char secretWordCharacter = secretWordCharArray[j];
                if (guessCharacter == secretWordCharacter) {
                    secretWordCharArray[j] = '#';
                    if (i == j) {
                        guessCharArray[i] = '*';
                    }
                    else {
                        guessCharArray[i] = '+';
                    }
                }
            }
        }

        String prox = "";
        for (char p : guessCharArray) {
            prox += p;
        }
        return prox;
    }

    /**
     * works like a setter method, but checks to see if the secret word is a valid length for use
     * if not, does not change the secret word
     * @param secret
     */
    public void setSecretWord(String secret) {
        if (secret.length() == GAME_WORD_LENGTH) {
            this.secretWord = secret;
        }
    }
}

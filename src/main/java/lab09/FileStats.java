/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 10/3/22* Time: 9:29 AM
 *
 * Project: csci205_labs
 * Package: lab09
 * Class: FileStats
 *
 * Description: Program that reads a given file and counts the frequency of each char type
 *
 *
 ****************************************
 */

package lab09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class FileStats {



    /**
     * number of alphabet chars found in the file
     */
    private static int alphaCount;

    /**
     * number of digit chars found in the file
     */
    private static int digitCount;

    /**
     * number of whitespace chars found in the file
     */
    private static int whiteSpaceCount;

    /**
     * treemap that holds any extra characters and their frequency in the file
     */
    private static Map<Character, Integer> extraCharCount = new TreeMap<>();

    /**
     * Grabs a given name of a file, reads each character, and increments a counter for each kind of character
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        /**
         * The name of the file being read -- hard code a file name for it to read
         */
        final String FILE_NAME = "src/main/resources/auto-mpg.csv";

        readFile(FILE_NAME);
        System.out.println(printResults(FILE_NAME));

    }

    /**
     * reads the file by character and organizes the frequency of each character type
     * @param fileName name of file
     */
    private static void readFile(String fileName) throws FileNotFoundException {

        //Init file & file scanner
        try {
            File csv = new File(fileName);
            Scanner sc = new Scanner(csv);
        }
        catch (FileNotFoundException e) {
            System.err.println("FILE WAS NOT FOUND!");
        }
        File csv = new File(fileName);
        Scanner sc = new Scanner(csv);
        sc.useDelimiter("");

        while (sc.hasNext()) {
            Character ch = sc.next().charAt(0);
            if (Character.isAlphabetic(ch)) {
                alphaCount++;
            }
            else if (Character.isDigit(ch)) {
                digitCount++;
            }
            else if (Character.isWhitespace(ch)) {
                whiteSpaceCount++;
            }
            else{
                if (extraCharCount.containsKey(ch)) {//if Map already has the char as a key, increment it by 1
                    extraCharCount.put(ch,extraCharCount.get(ch)+1);
                }
                else { //else add the key and give it a value of 1
                    extraCharCount.put(ch,1);
                }
            }
        }
    }

    /**
     * prints the resulting frequencies to the console
     * @param fileName
     * @return s
     */
    private static String printResults(String fileName) {
        String s = String.format("Results on %s:%n",fileName);
        s+= String.format("%s%13d%n","Alphabet:",alphaCount);
        s+= String.format("%s%16d%n","Digit:",digitCount);
        s+= String.format("%s%11d%n","Whitespace:",whiteSpaceCount);
        Set<Character> characterSet = extraCharCount.keySet();
        for ( Character ch : characterSet) {
            s+= String.format("Char: %c: %d%n", ch, extraCharCount.get(ch));
        }
        return s;
    }
}

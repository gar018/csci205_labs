/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 10/7/22* Time: 11:44 AM
 *
 * Project: csci205_labs
 * Package: hw
 * Class: ValidDictionary
 *
 * Description:
 *
 *
 ****************************************
 */

package hw;

import java.io.*;
import java.net.URL;
import java.util.*;

public class ValidDictionary {

    private Map<String, Integer> words;

    /**
     * a list of the resources used to create the valid dictionary
     */
    private String[] resources = {
            "https://www.gutenberg.org/cache/epub/29765/pg29765.txt",
            "https://www.gutenberg.org/cache/epub/1497/pg1497.txt",
            "https://www.gutenberg.org/cache/epub/25344/pg25344.txt",
            "https://www.gutenberg.org/files/42108/42108-0.txt",
            "https://www.gutenberg.org/cache/epub/8492/pg8492.txt",
            "https://www.gutenberg.org/cache/epub/27827/pg27827.txt"};

    /**
     * ValidDictionary constructor
     * initializes a TreeMap
     */
    public ValidDictionary() {
        this.words = new TreeMap<>();

    }

    /**
     * takes a String containing a url and sorts through each word to determine its validity
     * when a word is 5 characters long with only alpha characters it is appended to the words Map
     * @param url
     * @throws IOException
     */
    public void appendResource(String url) throws IOException {

        Scanner sc = new Scanner(resourceToInputStream(url));

        while (sc.hasNext()) {
            String currentScan = sc.next().toLowerCase().strip();
            if(currentScan.length() == 5 && currentScan.matches("^[a-z]*$")) {
                appendToTree(currentScan);
            }
        }

    }

    /**
     * appends a word to the words Map
     * @param key
     */
    private void appendToTree(String key) {
        if (words.get(key) == null) {
            words.put(key,1);
        }
        else {
            words.put(key,words.get(key)+1);
        }
    }

    /**
     * lists the words found within the words Map to the "words.txt" text file
     * only appends words with a frequency > 1
     * @throws FileNotFoundException
     */
    public void listWords() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("words.txt"));
        Set<String> wordsSet = words.keySet();
        for (String word : wordsSet) {
            if (words.get(word) > 1) {
                out.print(word+"\n");
            }
        }
    }

    /**
     * converts the string given to a URL, then creates a stream from the URL to a buffer, which is returned to a scanner
     * @param url
     * @return
     * @throws IOException
     */
    private InputStream resourceToInputStream(String url) throws IOException {
        URL address = new URL(url);
        InputStream inputStream = new BufferedInputStream(address.openStream());
        return inputStream;
    }

    public String[] getResources() {
        return resources;
    }

    public Map getWords() {
        return words;
    }
}

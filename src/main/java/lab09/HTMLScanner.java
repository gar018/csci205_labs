/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 10/5/22* Time: 9:29 AM
 *
 * Project: csci205_labs
 * Package: lab09
 * Class: HTMLScanner
 *
 * Description:
 *
 *
 ****************************************
 */

package lab09;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 * enum class that defines what kind of order the stream should output
 * TAG NAME = alphabetical order
 * TAG FREQUENCY = order by most to the least frequent tag
 */
enum ReportSortType {
    SORT_BY_TAG_NAME,
    SORT_BY_TAG_FREQUENCY
}
public class HTMLScanner {
    /**
     * TreeMap containing the tags found in the scan
     */
    private Map<String, Integer> mapOfTags;

    /**
     * holds the totalTagCount
     */
    private int totalTagCount;

    /**
     * Scanner used to iterate through the URL file
     */
    private static Scanner htmlScanner;

    /**
     * Scanner used to get user input
     */
    private Scanner userInput = new Scanner(System.in);

    /**
     * constructor class for HTMLScanner, asks user for sort type within
     * @param inStream
     */
    public HTMLScanner (InputStream inStream) {
        this.mapOfTags = new TreeMap<>();
        this.totalTagCount = 0;
        this.htmlScanner = new Scanner(inStream);
        System.out.println("Would you like sorted by name or freq? [n/f]");

        if (userInput.nextLine().equals("n")) {
            ReportSortType typeToUse = ReportSortType.SORT_BY_TAG_NAME;
        }
        else {
            ReportSortType typeToUse = ReportSortType.SORT_BY_TAG_FREQUENCY;
        }


    }

    /**
     * prints the report for the tag count
     * @param out
     * @param sortBy
     */
    public void printReport(PrintStream out, ReportSortType sortBy) {

        String s = String.format("Tags Found: %d, Unique Tags: %d%n",getTotalTagCount(),getTotalUniqueTagCount());
        Set<String> tagSet = mapOfTags.keySet();

        for ( String keyStr : tagSet) {
            s+= String.format("<%s>: %d%n", keyStr, mapOfTags.get(keyStr));
        }

        System.out.println("Print via file or console? [f/c]");
        if (userInput.nextLine().equals("f")) {
            out.print(s);
        }
        else {
            System.out.println(s);
        }
    }
    public void scanForTags() throws IOException {

        //Pattern matchForTag = Pattern.compile("<([^>]*)>");
        while(htmlScanner.hasNext()){
            String curInput= htmlScanner.nextLine();
            if(Pattern.matches("<([^>]*)>", curInput) && curInput.charAt(1) != '/') {
                String tagName = curInput.substring(1,findEndOfTagName(curInput));
                if (mapOfTags.containsKey(tagName)) {//if Map already has the name as a key, increment it by 1
                    mapOfTags.put(tagName,mapOfTags.get(tagName)+1);
                }
                else { //else add the key and give it a value of 1
                    mapOfTags.put(tagName,1);
                }
                totalTagCount++;

            }
        }

    }

    /**
     * determines where to end the substring of the tag name, if a space exists after the tag name use that, otherwise, use its end bracket
     * @param curInput
     * @return
     */
    private static int findEndOfTagName(String curInput) {
        if (curInput.indexOf(" ") == -1) {
            return curInput.indexOf(">");
        }
        return curInput.indexOf(" ");
    }

    /**
     * get the total UNIQUE tag names
     * @return
     */
    public int getTotalUniqueTagCount() {
        return this.mapOfTags.size();
    }

    /**
     * gets the total tags found
     * @return
     */
    public int getTotalTagCount() {
        return this.totalTagCount;
    }
}

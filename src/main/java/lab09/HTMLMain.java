/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022
 * Instructor: Prof. Brian King
 *
 * Name: Gordon Rose* Section: 01 - 9:00AM-9:50AM
 * Date: 10/5/22* Time: 9:43 AM
 *
 * Project: csci205_labs
 * Package: lab09
 * Class: HTMLMain
 *
 * Description:
 *
 *
 ****************************************
 */

package lab09;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;

public class HTMLMain {
    public static void main(String[] args) throws IOException {
        String address = "https://www.bucknell.edu";
        URL locator = new URL(address);
        BufferedInputStream in = new BufferedInputStream(locator.openStream());
        PrintStream out = new PrintStream(new File("htmltagreport.txt"));
        HTMLScanner sc = new HTMLScanner(in);

        sc.scanForTags();
        sc.printReport(out, ReportSortType.SORT_BY_TAG_NAME);

    }
}

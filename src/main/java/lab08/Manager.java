/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 *
 * Name: YOUR NAME
 * Date: 09/22/2022
 * Time: 11:01 PM
 *
 * Project: csci205_labs
 * Package: lab08
 * Class: Manager
 * Description:
 * A very simple class representing Manager, a specific type of Employee
 * ****************************************
 */

package lab08;

import java.time.LocalDate;

/**
 * Checked exception representing any issues that might arise from the Manager
 * class
 */
class ManagerException extends Exception {
    public ManagerException(String message) {
        super(message);
    }
}

public class Manager extends Employee {

    // TODO - ERASE ME AND FOLLOW THE LAB INSTRUCTIONS
    public Manager(int empID, String firstName, String lastName, int ssNum, LocalDate hireDate, double salary) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
    }
}

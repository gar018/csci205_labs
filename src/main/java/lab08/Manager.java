/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2022
 *
 * Name: Gordon Rose
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
import java.util.ArrayList;

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
    /** manager's department name*/
    private String deptName;

    /** array containing list of Employees under the manager*/
    private ArrayList<Employee> listManagedEmployees;

    /**
     * Constructs a Manager of a given department
     *
     * @param empID - employee ID
     * @param firstName - first name
     * @param lastName - last name
     * @param ssNum - SS number
     * @param hireDate - date hired
     * @param salary - salary
     * @param deptName - name of dept.
     */
    public Manager(int empID, String firstName, String lastName, int ssNum, LocalDate hireDate, double salary, String deptName) {
        super(empID, firstName, lastName, ssNum, hireDate, salary);
        this.deptName = deptName;
        this.listManagedEmployees = new ArrayList<>();
    }

    /**
     * adds a given emoployee to the list of managed employees
     * @param newEmp employee to be added
     * @throws ManagerException when employee to be added already exists inside the list (addresses match)
     */
    public void addEmployee(Employee newEmp) throws ManagerException {
        boolean passed = true;
        for(Employee emp : this.listManagedEmployees) {
            if (emp == newEmp) {
                passed = false;
                throw new ManagerException("THIS EMPLOYEE EXISTS IN THE LIST ALREADY!");
            }
        }
        if (passed) {
            this.listManagedEmployees.add(newEmp);
        }

    }

    public void removeEmployee(Employee remEmp) throws ManagerException {
        boolean found = this.listManagedEmployees.remove(remEmp);
        if (!found) {
            throw new ManagerException("THE EMPLOYEE WAS NOT FOUND IN THE LIST!");
        }
    }

    public String toSimpleString() {
        String s = super.toSimpleString();
        s += String.format(" of %s", this.deptName);
        return s;
    }

    //-=-=-=-=-=-=-=-=-=-=- SETTER AND GETTER FUNCTIONS

    public ArrayList<Employee> getListOfManagedEmps() {
        return this.listManagedEmployees;
    }
    public String getDeptName() {
        return this.deptName;
    }
    public void setDeptName(String newName) {
        this.deptName = newName;
    }
}

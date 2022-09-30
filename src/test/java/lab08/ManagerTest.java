package lab08;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private Manager mgr;
    private Employee emp1;
    private Employee emp2;

    @BeforeEach
    void setUp() {
        mgr = new Manager(777, "Captain", "Piccard", 77777777, LocalDate.parse("1970-01-01"), 77777, "INTERGALACTIC TRAVEL");
        emp1 = new Employee(418, "Gonzo", "Asher", 12341234, LocalDate.parse("2022-09-30"), 10000);
        emp2 = new Employee(222, "Jim", "Carey", 22222222, LocalDate.parse("2012-12-21"), 22222);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("addEmployee() - tests the function of adding employees")
    void addEmployee() throws ManagerException{
        ArrayList<Employee> expectedList = new ArrayList<>();
        List<Employee> actualList = mgr.getListOfManagedEmps();
        mgr.addEmployee(emp1);
        mgr.addEmployee(emp2);
        expectedList.add(emp1);
        expectedList.add(emp2);
        assertEquals(expectedList,actualList);
    }

    @Test
    void addEmployeeException() throws ManagerException {
        mgr.addEmployee(emp1);
        assertThrows(ManagerException.class, () -> mgr.addEmployee(emp1));
    }

    @Test
    void removeEmployee() throws ManagerException {
        ArrayList<Employee> expectedList = new ArrayList<>();
        List<Employee> actualList = mgr.getListOfManagedEmps();
        mgr.addEmployee(emp1);
        mgr.removeEmployee(emp1);
        assertEquals(expectedList,actualList);
    }

    @Test
    void removeEmployeeException() throws ManagerException {
        assertThrows(ManagerException.class, () -> mgr.removeEmployee(emp1));
    }

    @Test
    void getListOfManagedEmps() {
        ArrayList<Employee> expectedList = new ArrayList<>();
        ArrayList<Employee> actualList = mgr.getListOfManagedEmps();
        assertEquals(expectedList,actualList);
    }
}
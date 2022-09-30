package lab08;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HRDBSystemTest {

    private Employee emp1;
    private Employee emp2;

    private HRDBSystem hrdb;


    @BeforeEach
    void setUp() {
        emp1 = new Employee(418, "Gonzo", "Asher", 12341234,LocalDate.parse("2022-09-30"), 10000);
        emp2 = new Employee(222, "Jim", "Carey", 22222222, LocalDate.parse("2012-12-21"), 22222);
        hrdb = new HRDBSystem();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addNewEmployee() {
        ArrayList<Employee> expectedList = new ArrayList<>();
        List<Employee> actualList = hrdb.getListOfEmployees();
        hrdb.addNewEmployee(emp1);
        expectedList.add(emp1);
        assertEquals(expectedList,actualList);
        expectedList.add(emp2);
        hrdb.addNewEmployee(emp2);
        assertEquals(expectedList,actualList);
    }
}
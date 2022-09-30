package lab08;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    private static final double DELTA = 1.0E-10;
    private Employee emp;
    @BeforeEach
    void setUp() {
        emp = new Employee(-418,"Gonzo","Asher",12341234, LocalDate.now(),20);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void changeName() {
        assertEquals("Gonzo",emp.getFirstName());
        assertEquals("Asher",emp.getLastName());
        emp.changeName("Gordon","Rose");
        assertEquals("Gordon",emp.getFirstName());
        assertEquals("Rose",emp.getLastName());
    }

    @Test
    void raiseSalary() {
        assertEquals(20, emp.getSalary());
        emp.raiseSalary(20000);
        assertEquals(20020,emp.getSalary());
    }

    @Test
    void testEquals() {
        Employee emp2 = new Employee(-418,"Gonzo","Asher",12341234, LocalDate.now(),20);
        assertTrue(emp.equals(emp2));
        Employee emp3 = new Employee(-418,"Gonzo","Asher",12341235, LocalDate.now(),20);
        assertFalse(emp.equals(emp3));
    }

    @Test
    void testIDFactory() {
        Employee emp1 = new Employee(100,"A","B",12345678,LocalDate.now(),10000);
        Employee emp2 = new Employee(101,"A","B",12345678,LocalDate.now(),10000);
        Employee emp3 = new Employee(101,"A","B",12345678,LocalDate.now(),10000);
        assertEquals(100,emp1.getEmpID());
        assertEquals(101,emp2.getEmpID());
        assertNotEquals(101,emp1.getEmpID());
    }
}
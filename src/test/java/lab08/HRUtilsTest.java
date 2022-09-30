package lab08;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HRUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void strToDate() {
        String s = "2022-09-09";
        LocalDate dateExp = LocalDate.parse(s);
        LocalDate dateActual = HRUtils.strToDate(s);
        assertEquals(dateExp,dateActual);
    }

    @Test
    void dateToStr() {
        String sExp = "2002-09-09";
        LocalDate dateExp = LocalDate.parse(sExp);
        String sActual = HRUtils.dateToStr(LocalDate.parse(sExp));
        assertEquals(sExp,sActual);
    }
}
package lab07;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCashRegisterTest {

    private static final double FLOAT_DELTA = 1.0E-12;

    private SimpleCashRegister register;
    @BeforeEach
    void setUp() {
        this.register = new SimpleCashRegister();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPurchaseCount() {
        int result = register.getPurchaseCount();
        //a new register should have 0 purchases
        assertEquals(0, result);

        //purchase 2 items and check if its correct
        register.scanItem(1.27);
        register.scanItem(0.55);
        assertEquals(2, register.getPurchaseCount());
    }

    @Test
    void getListOfPurchases() {
    }

    @Test
    void getTransactionTotal() {
        //a new register should have 0 moners
        assertEquals(0.0, register.getTransactionTotal(), FLOAT_DELTA);

        //purchase 2 items and check if its correct
        register.scanItem(1.27);
        register.scanItem(0.55);
        assertEquals(1.82, register.getTransactionTotal(),FLOAT_DELTA);
    }

    @Test
    @DisplayName("scanItem() - exception for bad scan value")
    void scanItemException() {
        //scan for negative price
        assertThrows(IllegalArgumentException.class, () -> register.scanItem(-0.5));

        //scan for ridiculously large price
        assertThrows(IllegalArgumentException.class, () -> register.scanItem(10000.0));

    }

    @Test
    void collectPayment() {
        register.collectPayment(Money.FIVE,1);
        assertEquals(5, register.getPaymentCollected());
    }

    @Test
    void collectPaymentException() {
        assertThrows(IllegalArgumentException.class, () -> register.collectPayment(Money.DOLLAR, -4));
    }

    @Test
    void giveChange() {
        register.scanItem(0.75);
        register.collectPayment(Money.DOLLAR,1);
        assertEquals(.25, register.giveChange());

    }
}
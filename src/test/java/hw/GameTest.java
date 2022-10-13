package hw;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game wordle;

    @BeforeEach
    void setUp() throws IOException {
      wordle = new Game();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void printProximity() {
        wordle.setSecretWord("bison");
        String prox = wordle.printProximity("guess");
        boolean correctReturn = prox.equals("---+-");
        assertTrue(correctReturn);
    }
}
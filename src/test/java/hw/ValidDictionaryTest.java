package hw;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ValidDictionaryTest {

    ValidDictionary dict;
    @BeforeEach
    void setUp() {
        dict = new ValidDictionary();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void appendResource() throws IOException {
        dict.appendResource("https://www.gutenberg.org/cache/epub/29765/pg29765.txt");
        assertTrue(dict.getWords().size() > 0);
    }

}
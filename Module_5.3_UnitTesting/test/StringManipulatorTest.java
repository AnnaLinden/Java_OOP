import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringManipulatorTest {

    private StringManipulator manipulator;

    @BeforeEach
    void setUp() {
        manipulator = new StringManipulator();
    }

    @Test
    void testConcatenate() {
        assertEquals("HelloWorld", manipulator.concatenate("Hello", "World"));
    }

    @Test
    void testFindLength() {
        assertEquals(5, manipulator.findLength("Hello"));
    }

    @Test
    void testConvertToUpperCase() {
        assertEquals("HELLO", manipulator.convertToUpperCase("hello"));
    }

    @Test
    void testConvertToLowerCase() {
        assertEquals("hello", manipulator.convertToLowerCase("HELLO"));
    }

    @Test
    void testContainsSubstring() {
        assertTrue(manipulator.containsSubstring("HelloWorld", "World"));
        assertFalse(manipulator.containsSubstring("HelloWorld", "Test"));
    }
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    private PalindromeChecker checker;

    @BeforeEach
    void setUp() {
        checker = new PalindromeChecker();
    }

    @Test
    void testEmptyString() {
        assertTrue(checker.isPalindrome(""));
    }

    @Test
    void testSingleCharacter() {
        assertTrue(checker.isPalindrome("a"));
    }

    @Test
    void testPalindromeSimple() {
        assertTrue(checker.isPalindrome("radar"));
    }

    @Test
    void testPalindromeWithSpacesAndPunctuation() {
        assertTrue(checker.isPalindrome("A man, a plan, a canal, Panama"));
    }

    @Test
    void testNonPalindrome() {
        assertFalse(checker.isPalindrome("hello"));
    }

    @Test
    void testComplexNonPalindrome() {
        assertFalse(checker.isPalindrome("openai"));
    }
}
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne cc = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        assertTrue(palindrome.isPalindrome("goddog"));
        assertTrue(palindrome.isPalindrome("v"));
        assertTrue(palindrome.isPalindrome("RACECAR"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("PPOOiOOPP"));
        assertFalse(palindrome.isPalindrome("aerhahjejh"));
        assertFalse(palindrome.isPalindrome("Aa"));
        assertFalse(palindrome.isPalindrome("zhou"));
    }

    @Test
    public void testIsPalindrome2(){
        // override
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertTrue(palindrome.isPalindrome("zyzy", cc));
        assertTrue(palindrome.isPalindrome("yyxz", cc));
        assertTrue(palindrome.isPalindrome("yyyxz", cc));
        assertFalse(palindrome.isPalindrome("aa", cc));
        assertFalse(palindrome.isPalindrome("xyz", cc));
        assertFalse(palindrome.isPalindrome("aa", cc));
        assertFalse(palindrome.isPalindrome("zxzx", cc));
    }
}
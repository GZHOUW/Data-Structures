/** This interface defines a method for determining equality of characters. */
public interface CharacterComparator {
    /** returns true for characters that are different by exactly one. */
    boolean equalChars(char x, char y);
}

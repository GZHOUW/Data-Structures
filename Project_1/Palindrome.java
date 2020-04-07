public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new ArrayDeque<>();
        //Deque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            result.addLast(c);
        }
        return result;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        for (int i = 0; i < wordDeque.size() / 2; i++) {
            char first = wordDeque.removeFirst();
            char last = wordDeque.removeLast();
            if (first != last) {
                return false;
            }
        }
        return true;
    }

    // Overloads the isPalindrome(String word)
    // return true if the word is a palindrome according to the character comparison test (off by one palindrome)
    // provided by the CharacterComparator passed in as argument cc
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);
        for (int i = 0; i < wordDeque.size() / 2; i++) {
            char first = wordDeque.removeFirst();
            char last = wordDeque.removeLast();
            if (!cc.equalChars(first, last)) {
                return false;
            }
        }
        return true;
    }
}


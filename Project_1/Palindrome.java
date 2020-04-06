public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> result = new ArrayDeque<>();
        //Deque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            result.addLast(c);
        }
        return result;
    }

    public boolean isPalindrome(String word){
        Deque<Character> wordDeque = wordToDeque(word);
        for (int i = 0; i < wordDeque.size()/2; i++){
            char first = wordDeque.removeFirst();
            char last = wordDeque.removeLast();
            if (first != last){
                return false;
            }
        }
        return true;
    }
}

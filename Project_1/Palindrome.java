public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> result = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            result.addLast(c);
        }
        return result;
    }
    
}

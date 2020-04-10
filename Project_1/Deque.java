public interface Deque<type> {
    // Deque is a hypernym if LLDeque and ADeque

    // private void resize()   ----> Private methods should NOT be in interface

    // All the methods that BOTH LLDeque and ADeque have

    // // Interface inheritance: only signature
    public boolean isEmpty();

    public void addFirst(type x);

    public void addLast(type x);

    public type removeFirst();

    public type removeLast();

    public type get(int i);

    public int size();

    // Implementation inheritance: both signature and implementation
    default public void printDeque(){
        for (int i = 0; i < size(); i += 1){
            System.out.print(get(i)); // get() is fast for Array but slow for LinkedList
        }
        System.out.println();
    }

}

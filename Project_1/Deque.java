public interface Deque<type> {
    // Deque is a hypernym if LLDeque and ADeque

    // private void resize()   ----> Private methods should NOT be in interface

    // All the methods that BOTH LLDeque and ADeque have
    public boolean isEmpty();

    public void addFirst(type x);

    public void addLast(type x);

    public type removeFirst();

    public type removeLast();

    public type get(int i);

    public int size();

    public void printDeque();

}

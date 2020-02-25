/*
LECTURE 4
SLList is a list of integers*/

public class SLList {
    public IntNode first; // first = [item, next] where item is int, next is IntNode
    // private prevents other people/programs change first by using, for example, L.first.next.next = L.first.next

    private int size; // change size when initiating a SLList or adding elements

    public SLList(int x) { // first is the only thing in the SLList
        // constructor for SSList
        first = new IntNode(x, null); // first.item = x, first.next = null
        size = 1;
    }

    public SLList(){
        // Constructor for empty SLList
        first = null;
        size = 0;
    }

    public static void main(String[] args){
        // Create a list with one integer, 10
        SLList L = new SLList(2);
        L.addLast(3);
        L.addFirst(1);
        System.out.println(L.size());

    }

    // Nested class
    private static class IntNode { // static mean "never looks out" of this file
        public int item;
        public IntNode next;

        // Create a constructor
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }

    public void addFirst(int x){
        // add an integer in the front of the list
        first = new IntNode(x, first);
        size += 1;
    }

    public int getFirst(){
        // return the first element of the list
        return first.item;
    }

    public void addLast(int x){
        if (size != 0) {
            // add an integer in at the end of the list
            IntNode S = first; // S and first point at the same memory location -----> [1, 2, null]
            // S.next = [2, null]
            while (S.next != null) {
                S = first.next;  // S becomes [2, null], first is still [1,2,null], S and first.next point at the same memory location ----> [2, null]
                // S = S.next; works too
            }
            S.next = new IntNode(x, null); // S becomes [2,3,null], first becomes [1,2,3,null]
            size += 1;
        }
        else{
            first = new IntNode(x, null);
            size += 1;
        }
    }

    // size method for a SSList
    public int size(){
        //return size(this.first); // calls size method for IntNode [TOO SLOW]
        return size; // caching is MUCH FASTER, no matter how long list is
    }

}

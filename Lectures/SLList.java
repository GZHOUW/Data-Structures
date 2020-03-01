/*
LECTURE 4
SLList is a list of integers*/

public class SLList {
    // The first element of SSList will be at sentinel.next
    public IntNode sentinel; // sentinel = [item, next] where item is int, next is IntNode

    // private prevents other people/programs change first by using, for example, L.first.next.next = L.first.next
    private int size; // change size when initiating a SLList or adding elements

    public SLList(){
        // Constructor for SLList with 0 starting element , only has a sentinel node in it
        sentinel = new IntNode(34567, null); // sentinel.item does NOT matter
        size = 0;
    }
    public SLList(int x) {
        // constructor for SSList with one starting element
        sentinel = new IntNode(34567, null); // first.item = x, first.next = null
        sentinel.next = new IntNode(x, null);
        size = 1;
    }


    public static void main(String[] args){
        // Create a list with one integer, 10
        SLList L = new SLList(2);
        L.addFirst(1);
        L.addLast(3);
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
        // add an integer right after sentinel
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public int getFirst(){
        // return the first element of the list
        return sentinel.next.item;
    }

    public void addLast(int x){
        // add an integer in at the end of the list
        if (size != 0) {
            IntNode S = sentinel; // S & sentinel-----> [34567, 1, 2, null]
            // S.next = [1, 2, null]
            while (S.next != null) {
                S = S.next;  // sentinel------>[34567, 1,2,null], S & sentinel.next ------> [1, 2, null]
                             // sentinel------>[34567, 1,2,null], sentinel.next ------> [1, 2, null], S----->[2, null]
            }
            S.next = new IntNode(x, null); // S becomes [2,3,null], first becomes [1,2,3,null]
            size += 1;
        }
        else{
            addFirst(x); // add first is same as add last if list is empty
            size += 1;
        }
    }

    // size method for a SSList
    public int size(){
        //return size(this.first); // calls size method for IntNode [TOO SLOW]
        return size; // caching is MUCH FASTER, no matter how long list is
    }

}

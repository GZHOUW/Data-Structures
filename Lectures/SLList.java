/*
LECTURE 4
SLList is a list of integers*/

public class SLList {
    public IntNode first; // first = [item, next] where item is int, next is IntNode
    // private prevents other people/programs change first by using, for example, L.first.next.next = L.first.next

    // constructor for SSList
    public SLList(int x) { // first is the only thing in the SLList
        first = new IntNode(x, null); // first.item = x, first.next = null
    }

    public static void main(String[] args){
        // Create a list with one integer, 10
        SLList L = new SLList(1);
        L.addLast(2);
        L.addLast(3);

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

        public void addLast_recursive(int x){
            // add an integer in at the end of the list
            if (this.next != null){
                this.next.addLast_recursive(x);
            }
            else {
                this.next = new IntNode(x, null);
            }
        }
    }

    public void addFirst(int x){
        // add an integer in the front of the list
        first = new IntNode(x, first);
    }

    public int getFirst(){
        // return the first element of the list
        return first.item;
    }

    public void addLast(int x){
        // add an integer in at the end of the list
        IntNode S = first; // S and first point at the same memory location
        while (S.next != null){
            S = first.next;  // S becomes [2, null], first is still [1,2,null]
        }
        S.next = new IntNode(x, null); // S becomes [2,3,null], first becomes [1,2,3,null]
    }


}

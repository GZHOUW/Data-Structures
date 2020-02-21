/*
LECTURE 4
SLList is a list of integers*/

public class SLList {

    private class IntNode {
        public int item;
        public IntNode next;

        // Create a constructor
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }

    private IntNode first; // first = [item, next] where item is int, next is IntNode
    // private prevents other people/programs change first by using, for example, L.first.next.next = L.first.next

    public SLList(int x){ // first is the only thing in the SLList
        first = new IntNode(x, null); // first.item = x, first.next = null
    }

    public void addFirst(int x){
        // add an integer in the front of the list
        first = new IntNode(x, first);
    }

    public int getFirst(){
        // return the first element of the list
        return first.item;
    }

    public static void main(String[] args){
        // Create a list with one integer, 10
        SLList L = new SLList(10);
        L.addFirst(5);
        System.out.println(L.getFirst());
    }
}

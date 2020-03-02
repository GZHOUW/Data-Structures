/*
LECTURE 4
SLList is a list of integers*/

public class SLList<DataType> { // DataType can be integer, string, ect.
    // The first element of SSList will be at sentinel.next
    public DataNode sentinel; // sentinel = [item, next] where item is int, next is IntNode

    // private prevents other people/programs change first by using, for example, L.first.next.next = L.first.next
    private int size; // change size when initiating a SLList or adding elements

    public SLList(){
        // Constructor for SLList with 0 starting element , only has a sentinel node in it
        sentinel = new DataNode(null, null); // sentinel.item does NOT matter
        size = 0;
    }
    public SLList(DataType x) {
        // constructor for SSList with one starting element
        sentinel = new DataNode(null, null); // first.item = x, first.next = null
        sentinel.next = new DataNode(x, null);
        size = 1;
    }


    public static void main(String[] args){
        // Create a list with one integer, 10
        SLList<Integer> L = new SLList<Integer>(2); // Specify data type when initiating SSList
        L.addFirst(1);
        L.addLast(3);
        // System.out.println(L.size());

        SLList<String> L2 = new SLList<>("Hello World");
        System.out.println(L2.getFirst());

    }

    // Nested class
    private class DataNode { // static mean "never looks out" of this file
        public DataType item;
        public DataNode next;

        // Create a constructor
        public DataNode(DataType i, DataNode n){
            item = i;
            next = n;
        }
    }

    public void addFirst(DataType x){
        // add an integer right after sentinel
        sentinel.next = new DataNode(x, sentinel.next);
        size += 1;
    }

    public DataType getFirst(){
        // return the first element of the list
        return sentinel.next.item;
    }

    public void addLast(DataType x){
        // add an integer in at the end of the list
        if (size != 0) {
            DataNode S = sentinel; // S & sentinel-----> [34567, 1, 2, null]
            // S.next = [1, 2, null]
            while (S.next != null) {
                S = S.next;  // sentinel------>[34567, 1,2,null], S & sentinel.next ------> [1, 2, null]
                             // sentinel------>[34567, 1,2,null], sentinel.next ------> [1, 2, null], S----->[2, null]
            }
            S.next = new DataNode(x, null); // S becomes [2,3,null], first becomes [1,2,3,null]
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

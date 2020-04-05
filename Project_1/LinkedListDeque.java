public class LinkedListDeque<type> implements Deque<type>{
    private int size;
    private node sentinel;

    private class node{
        node prev;
        type item;
        node next;

        public node(node p, type i, node n){
            prev = p;
            item = i;
            next = n;
        }
    }

    public LinkedListDeque(){
        size = 0;
        sentinel = new node(null, null, null); // circular sentinel
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public LinkedListDeque(LinkedListDeque other){
        // deep copy
        size = 0;
        sentinel = new node(null, null, null); // circular sentinel
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

        for (int i = 0; i < other.size(); i++){
            addLast((type) other.get(i));
        }
    }

    public static void main(String[] args){
        LinkedListDeque<Integer> A = new LinkedListDeque<Integer>();
        A.addFirst(3);
        A.addFirst(2);
        A.addFirst(1);
        A.addLast(4);
        A.removeLast();
        A.printDeque();
    }

    public void addFirst(type x){
        if (this.isEmpty()){
            sentinel.next = new node(sentinel, x, sentinel);
            sentinel.prev = sentinel.next; // must change both next and prev of sentinel
            size += 1;
        }
        else{
            sentinel.next = new node(sentinel, x, sentinel.next);
            sentinel.next.next.prev = sentinel.next;

            size += 1;
        }
    }

    public void addLast(type x){
        if (isEmpty()) {
            addFirst(x); // addFirst changes size, no need to add again
        }
        else{
            sentinel.prev = new node(sentinel.prev, x, sentinel);
            sentinel.prev.prev.next = sentinel.prev;
            size += 1;
        }
    }

    public type removeFirst(){
        type temp = sentinel.next.item; // first item, to be removed
        sentinel.next.next.prev = sentinel; // set the prev of 2nd item as sentinel
        sentinel.next =  sentinel.next.next; // set the next of sentinel as the second item
        size -= 1;
        return temp;
    }

    public type removeLast(){
        type temp = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return temp;
    }

    public type get(int index){
        if (isEmpty() || index >= size) {
            return null;
        }
        else{
            node temp = sentinel;
            for (int i = 0; i <= index; i++){
                temp = temp.next; // move forward until the index item
            }
            return temp.item;
        }
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i = 0; i < size; i++){
            System.out.print(get(i));
            System.out.print(' ');
        }
        System.out.println();
    }

}

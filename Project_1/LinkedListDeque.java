public class LinkedListDeque<type> {
    private int size;
    private node sentinel;

    private class node{
        node prev;
        type item;
        node next;

        public node(node p, type i, node n){
            this.prev = p;
            this.item = i;
            this.next = n;
        }
    }
    public LinkedListDeque(){
        size = 0;
        sentinel = new node(sentinel, null, sentinel); // circular sentinel
    }

    public static void main(String[] args){
        LinkedListDeque<Integer> A = new LinkedListDeque<Integer>();
        A.addFirst(10);
        A.addFirst(9);
        A.addLast(11);
        A.printDeque();
    }
    public void addFirst(type x){
        if (isEmpty()){
            size += 1;
            sentinel.next = new node(sentinel, x, sentinel);
        }
        else{
            size += 1;
            sentinel.next = new node(sentinel, x, sentinel.next);
            sentinel.next.next.prev = sentinel.next;
        }

    }

    public void addLast(type x){
        if (isEmpty()) {
            size += 1;
            addFirst(x);
        }
        else{
            node temp = sentinel; // change temp does NOT change sentinel
            while (temp.next != sentinel){
                temp = temp.next; // move forward until the last item
            }
            temp.next = new node(temp, x, sentinel);
            size += 1;
        }
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        else{
            return false;
        }
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

    public void removeFirst(){
        sentinel.next.next.prev = sentinel;
        sentinel.next =  sentinel.next.next;
        size -= 1;
    }

    public void removeLast(){
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
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

}

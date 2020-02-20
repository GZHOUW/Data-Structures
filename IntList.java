public class IntList {
    // an IntList has two elements, the first is an integer, and the second is another IntList
    public int first;
    public IntList rest;

    // Create a constructor
    public IntList(int f, IntList r){
        first = f; // self.first = f
        rest = r;
    }

    public static void main(String[] args){
        IntList L = new IntList(15, null); // Create a new IntList object: [15, null]
        L = new IntList(10, L); // L becomes [10, [15, null] ]
        L = new IntList(5, L); // L becomes [5, [10, [15, null] ] ]
        System.out.println(L.size());
        System.out.println(L.interativeSize());
        System.out.println(L.get(2));
        System.out.println(L.interativeGet(2));
    }

    // return the size of list using recursion
    public int size() {
        if (rest == null) { // Only one element (first) in the list, rest is null
            return 1;
        }
        return 1 + this.rest.size(); // this = self
    }

    // return the size of list using iteration
    public int interativeSize(){
        IntList i = this;
        int size = 0;
        while (i != null){
            size ++;
            i = i.rest;
        }
        return size;
    }

    public int get(int index){
        if (index == 0){
            return first;
        }
        return rest.get(index - 1);
    }


    // return the i th element of the list
    public int interativeGet(int index){
        int element = 0;
        int i = -1;
        IntList p = this;
        while (i < index){
            element = p.first;
            p = p.rest;
            i ++;
        }
        return element;
    }
}
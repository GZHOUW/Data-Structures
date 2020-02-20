public class IntList {
    // an IntList has two elements, the first is an integer, and the second is another IntList
    public int first;
    public IntList rest;

    // Create a constructor
    public IntList(int f, IntList r){
        f = first;
        r = rest;
    }

    // return the size of list using recursion
    public int size(){
        if (rest == null) { // Only one element (first) in the list, rest is null
            return 1;
        }
        return 1 + this.rest.size(); // this = self
    }
    public static void main(String[] args){
        IntList L = new IntList(15, null); // Create a new IntList object: [15, null]
        L = new IntList(10, L); // L becomes [10, [15, null] ]
        L = new IntList(5, L); // L becomes [5, [10, [15, null] ] ]
        System.out.println(L);
    }
}

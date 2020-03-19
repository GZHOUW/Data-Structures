public class AList<item> {
    private item[] items;
    private int size;

    public AList(){
        // create empty list
        items = (item[]) new Object[100];
        size = 0;
    }

    public static void main(String[] args){
        AList A = new AList();
        int i = 0;
        while (i < 100000){
            A.addLast(i);
            i ++;
        }
    }

    private void resize(int n){
        // item[] newList = new item[n]; ---------> Error: generic arrays are not allowed
        item[] newList = (item[]) new Object[n]; // a cast
        // parameters: old array, start pos, new array, start pos, num of items
        System.arraycopy(items, 0, newList, 0, size);
        items = newList; // discard the old list
    }
    public void addLast(item x){
        // Insert x at the back of the list, or set list[size] = x
        if (size ==  items.length){
            // resize(size + 1); ------> too slow
            resize(size * 2); // fast
        }
        items[size] = x;
        size ++;
    }

    public item getLast(){
        // Return the item at the back of the list
        return items[size - 1]; //last index is always size-1
    }

    public item removeLast(){
        // delete the last item and return it
        item last = getLast();
         items[size - 1] = null; // delete the last item, save memory
        size --;
        return last;
    }

    public item get(int i){
        // return the ith item in the list, where 0 is the first one
        return items[i];
    }

    public int size(){
        return size;
    }

}

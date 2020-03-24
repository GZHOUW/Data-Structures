public class ArrayDeque<type> {
    private type[] items;
    private int size;
    private float usageRate;
    private int firstNext;
    private int lastNext;

    public ArrayDeque(){
        items = (type[]) new Object[8]; // initially all null
        size = 0;
        usageRate = 0;
        firstNext = 0; // one idx before the first element of the array
        lastNext = 1;

    }

    public ArrayDeque(ArrayDeque other){
        items = (type[]) new Object[other.size()];
        size = 0;
        usageRate = 0;
        firstNext = 0;
        lastNext = 1;

        System.arraycopy(items, 0, other, 0, other.size());
    }

    private void resize(){
        if (usageRate < 0.25 && items.length > 16){ // shrink size by factor 2
            int newSize = items.length / 2;
            type[] newArray = (type[]) new Object[newSize];
            int firstItem = 0;
            for (int i = 0; i < items.length - 1; i++) {
                // always a null in the beginning of array?
                if (items[i] == null && items[i + 1] != null) {
                    firstItem = i + 1;
                }
            }
            System.arraycopy(items, firstItem, newArray, 1, size);
            items = newArray; // discard the old list

            firstNext = 0;
            lastNext = size;

        }

        if (size == items.length){ // expand size by factor 2
            int newSize = items.length * 2;
            type[] newArray = (type[]) new Object[newSize];
            // parameters: old array, start pos, new array, start pos, num of items
            System.arraycopy(items, 0, newArray, 1, size);
            items = newArray; // discard the old list

            firstNext = 0;
            lastNext = size;
        }

    }

    public boolean isEmpty(){
        return size == 0;
    }


    public void addFirst(type x){
        resize();
        items[firstNext] = x;
        size += 1;
        usageRate = (float) size / (float) items.length;
        // pull firstNext to front by 1
        if (firstNext == 0){
            firstNext = items.length - 1;
        }
        else{
            firstNext -= 1;
        }
    }

    public void addLast(type x){
        // Insert x at the back of the list, or set list[size] = x
        resize();
        items[lastNext] = x;
        size += 1;
        usageRate = (float) size / (float) items.length;
        // push move lastNext back by 1
        if (lastNext == items.length - 1){
            lastNext = 0;
        }
        else{
            lastNext += 1;
        }
    }

    public void removeFirst(){
        // delete the first item and return it
        int firstItem;
        if (firstNext == items.length - 1){
            firstItem = 0;
        }
        else{
            firstItem = firstNext + 1;
        }
        items[firstItem] = null; // delete the last item, save memory
        size -= 1;
        usageRate = (float) size / (float) items.length;
        firstNext = firstItem;
        resize();

    }
    
    public void removeLast(){
        // delete the last item and return it
        int lastItem;
        if (lastNext == 0){
            lastItem = items.length - 1;
        }
        else{
            lastItem = lastNext - 1;
        }
        items[lastItem] = null; // delete the last item, save memory
        size -= 1;
        usageRate = (float) size / (float) items.length;
        lastNext = lastItem;
        resize();
    }


    public type get(int i){
        // return the ith item in the list, where 0 is the firstNext one
        return items[i];
    }

    public int size(){
        return size;
    }


    public void printDeque(){
        for (int i = 0; i < items.length; i++){
            System.out.print(get(i));
            System.out.print(' ');
        }
        System.out.println();
    }


    public static void main(String[] args){
        ArrayDeque A = new ArrayDeque();
        A.addLast(2);
        A.printDeque();
        A.addLast(3);
        A.printDeque();
        A.removeFirst();
        A.printDeque();
        A.removeLast();
        A.printDeque();
        System.out.println(A.size());

    }
}
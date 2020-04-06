public class ArrayDeque<type> implements Deque<type>{
    private type[] items;
    private int size;
    private float usageRate;
    private int firstNext;
    private int lastNext;

    public ArrayDeque(){
        items = (type[]) new Object[8];
        size = 0;
        usageRate = 0;
        firstNext = 0; // one idx before the first element of the array
        lastNext = 1; // one idx after the last element of the array

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

            int first = getFirst();

            int size1 = size - first;
            // parameters: old array, start pos, new array, start pos, num of items
            System.arraycopy(items, first, newArray, 0, size1);
            System.arraycopy(items, 0, newArray, size1, size - size1);

            items = newArray; // discard the old list

            firstNext = items.length - 1;
            lastNext = size;
        }

    }

    private int getFirst(){
        int first;
        if (firstNext == items.length - 1){
            first = 0;
        }
        else{
            first = firstNext + 1;
        }
        return first;
    }

    private int getLast(){
        int last;
        if (lastNext == 0){
            last = items.length - 1;
        }
        else{
            last = lastNext - 1;
        }
        return last;
    }


    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
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
    @Override
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

    @Override
    public type removeFirst(){
        // delete the first item and return it
        int first = getFirst();

        type temp = items[first];
        items[first] = null; // delete the last item, save memory
        size -= 1;
        usageRate = (float) size / (float) items.length;
        firstNext = first;
        resize();
        return temp;
    }

    @Override
    public type removeLast(){
        // delete the last item and return it
        int last = getLast();
        type temp = items[last];
        items[last] = null; // delete the last item, save memory
        size -= 1;
        usageRate = (float) size / (float) items.length;
        lastNext = last;
        resize();
        return temp;
    }

    @Override
    public type get(int i){
        // return the ith item in the list, NOT including Null
        if (firstNext + i + 1 > items.length - 1){
            // [4 5 null null 1 2 3] --> firstNext = 3 --> get(4) --> 3 + 4 + 1 - 7 = 1
            return items[firstNext + i + 1 - items.length];
        }
        else{
            // firstNext = 3 --> get(1) --> 3 + 1 + 1 = 5
            return items[firstNext + i + 1];
        }
    }
    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        for (int i = 0; i < size; i++){
            System.out.print(get(i));
            System.out.print(' ');
        }
        System.out.println();
    }
}

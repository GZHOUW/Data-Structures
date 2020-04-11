import java.util.Iterator;

public class ArraySet<T> implements Iterable<T> { // implements Iterable<T> -----> this class has an iterator method
    private T[] items;
    private int size; // the next item to be added will be at position size

    public ArraySet() {
        items = (T[]) new Object[100]; // new array
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i += 1) {
            if (items[i].equals(x)) { // cannot use x == items[i]
                return true;
            }
        }
        return false;
    }

    public void add(T x) {
        if (x == null) { // adding null will cause null pointer error in contain()
            throw new IllegalArgumentException("can't add null"); // explicit exception
        }
        if (contains(x)) { // Set cannot contain duplicates
            return;
        }
        items[size] = x;
        size += 1;
    }

    public int size() {
        return size;
    }

    /** create and return an iterator*/
    public Iterator<T> iterator() { // method "iterator" is in the iterable interface
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int index;

        public ArraySetIterator() {
            index = 0;
        }

        public boolean hasNext() { // check if there is a next item
            return index < size;
        }

        public T next() {
            T current = items[index]; // return the current item
            index += 1; // move to next item
            return current;
        }
    }

    @Override
    public String toString() {
        StringBuilder returnSB = new StringBuilder("{");
        for (int i = 0; i < size - 1; i += 1) {
            returnSB.append(items[i].toString());
            returnSB.append(", ");
        }
        returnSB.append(items[size - 1]);
        returnSB.append("}");
        return returnSB.toString();
    }

    /* EXTRA VIDEO CODE
    @Override
    public String toString() {
        List<String> listOfItems = new ArrayList<>();
        for (T x : this) {
            listOfItems.add(x.toString());
        }
        return "{" + String.join(", ", listOfItems) + "}";
    } */

    /* EXTRA VIDEO CODE
    public static <Glerp> ArraySet<Glerp> of(Glerp... stuff) {
        ArraySet<Glerp> returnSet = new ArraySet<Glerp>();
        for (Glerp x : stuff) {
            returnSet.add(x);
        }
        return returnSet;
    } */


    @Override
    public boolean equals(Object other) { // ALL classes inherit Object
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if (o.size() != this.size()) {
            return false;
        }
        for (T item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        //iteration, print every element in aset
        for (int i : aset) {
            System.out.println(i);
        }

        //toString
        System.out.println(aset);


        //EXTRA VIDEO CODE
        //ArraySet<String> asetOfStrings = ArraySet.of("hi", "I'm", "here");
        //System.out.println(asetOfStrings);
    }
}
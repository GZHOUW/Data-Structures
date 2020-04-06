public class TestInheritance {
    // return the length of the longest string
    public static String longest(Deque<String> list) {
        int maxIdx = 0;
        for (int i = 1; i < list.size(); i += 1) {
            String longestStr = list.get(maxIdx);
            String thisStr = list.get(i);

            if (thisStr.length() > longestStr.length()) {
                maxIdx = i;
            }
        }
        return list.get(maxIdx);
    }

    public static void main(String[] args){
        ArrayDeque<Character> L = new ArrayDeque<>();
        //LinkedListDeque<String> L = new LinkedListDeque<>();
        L.addLast('p');
        L.addLast('e');
        L.addLast('r');
        L.addLast('s');
        L.addLast('i');
        L.addLast('f');
        L.addLast('l');
        L.addLast('a');
        L.addLast('g');
        L.addLast('e');

        L.printDeque();
    }
}


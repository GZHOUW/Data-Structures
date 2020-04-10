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
        LinkedListDeque<Character> L = new LinkedListDeque<Character>();
        L.addLast('c');
        L.addLast('l');
        L.addLast('e');
        L.addLast('a');
        L.addLast('v');
        L.addLast('e');
        L.addLast('r');
        L.printDeque();

        Deque<Character> L2 = new LinkedListDeque<Character>();
        L2.addLast('c');
        L2.addLast('l');
        L2.addLast('e');
        L2.addLast('a');
        L2.addLast('n');
        L2.addLast('s');
        L2.addLast('e');
        L2.printDeque(); // will use the printDeque in LLDeque
    }
}


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
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addFirst("is");
        L.addLast("mine");
        L.addFirst("Frelford");
        L.addLast("!");
        L.removeLast();
        L.printDeque();
        System.out.println(longest(L));
    }
}


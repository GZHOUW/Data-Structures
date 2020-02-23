public class WalrusDemo {
    public static void main(String[] args) {
        Walrus walrus = new Walrus(3500, 10.5);
        int x = 9;
    }

    public static void doStuff(Walrus W, int x) {
        W.weight -= 100; // affects Walrus in main because object is reference type
        x -= 5; // Does not pass back to main, x only changes in the local scope
    }

    public static class Walrus {
        public int weight;
        public double size;

        public Walrus(int w, double s) {
            weight = w;
            size = s;
        }
    }

}

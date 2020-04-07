public class OffByN implements CharacterComparator{
    public int N;

    //constructor
    public OffByN(int n){
        N = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return x - y == N || y - x == N;
    }
}

public class NBody {
    // A class that will run the simulation
    public static double readRadius(String fileName){
        In file = new In(fileName);
        int n = file.readInt(); // number of planets
        double r_universe = file.readDouble();

        return r_universe;
    }

    public static Body[] readBodies(String fileName) {
        In file = new In(fileName);
        int n = file.readInt(); // number of planets
        double r_universe = file.readDouble();
        Body[] body_array;
        body_array = new Body[n];


        for (int i = 0; i < n; i++) {
            double x = file.readDouble();
            double y = file.readDouble();
            double vx = file.readDouble();
            double vy = file.readDouble();
            double m = file.readDouble();
            String img = file.readString();
            body_array[i] = new Body(x, y, vx, vy, m, img);

        }
        return body_array;
    }

    public static void main(String[] args){

    }
}

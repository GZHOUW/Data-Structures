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

    public static void main(String[] args) {

        String filename = "planets.txt";
        String universe_pic = "images/starfield.jpg";
        double r_universe = readRadius(filename);
        Body[] body_array = readBodies(filename);
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-2*r_universe, 2*r_universe); //Sets up the range
        StdDraw.clear(); // clear window
        StdDraw.picture(-r_universe, r_universe, universe_pic);
        for (int i = 0; i < body_array.length; i++){
            body_array[i].draw();
        }
        StdDraw.show();
        StdDraw.pause(2000);
    }

}

import static java.lang.StrictMath.*;

public class Body {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    String imgFileName;
    public static final double G = 6.67e-11;

    public Body(double xP, double yP, double xV, double yV, double m, String img){
        // Body class can represent a planet, star, or various objects in this universe.
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b){
        //  take in a Body object and initialize an identical Body object
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b){
        double dx = (this.xxPos - b.xxPos);
        double dy = (this.yyPos - b.yyPos);
        return sqrt(dx*dx + dy*dy);
    }

    public double calcForceExertedBy(Body b){
        double d = this.calcDistance(b);
        double F = G * this.mass * b.mass / (d*d);
        return F;
    }

    public double calcForceExertedByX(Body b){
        if (b.xxPos > this.xxPos){
            return cos(this.calcForceExertedBy(b));
        }
        else {
            return -cos(this.calcForceExertedBy(b));
        }
    }

    public double calcForceExertedByY(Body b){
        if (b.yyPos > this.yyPos) {
            return sin(this.calcForceExertedBy(b));
        }
        else{
            return -sin(this.calcForceExertedBy(b));
        }
    }

    public double calcNetForceExertedByX(Body[] b_array){
        double Fx_net = 0;
        for (int i = 0; i < b_array.length; i++){
            Fx_net += this.calcForceExertedByX(b_array[i]);
        }
        return Fx_net;
    }
    public double calcNetForceExertedByY(Body[] b_array){
        double Fy_net = 0;
        for (int i = 0; i < b_array.length; i++){
            Fy_net += this.calcForceExertedByY(b_array[i]);
        }
        return Fy_net;
    }

    public void update(double dt, double Fx, double Fy){
        double ax = Fx / this.mass;
        double ay = Fy / this.mass;
        this.xxVel = this.xxVel + dt * ax;
        this.yyVel = this.yyVel + dt * ay;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, this.imgFileName);
    }

}

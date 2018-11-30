package pack;

public class Point {

    public double x;
    public double y;

    public Point(double x,double y)
    {
        this.x=x;
        this.y=y;

    }

    public double distance(Point p) {
        double X = this.x - p.x;
        double Y = this.y - p.y;
        return Math.sqrt(X*X + Y*Y);

    }
}

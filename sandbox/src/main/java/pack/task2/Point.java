package pack.task2;

public class Point {

    public double x;
    public double y;

    public Point(double x,double y)
    {
        this.x=x;
        this.y=y;

    }

    public double distance(double x,double y) {
        double X = this.x - x;
        double Y = this.y - y;
        return Math.sqrt(X*X + Y*Y);
    }
    public double distance(Point p) {
        return distance(p.x, p.y);
    }
}

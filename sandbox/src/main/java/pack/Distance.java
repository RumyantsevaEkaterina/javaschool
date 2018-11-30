package pack;

public class Distance {

    public static void main(String[] args) {
        Point p1 = new Point(4.0,0.0);
        Point p2 = new Point(0.0,3.0);
        double D = p1.distance(p2);
        System.out.println("Расстояние между двумя точками P1 и P2 с координатами " + p1.x +";"+ p1.y + " и " + p2.x +";"+ p2.y +" равно " + D);
    }


}

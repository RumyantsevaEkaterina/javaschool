package pack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void DistanceNot0() {
        Point p1 = new Point(4.0,0.0);
        Point p2 = new Point(0.0,3.0);
        Assert.assertTrue(p1.distance(p2) > 0);
    }//проверка,что расстояние больше 0

    @Test
    public void verifyDistance() {
        Point p1 = new Point(4.0,0.0);
        Point p2 = new Point(0.0,3.0);
        Assert.assertTrue(p1.distance(p2) == 5.0);
    } //проверка,что расстояние считается корректно
}

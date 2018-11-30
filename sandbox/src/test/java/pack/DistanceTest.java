package pack;

import org.testng.annotations.Test;
import pack.Point;

public class DistanceTest {

    @Test
    public void testDistance () {
        Point p1 = new Point(4.0,0.0);
        Point p2 = new Point(0.0,3.0);
        assert p1.distance(p2) == 5.0;
    }
}

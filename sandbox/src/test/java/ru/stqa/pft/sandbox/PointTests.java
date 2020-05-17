package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistanceOne() {
    Point p1 = new Point(0,0);
    Point p2 = new Point(1,1);

    Assert.assertEquals(p1.distanceInClass(p2), 1.4142135623730951);
  }

  @Test
  public void testDistanceTwo() {
    Point p1 = new Point(1,1);
    Point p2 = new Point(2,2);

    Assert.assertEquals(p1.distanceInClass(p2), 1.4142135623730951);
  }

  @Test
  public void testDistanceThree() {
    Point p1 = new Point(1,1);
    Point p2 = new Point(0,0);

    Assert.assertEquals(p1.distanceInClass(p2), 1.4142135623730951);
  }

  @Test
  public void testDistanceFour() {
    Point p1 = new Point(2,2);
    Point p2 = new Point(1,1);

    Assert.assertEquals(p1.distanceInClass(p2), 1.4142135623730951);
  }

}

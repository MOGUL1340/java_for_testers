package ru.stqa.pft.sandbox;

public class Point {

  public double x;
  public double y;

  public Point (double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distanceInClass(Point p2){
    double xDistance = p2.x - this.x;
    double yDistance = p2.y - this.y;
    return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
  }

}

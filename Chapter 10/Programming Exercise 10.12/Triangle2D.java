
/**
 * (Geometry: the Triangle2D class) Define the Triangle2D class that contains:
 *
 * ■ Three points named p1, p2, and p3 of the type MyPoint with getter and
 * setter methods. MyPoint is defined in Programming Exercise 10.4.
 * ■ A no-arg constructor that creates a default triangle with the points (0, 0), (1,
 * 1), and (2, 5).
 * ■ A constructor that creates a triangle with the specified points.
 * ■ A method getArea() that returns the area of the triangle.
 * ■ A method getPerimeter() that returns the perimeter of the triangle.
 * ■ A method contains(MyPoint p) that returns true if the specified point
 * p is inside this triangle (see Figure 10.22a).
 * ■ A method contains(Triangle2D t) that returns true if the specified
 * triangle is inside this triangle (see Figure 10.22b).
 * ■ A method overlaps(Triangle2D t) that returns true if the specified
 * triangle overlaps with this triangle (see Figure 10.22c).
 *
 * Draw the UML diagram for the class and then implement the class. Write
 * a test program that creates a Triangle2D objects t1 using the constructor
 * new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3),
 * new MyPoint(5, 3.5)), displays its area and perimeter, and displays the
 * result of t1.contains(3, 3), r1.contains(new Triangle2D(new
 * MyPoint(2.9, 2), new MyPoint(4, 1), MyPoint(1, 3.4))), and t1.
 * overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4,
 * -3), MyPoint(2, 6.5))).
 *
 * (Hint: For the formula to compute the area of a triangle, see Programming Exercise
 * 2.19. To detect whether a point is inside a triangle, draw three dashed lines,
 * as shown in Figure 10.23. If the point is inside a triangle, each dashed line
 * should intersect a side only once. If a dashed line intersects a side twice, then
 * the point must be outside the triangle. For the algorithm of finding the intersecting
 * point of two lines, see Programming Exercise 3.25.)
 *
 * @author martinfall
 */
public class Triangle2D {

    // Three points named p1, p2, and p3 of the type MyPoint with getter and
    // setter methods. MyPoint is defined in Programming Exercise 10.4.
    private MyPoint p1, p2, p3;

    public MyPoint getP1() {
        return p1;
    }

    public MyPoint getP2() {
        return p2;
    }

    public MyPoint getP3() {
        return p3;
    }

    /**
     * A no-arg constructor that creates a default triangle with the points (0,
     * 0), (1,
     * 1), and (2, 5).
     */
    public Triangle2D() {
        this.p1 = new MyPoint(0, 0);
        this.p2 = new MyPoint(1, 1);
        this.p3 = new MyPoint(2, 5);
    }

    /**
     * A constructor that creates a triangle with the specified points.
     *
     * @param p1
     * @param p2
     * @param p3
     */
    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    /**
     * A method getArea() that returns the area of the triangle.
     *
     * @return
     */
    public double getArea() {
        double side1 = distance(this.p1, this.p2);
        double side2 = distance(this.p2, this.p3);
        double side3 = distance(this.p3, this.p1);
        double s = (side1 + side2 + side3) / 2.0;

        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    /**
     * A method getPerimeter() that returns the perimeter of the triangle.
     *
     * @return
     */
    public double getPerimeter() {
        double side1 = distance(this.p1, this.p2);
        double side2 = distance(this.p2, this.p3);
        double side3 = distance(this.p3, this.p1);

        return side1 + side2 + side3;
    }

    /**
     * Distance between MyPoint a and MyPoint b
     *
     * @param a
     * @param b
     * @return
     */
    public static double distance(MyPoint a, MyPoint b) {
        double x1 = a.getX();
        double y1 = a.getY();
        double x2 = b.getX();
        double y2 = b.getY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    /**
     * A method contains(MyPoint p) that returns true if the specified point
     * p is inside this triangle (see Figure 10.22a).
     *
     * @param p
     * @return
     */
    public boolean contains(MyPoint p) {
        Triangle2D t1 = new Triangle2D(this.p1, this.p2, p);
        Triangle2D t2 = new Triangle2D(this.p2, this.p2, p);
        Triangle2D t3 = new Triangle2D(this.p3, this.p1, p);

        // I used a different method from the one suggested in the book to check
        // if p is inside the calling Triangle2D object.
        // The area of the 3 triagles centers at MyPoint p is equal to 
        // the area of the calling object, then the point p is inside the calling
        // Triangle2D object
        return (t1.getArea() + t2.getArea() + t3.getArea() == this.getArea());
    }

    /**
     * A method contains(Triangle2D t) that returns true if the specified
     * triangle is inside this triangle (see Figure 10.22b).
     *
     * @param t
     * @return
     */
    public boolean contains(Triangle2D t) {
        return contains(t.getP1()) && contains(t.getP2()) && contains(t.getP3());
    }

    /**
     * A method overlaps(Triangle2D t) that returns true if the specified
     * triangle overlaps with this triangle (see Figure 10.22c).
     *
     * @param t
     * @return
     */
    public boolean overlaps(Triangle2D t) {
        // Three points of the calling object
        double x1 = this.getP1().getX();
        double y1 = this.getP1().getY();
        double x2 = this.getP2().getX();
        double y2 = this.getP2().getY();
        double x3 = this.getP3().getX();
        double y3 = this.getP3().getY();

        // Three points of the parameter object
        double xt1 = t.getP1().getX();
        double yt1 = t.getP1().getY();
        double xt2 = t.getP2().getX();
        double yt2 = t.getP2().getY();
        double xt3 = t.getP3().getX();
        double yt3 = t.getP3().getY();

        // The two triangles intersect if one of the sides of t intersects
        // one of the lines of the calling Triangle2D object
        
        // Does line (x1, y1)(x2, y2) intersect any of the lines of t
        boolean a1 = intersects(x1, y1, x2, y2, xt1, yt1, xt2, yt2);
        boolean a2 = intersects(x1, y1, x2, y2, xt2, yt2, xt3, yt3);
        boolean a3 = intersects(x1, y1, x2, y2, xt3, yt3, xt1, yt1);
        
        // Does line (x2, y2)(x3, y3) intersect any of the lines of t
        boolean b1 = intersects(x2, y2, x3, y3, xt1, yt1, xt2, yt2);
        boolean b2 = intersects(x2, y2, x3, y3, xt2, yt2, xt3, yt3);
        boolean b3 = intersects(x2, y2, x3, y3, xt3, yt3, xt1, yt1);
        
        // Does line (x3, y3)(x1, y1) intersect any of the lines of t
        boolean c1 = intersects(x3, y3, x1, y1, xt1, yt1, xt2, yt2);
        boolean c2 = intersects(x3, y3, x1, y1, xt2, yt2, xt3, yt3);
        boolean c3 = intersects(x3, y3, x1, y1, xt3, yt3, xt1, yt1);
        
        // The two triangles intersect if one of the sides of t intersects
        // one of the lines of the calling Triangle2D object
        return (a1 || a2 || a3 || b1 || b2 || b3 || c1 || c2 || c3);
    }

    /**
     * Returns true if the lines P1P2 and P3P4 intersect.
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @param x4
     * @param y4
     * @return
     */
    public boolean intersects(double x1, double y1, double x2, double y2,
            double x3, double y3, double x4, double y4) {
        return (y1 - y2) * (x3 - x4) - (x1 - x2) * (y3 - y4) != 0;
    }
}

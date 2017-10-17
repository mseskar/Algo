/******************************************************************************
 *  Compilation:  javac Koch.java
 *  Execution:    java Koch n
 *  Dependencies: Turtle.java
 *
 *  Plot a Koch curve of order n.
 *
 *  % java Koch 5
 *
 ******************************************************************************/

public class Koch {
    private static int original;
    private static double area;
    // plot Koch curve of order n, with given step size
    public static void koch(int n, double step, Turtle turtle) {
        area += Math.sqrt(3.0)*Math.pow(Math.pow(1.0/3.0,original-n+1),2)/4.0;//calculates the area of one triangle added to the Koch curve
        if (n == 0) {
            //turtle.goForward(step);
            return;
        }
        koch(n-1, step, turtle);
        turtle.turnLeft(60.0);
        koch(n-1, step, turtle);
        turtle.turnLeft(-120.0);
        koch(n-1, step, turtle);
        turtle.turnLeft(60.0);
        koch(n-1, step, turtle);

    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        original = n;
        double step = 1.0 / Math.pow(3.0, n);
        Turtle turtle = new Turtle(0.0, 0.0, 0.0);
        koch(n, step, turtle);
        System.out.println(area);//returns sum of all triangles added

    }
}
//$ java Koch 10
//0.08659096532311308

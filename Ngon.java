/******************************************************************************
 *  Compilation:  javac Ngon.java
 *  Execution:    java Ngon n
 *  Dependencies: Turtle.java
 *
 *  Plots a regular n-gon.
 *
 *  The side length s of a regular n-gon inscribed in a circle
 *  of diameter 1 is sin(pi/n).
 *
 ******************************************************************************/

public class Ngon {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double angle = 360.0 / n;
        double step  = Math.sin(Math.toRadians(angle/2.0));   // sin(pi/n)
        Turtle turtle = new Turtle(0.5, 0.0, angle/2.0);
        for (int i = 0; i < n; i++) {
            turtle.goForward(step);
            turtle.turnLeft(angle);
        }
        double polyArea = (0.25*n*Math.sin(360/n))*0.5;//solves for the are of n-gon
        double circle = 0.25*Math.PI;//pi*r^2, using 0.5 as r
        System.out.println(circle);
        double isCircle = Math.abs(circle/polyArea);//ratio of circle to polygon
        System.out.println(isCircle);
        if(isCircle >= 0.95){//if the ratio of the circle to the polygon is less than 5%, it is a circle
            System.out.println("it is a circle");
        }
        else System.out.println("it's not a circle");
    }
}
//Output: All n-gons under n = 361 are not circles, all others are circles

public class EuclideanTest_MiS{
    public static void main(String [] args){
        //two dimensional points, hard coded for the purpose of testing
        double[] coordinatesp = new double[] {1.0, 2.0};
        double[] coordinatesq = new double[] {2.0, 5.0};
        EuclideanPoint_MiS pointp = new EuclideanPoint_MiS(coordinatesp);
        EuclideanPoint_MiS pointq = new EuclideanPoint_MiS(coordinatesq);
        System.out.println(pointp.distanceTo(pointq));
        double[] midpoint = pointp.midPoint(pointq);
        for(int i = 0; i < midpoint.length; i++){
            System.out.print(midpoint[i] + " ");
        }
    }
}
//Output
//$ java EuclideanTest_MiS
//3.1622776601683795
//1.5 3.5
//Output (when dimensions are not equal)
//$ java EuclideanTest_MiS
//Exception in thread "main" java.lang.RuntimeException: The two points are not in the same dimension
//        at EuclideanPoint_MiS.distanceTo(EuclideanPoint_MiS.java:17)
//        at EuclideanTest_MiS.main(EuclideanTest_MiS.java:8)

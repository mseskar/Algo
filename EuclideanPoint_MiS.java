public class EuclideanPoint_MiS{

private int dimension;
private double[] coordinates;
private double[] mid;
public EuclideanPoint_MiS(double[] coordinates){
    dimension = coordinates.length;
    this.coordinates = coordinates;
}
public double getDimension(){
    return dimension;
}
public double distanceTo(EuclideanPoint_MiS q){
    double sum = 0;
    //if the two points are not in the same dimension, do not conduct the operation
    if(this.getDimension() != q.getDimension()){
        throw new java.lang.RuntimeException("The two points are not in the same dimension");
    }
    else{//subtracts the two and squares the result
        for(int i = 0; i < dimension; i++){
            sum += Math.pow(this.coordinates[i] - q.coordinates[i], 2);
        }
    }//returns the square root
    return Math.sqrt(sum);
}
public double[] midPoint(EuclideanPoint_MiS q){
    double[] mid = new double[coordinates.length];
			for (int i = 0; i < dimension; i++) {
				mid[i] = (this.coordinates[i] + q.coordinates[i]) / 2; //Average each coordinate and assign to the index in the new array
			}
			return mid;//retun whole new array
    }
}

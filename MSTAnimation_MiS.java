import edu.princeton.cs.algs4.*;
import java.util.Iterator;
/**
 * Write a client program that does dynamic graphical animations of MST algorithms.
 It is not an interactive animation.
 *
 * @mseskar
 * @4/6/18
 */
public class MSTAnimation_MiS
{
    public static void main(String[] args){
        In in = new In(args[0]);
        EdgeWeightedGraph g = new EdgeWeightedGraph(in);
        StdDraw.setXscale(-0.05,1.05);
        StdDraw.setYscale(-0.05,1.05);
        int V = g.V();
        double[] xcoords = new double[V];
        double[] ycoords = new double[V];
        for(int i = 0; i<V; i++){
            xcoords[i] = Math.random();
            ycoords[i] = Math.random();
            StdDraw.filledCircle(xcoords[i],ycoords[i],0.01);
        }
        KruskalMST mst = new KruskalMST(g);
        Iterator<Edge> itr = mst.edges().iterator();
        while(itr.hasNext()){
            Edge edge = itr.next();
            StdDraw.line(xcoords[edge.either()],ycoords[edge.either()], xcoords[edge.other(edge.either())], ycoords[edge.other(edge.either())]);
        }
    }
}

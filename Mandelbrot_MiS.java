import java.awt.Color;
/*
@mseskar
Faster Mandelbrot without using Complex ADT, considerably faster

*/
public class Mandelbrot_MiS {
    public static void main(String[] args)  {
        double xc   = Double.parseDouble(args[0]);
        double yc   = Double.parseDouble(args[1]);
        double size = Double.parseDouble(args[2]);

        int n   = 512;   // create n-by-n image
        int max = 255;   // maximum number of iterations

        Picture picture = new Picture(n, n);
        //go through every pixel
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Color colors = compute(i,j,xc,yc,size,n,max);//returns Black or White
                picture.set(j,i,colors);
            }
        }
        picture.show();
    }
    public static Color compute(int i, int j,double xc,double yc,double size,int n,int max){
        double x0 = 0, y0 = 0;
        double imag = xc - size/2 + size*i/n; //Imaginary component
        double real = yc - size/2 + size*j/n;//Real component
        int count = 0;

        while (x0*x0+y0*y0 < 2 && count < max) {// Z = Z^2 + C, as long as Z is less than 2 and not exceeding limit
            double tempx = x0*x0-y0*y0+real;
            y0 = 2*x0*y0+imag;
            x0 = tempx;
            count++;
        }

        if (count < max){
            return Color.WHITE;
        }
        else{
            return Color.BLACK;
        }
    }
}

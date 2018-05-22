import java.awt.Font;

public class MiS_KevinBaconSG {
    public static void main (String [] args){
        String filename  = "movies.txt";
        String delimiter = "/";

        // StdOut.println("Source: " + source);

        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph G = sg.G();
        System.out.println("Enter the name of the character");
        String name = StdIn.readLine();
        int n = sg.index(name);
        System.out.println("Enter the number of degrees");
        int d = StdIn.readInt();

        Iterable<Integer> stuff = G.adj(n);
        int counter = 0;
        for (int i: stuff){
            counter++;
            System.out.print(sg.name(i) + ": ");
            Iterable<Integer> kek  = G.adj(sg.index(sg.name(i)));
            for (int a: kek){
                System.out.print(sg.name(a) + " |"
                        + "");

            }
            System.out.println();

        }
        StdDraw.setCanvasSize(2200,1000);
        StdDraw.setXscale(0,1000);
        StdDraw.setYscale(0,1000);

        StdDraw.text(50, 500, sg.name(n));
        int x = 50;
        int y = 25;
        int r = counter;

        for (int i: stuff){
            StdDraw.setFont(new  Font("SansSerif",Font.PLAIN, 20));
            StdDraw.text(x,y, sg.name(i));
            StdDraw.line(x, y, 25, 500);
            if(x >= 50-r &&  x < 950-r){
                if(y< 500-r && y> 0
                        ){
                    x+=r;
                    y+=r;
                }
                if(y>=475-r && y<925-r){
                    x-=r;
                    y+=r;
                }



            }
            if (x< 50-r && x>=0){
                if(y<=925-r && y>=500-r){
                    x-=r;
                    y-=r;
                }
                if(y<=475-r && y>=0){
                    x+=r;
                    y-=r;
                }
            }
            Iterable<Integer> kek  = G.adj(sg.index(sg.name(i)));
            int count = 0;
            if(d==2){
                for(int b:kek){
                    StdDraw.setFont(new  Font("SansSerif",Font.PLAIN, 7));
                    StdDraw.text(x+count+50,y, sg.name(b));
                    count+=25;
                }}




        }


    }
}

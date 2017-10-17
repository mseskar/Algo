import java.util.ArrayList;
/*
@Milos Seskar
@9/20/18
This program creates and LFSR and has methods to simulate a step in the LFSR
*/
public class LFSR_MS{

    private String reg;
       private int N;
       private int tapPos;

  public LFSR_MS(String seed, int tap){
        reg = seed;
        tapPos = tap;
        N = seed.length();

  }

  // simulates one step of this LFSR and returns the new bit (as 0 or 1)
  public int step(){
      String oldReg = reg;
         int tapBit = ithConv(oldReg, N-tapPos -1);//right most bit, -1 to stay in bounds
         int fstBit = ithConv(oldReg, 0);//left most bit
         int curLastBit = tapBit ^ fstBit; //XOR the left most bit with the tap
         char lastChar;
         if(curLastBit == 0)
             lastChar = '0';
         else
             lastChar = '1';

         reg = oldReg.substring(1) + lastChar;//excludes left most bit and adds the lastChar to the right
         return curLastBit;

  }
//simulate k steps in the lfsr
  public int generate(int k){
      int sum = 0;
         for(int i = 0; i < k; i++){
             int curBit = step();
             sum = (sum << 1) + curBit; //binary shift operator, skips need for string, adds the last bit generated by the step 
         }
         return sum;
  }



  // returns the ith bit of this LFSR (as 0 or 1)
  public int ithConv(String str, int i)  {
    return (int)(str.charAt(i) - '0');//takes char at i in string register, then casts to int and returns
   }

  public String toString(){
    return reg;
  }

  public static void main(String [] args){
      LFSR_MS sr = new LFSR_MS("01101000010", 8);
      System.out.println(sr);
      for(int i = 0; i < 10; i++){
           int r = sr.generate(5);
           System.out.println(sr + " " + r);
       }
   }
}

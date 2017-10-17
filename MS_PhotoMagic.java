import java.awt.Color;
import java.util.ArrayList;
/*
@Milos Seskar
@9/20/18
This program uses the LFSR_MS class and Picture class to encode an image
*/
public class MS_PhotoMagic{

private static int height;
private static int width;
private static int red;
private static int green;
private static int blue;
  public static Picture transform(Picture picture, LFSR_MS lfsr){ // return a transformed copy of picture using lfsr
       height = picture.height();
       width = picture.width();
      for(int i = 0; i < width; i++){
          for(int j = 0; j < height; j++){
              Color color = picture.get(i, j);
              red = color.getRed() ^ lfsr.generate(8);
              green = color.getGreen() ^ lfsr.generate(8);
              blue = color.getBlue() ^ lfsr.generate(8);
              //System.out.println(red + " " + green + " " + blue);
              Color newColor = new Color(red, green, blue);
              picture.set(i,j, newColor);

          }
      }
      picture.show();
      return picture;
  }

  public static void main(String [] args){
      String filename = args[0];
      String seed = args[1];
      int tap = Integer.parseInt(args[2]);
      LFSR_MS lfsr = new LFSR_MS(seed, tap);//creates the LFSR with desired tap and seed
      Picture pic = new Picture(filename);//creates the picture based on file name
      transform(pic, lfsr);//runs the encryption

    }
}

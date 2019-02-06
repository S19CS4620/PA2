/**
 * PA2bluedot
 * 
 * Lights up a single blue pixel.
 * 
 * MMS, 2/1/11
 */
import meggy.Meggy;

class PA2bluedot {
       public static void main(String[] whatever){
               Meggy.setPixel( (byte)1, (byte)2, Meggy.Color.BLUE );
        }
}

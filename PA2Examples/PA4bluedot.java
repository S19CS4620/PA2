/**
 * PA4bluedot.java
 * 
 * Set two blue pixels but first call another function and have 
 * that function do one.
 * Also passing parameters.  Want to test that we are cleaning up in 
 * function epilogues correctly.
 *   
 * MMS, 2/9/11
 */

import meggy.Meggy;

class PA4bluedot {

    public static void main(String[] whatever){
        {
            new Simple().bluedot((byte)3, (byte)7);    
            Meggy.setPixel((byte)1, (byte)2, Meggy.Color.BLUE );
    
        }
    }
}

class Simple {
    
    public void bluedot(byte x, byte y) {
        Meggy.setPixel( x, y, Meggy.Color.BLUE );
    }

}

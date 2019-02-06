/**
 * PA4raindrop.java
 * 
 * A blue pixel falls from top to bottom of the screen over and over in an
 * infinite loop.
 *   
 * MMS, 2/2/11
 */

import meggy.Meggy;

class PA4raindrop {

    public static void main(String[] whatever){
        // Not actually constructing object in PA5 compiler,
        // but syntax needs to be there.
        // Rain in column 3.
        while (true) {
            new Cloud().rain((byte)3,(byte)7);
            Meggy.delay(500);
            Meggy.setPixel((byte)3, (byte)0, Meggy.Color.DARK);
            Meggy.setPixel((byte)1, (byte)6, Meggy.Color.ORANGE);
        }
    }
}

class Cloud {
    
    public void rain(byte x, byte y) {
        // light up x,y if is in bounds
        // and continue recursion
        if (this.inBounds(x, y)) {
            Meggy.setPixel(x, y, Meggy.Color.BLUE);
            if (this.inBounds(x,(byte)(y+(byte)1))) {
                    Meggy.setPixel(x, (byte)(y+(byte)1), Meggy.Color.DARK);
            } else {}
            Meggy.delay(100);
            this.rain(x, (byte)(y-(byte)1));
        } else {}
    }
    
    public boolean inBounds(byte x, byte y) {
        return ((byte)(0-1) < y) && (y < (byte)8);
    }

}

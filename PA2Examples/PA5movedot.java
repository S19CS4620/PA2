
/**
 * PA5movedot.java
 * 
 * Local vars keep track of where dot is so can move it around with DPad.  
 * Also have a local var that stores a tone value and then uses that 
 * to call toneStart when a button is pressed.
 * 
 * MMS, 2/2/11
 */

import meggy.Meggy;

class PA5movedot {

    public static void main(String[] whatever){
        new Dot().run();
    }
}

class Dot {
    byte curr_x;
    byte curr_y;
    Meggy.Color dotcolor;
    
    public void run() {
        Meggy.Tone localvar;
        localvar = Meggy.Tone.C3;
            
        // initialize color
        dotcolor = Meggy.Color.ORANGE;
        
        // initialize the x and y coordinates of the dot
        curr_x = (byte)3;
        curr_y = (byte)6;
        
        // and then let the user move it around with the Dpad
        while (true) {
            if (Meggy.checkButton(Meggy.Button.Up)) {
                this.movedot(curr_x, (byte)(curr_y+(byte)1));
                Meggy.toneStart(localvar, 50);
            } else {}
            if (Meggy.checkButton(Meggy.Button.Down)) {
                this.movedot(curr_x, (byte)(curr_y-(byte)1));
                Meggy.toneStart(localvar, 50);
            } else {}
            if (Meggy.checkButton(Meggy.Button.Left)) {
                this.movedot((byte)(curr_x-(byte)1), curr_y);
                Meggy.toneStart(localvar, 50);
            } else {}
            if (Meggy.checkButton(Meggy.Button.Right)) {
                this.movedot((byte)(curr_x+(byte)1), curr_y);
                Meggy.toneStart(localvar, 50);
            } else {}
            
            Meggy.delay(100);
        }
    }
    
    public void movedot(byte x, byte y) {
        if (this.inBounds(x, y)) {
            // darken the current location of the dot
            Meggy.setPixel(curr_x, curr_y, Meggy.Color.DARK);
            
            // light up the new location
            Meggy.setPixel(x, y, dotcolor);
            
            // update the dot's current location
            curr_x = x;
            curr_y = y;
            
        } else {}

    }
    
    public boolean inBounds(byte x, byte y) {
        return ((byte)(0-1) < x) && (x < (byte)8) && ((byte)(0-1) < y) && (y < (byte)8);
    }

}

/**
 * PA5Cylon.java
 * 
 * Canonical example for PA4, updated for PA5.  
 * Displays a red light that moves
 * back and forth across the LED screen and moves to a row
 * based on key combinations.  The real trick is to make the light
 * stay on the same row after each cycle even if no buttons
 * are pressed (Hint: test by modifying checkButton() implementation
 * in Meggy.java).
 * In PA6, MeggyJava will be extended to include local variables
 * so that things are even easier than with just function calls.
 * Can keep track of the currentRow and can use a while loop to 
 * iterate over the pixels in a row.
 * 
 *  button combo    row
 *   up              7
 *   up and right    4
 *   down            0
 * 
 * New language features tested since PA4:
 *  -local variables
 *  -assignment statements
 *  -object declarations and references
 *
 * Required
 *  -declaration and use of a non local variable
 *  -finite while loop
 *
 * MMS, 1/13/11
 */

import meggy.Meggy;

class PA5Cylon {

    public static void main(String[] whatever){
        // Only want to construct one instance of class
        new CylonPA5().run();
    } // end of method
}

class CylonPA5 {
    public void run() {
        byte currentRow;
        currentRow=(byte)0;
        
        // Initialize the red LED location to row 0
        Meggy.setPixel( (byte)((byte)0*(byte)0+0-0), currentRow, Meggy.Color.RED );

        // Infinite loop that uses button presses to determine
        // which row to do cycle the LED light through or
        // if no button is pressed determines where red LED light
        // is in the zeroth column and then does a cycle in
        // that row.
        while (true) {
            // up indicates row 7
            if (Meggy.checkButton(Meggy.Button.Up)
                    && ! Meggy.checkButton(Meggy.Button.Right) )
            {
                Meggy.setPixel((byte)0, (byte)0, Meggy.Color.DARK);
                Meggy.setPixel((byte)0, (byte)4, Meggy.Color.DARK);
                currentRow = (byte)7;
                this.cylonRow((byte)0, currentRow);
            } else {
                // up and right indicates row 4
                if (Meggy.checkButton(Meggy.Button.Up)
                        && Meggy.checkButton(Meggy.Button.Right)) 
                {
                    Meggy.setPixel((byte)0, (byte)0, Meggy.Color.DARK);
                    Meggy.setPixel((byte)0, (byte)7, Meggy.Color.DARK);
                    currentRow = (byte)4;
                    this.cylonRow((byte)0, currentRow);
                } else {
                    // down indicates row 0
                    if (Meggy.checkButton(Meggy.Button.Down)) 
                    {
                        Meggy.setPixel((byte)0, (byte)7, Meggy.Color.DARK);
                        Meggy.setPixel((byte)0, (byte)4, Meggy.Color.DARK);
                        currentRow = (byte)0;
                        this.cylonRow((byte)0, currentRow);
                    } else {
                        // Otherwise continue pattern in current row.
                        this.cylonRow((byte)0, currentRow);                        
                    }
                }
            }
            Meggy.delay(1000);
        } // end while        
    }

    // Recursive routine that will cycle forward and 
    // back through all columns in the given row starting
    // at col.
    // Assuming that the given column is within range.
    public void cylonRow(byte col, byte row) {
        byte i;
        i = col;
        // loop forward through all cols
        while (i<(byte)8) {
            Meggy.setPixel(i, row, Meggy.Color.RED);            
            // if previous column is within range, then turn off
            if ((byte)(0-1)<(byte)(i-(byte)1)) {
                Meggy.setPixel((byte)(i-(byte)1), row, Meggy.Color.DARK);
            } else {}
            Meggy.delay(256);
            i = (byte)(i+(byte)1);
        }
        
        // loop backward through all cols, but stop at initial col
        i = (byte)7;
        while ((byte)(0-1)<i && col<(byte)(i+(byte)1)) {
            Meggy.setPixel(i, row, Meggy.Color.RED);            
            // if previous column is within range, then turn off
            if ((byte)(i+(byte)1)<(byte)8) {
                Meggy.setPixel((byte)(i+(byte)1), row, Meggy.Color.DARK);
            } else {}
            Meggy.delay(256);
            i = (byte)(i-(byte)1);
        }
        
    }
}

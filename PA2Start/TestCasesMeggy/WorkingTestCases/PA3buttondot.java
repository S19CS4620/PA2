/**
 * PA3buttondot
 * 
 * If no button is pressed, then lights up a single ORANGE pixel.
 * If button A is pressed, then lights up a single VIOLET pixel.
 * If button B is pressed, then lights up a single GREEN pixel.
 * 
 * MMS, 2/1/11
 */

import meggy.Meggy;

class PA3buttondot {
    public static void main(String[] whatever){
        {
            Meggy.setPixel( (byte)7, (byte)7, Meggy.Color.ORANGE );

            // infinite loop that checks for button presses every half second
            while (true) {
                if (Meggy.checkButton(Meggy.Button.A)) {
                    Meggy.setPixel( (byte)0, (byte)0, Meggy.Color.VIOLET );
                    Meggy.setPixel( (byte)7, (byte)0, Meggy.Color.DARK );
                    Meggy.setPixel( (byte)7, (byte)7, Meggy.Color.DARK );
                } else {
                    if (Meggy.checkButton(Meggy.Button.B)) {
                        Meggy.setPixel( (byte)7, (byte)0, Meggy.Color.GREEN );
                        Meggy.setPixel( (byte)0, (byte)0, Meggy.Color.DARK );
                        Meggy.setPixel( (byte)7, (byte)7, Meggy.Color.DARK );
                    } else {
                        Meggy.setPixel( (byte)7, (byte)7, Meggy.Color.ORANGE );                    
                        Meggy.setPixel( (byte)7, (byte)0, Meggy.Color.DARK );
                        Meggy.setPixel( (byte)0, (byte)0, Meggy.Color.DARK );
                    }

                }

                // tenth second delay, 100 milliseconds
                Meggy.delay(100);
            }
        }
    }
}

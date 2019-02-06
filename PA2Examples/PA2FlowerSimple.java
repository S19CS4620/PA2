/**
 * PA2FlowerSimple.java
 * 
 * Canonical example for PA2.  Displays a static picture of a flower.
 * 
 * Language features tested:
 * 	-constant integer expressions, simple version does not have these
 *  -casting to the byte type
 *  -calling the MeggyJava built-in setPixel function
 *  -inline comments
 *  -block comments
 * 
 * Requirements for the example:
 * 	-At least two colors.
 *  -At least 10 setPixel calls.
 *   Be careful to stay within the bounds!
 *
 * MMS, 1/18/11
 * MMS, 1/20/13, modified to PA2 canonical example
 */

import meggy.Meggy;

class PA2FlowerSimple {
	public static void main(String[] whatever){
	        // Lower left petal, clockwise  
	        Meggy.setPixel( (byte)2, (byte)4, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)2, (byte)3, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)1, (byte)2, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)0, (byte)2, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)0, (byte)3, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)1, (byte)4, Meggy.Color.VIOLET );

	        // Center
	        Meggy.setPixel( (byte)3, (byte)4, Meggy.Color.YELLOW );

	        // Lower right petal, clockwise  
	        Meggy.setPixel( (byte)4, (byte)1, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)5, (byte)1, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)5, (byte)2, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)4, (byte)3, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)3, (byte)3, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)3, (byte)2, Meggy.Color.VIOLET );

	        // Upper left petal, clockwise  
	        Meggy.setPixel( (byte)3, (byte)5, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)2, (byte)5, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)1, (byte)6, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)1, (byte)7, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)2, (byte)7, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)3, (byte)6, Meggy.Color.VIOLET );

	        // Upper right petal, clockwise  
	        Meggy.setPixel( (byte)4, (byte)4, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)5, (byte)4, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)6, (byte)5, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)6, (byte)6, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)5, (byte)6, Meggy.Color.VIOLET );
	        Meggy.setPixel( (byte)4, (byte)5, Meggy.Color.VIOLET );
	        
    }
}

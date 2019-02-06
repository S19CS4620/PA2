/**
 * PA3Expressions.java
 * MMS 2/16/11, updated WB 7/15/11
 */

import meggy.Meggy;

class PA3Expressions {
	public static void main(String[] whatever){
	    
	        // Integer addition
	        Meggy.setPixel( (byte)(2+1-3), (byte)(0+(3+5)) , Meggy.Color.VIOLET );
		Meggy.setPixel( (byte)(2+(1-3)), (byte)(0-(3+5)) , Meggy.Color.VIOLET );
	        // Integer subtraction
	        Meggy.setPixel( (byte)(7-1*6), (byte)(9-5), Meggy.Color.BLUE);

	        // Byte addition
	        Meggy.setPixel( (byte)((byte)((byte)3+(byte)2)+(byte)1), 
	                        (byte)((byte)((byte)0+(byte)0)+(byte)7), Meggy.Color.RED);

	        // Byte subtraction
	        Meggy.setPixel( (byte)((byte)((byte)3-(byte)2)-(byte)1), 
	                        (byte)((byte)((byte)0-(byte)7)+(byte)7),
	                        Meggy.Color.YELLOW);

                // Unary Minus
	        Meggy.setPixel(-5+5, (byte)(10*-5), Meggy.Color.DARK);
                // watch it! spaces significant
Meggy.setPixel( (byte)( (byte)(0 - - - 6) * (byte)(-1)), (byte)(10+5), Meggy.Color.ORANGE);
	        
	        // Mixed Integer and Byte
                Meggy.setPixel( (byte)(3-(byte)1),  (byte)((byte)0+7), Meggy.Color.GREEN);


	        // Only Byte multiplicatio
	        Meggy.setPixel( (byte)((byte)3*(byte)2), (byte)(5), Meggy.Color.WHITE);
	    
    }
}

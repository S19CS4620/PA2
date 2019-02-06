/**
 * Dangling else
 * WB 2/8/12
 */

import meggy.Meggy;

class IfStmt {
    public static void main(String[] whatever){
	    if ((byte)1+1  == 2)
	    		Meggy.setPixel( (byte)0, (byte)1, Meggy.Color.GREEN );
	    	else
	    		Meggy.setPixel( (byte)0, (byte)1, Meggy.Color.RED );
	    
	    if (-2  == (1-3))
	    	if ( (byte)2*(byte)3 == 6)
	    		Meggy.setPixel( (byte)0, (byte)2, Meggy.Color.GREEN );

	    if (-2  == (1-3))
	    	if ((byte)2*(byte)3 == 7)
	    		Meggy.setPixel( (byte)0, (byte)3, Meggy.Color.RED );
	    	else
	    		Meggy.setPixel( (byte)0, (byte)3, Meggy.Color.GREEN );

	    if (-2  == (1+3))
	    	if ((byte)2*(byte)3 == 6)
	    		Meggy.setPixel( (byte)0, (byte)4, Meggy.Color.ORANGE );
	    	else
	    		Meggy.setPixel( (byte)0, (byte)4, Meggy.Color.RED );
	    else
	    	Meggy.setPixel( (byte)0, (byte)4, Meggy.Color.GREEN );

	    if (-2  == (0-2))
	    	if ((byte)2*(byte)3 == 7)
	    		Meggy.setPixel( (byte)0, (byte)5, Meggy.Color.ORANGE );
	    	else if (2==1) 
	    		Meggy.setPixel( (byte)0, (byte)5, Meggy.Color.RED );
		else
	    		Meggy.setPixel( (byte)0, (byte)5, Meggy.Color.GREEN );
	    
    }
}

/**
 * Conditions and Expressions 
 * WB 2/8/12
 */

import meggy.Meggy;

class CondExpr {
	public static void main(String[] whatever){
	    // UMINUS
	    if (-2  == (1-3))
		 Meggy.setPixel( (byte)0, (byte)1, Meggy.Color.GREEN );
            else
                 Meggy.setPixel( (byte)0, (byte)1, Meggy.Color.RED );	    
	    if ((byte)5  == (10 + -(byte)-(byte)-5))
		 Meggy.setPixel( (byte)1, (byte)1, Meggy.Color.GREEN );
	    else
	         Meggy.setPixel( (byte)1, (byte)1, Meggy.Color.RED );
	    if (-4  == ((byte)1-5))
		  Meggy.setPixel( (byte)2, (byte)1, Meggy.Color.GREEN );
	    else
		 Meggy.setPixel( (byte)2, (byte)1, Meggy.Color.RED );
	    
	    if ((byte)-6  == (byte)(-1-5))
		 Meggy.setPixel( (byte)3, (byte)1, Meggy.Color.GREEN );
		else
		 Meggy.setPixel( (byte)3, (byte)1, Meggy.Color.RED );

	    
	    // plus
	    if((512+512) == 1024)	        
		  Meggy.setPixel( (byte)0, (byte)2, Meggy.Color.GREEN );
        else
		  Meggy.setPixel( (byte)0, (byte)2, Meggy.Color.RED );
   
	    if((3+(byte)2) == 5)
		  Meggy.setPixel( (byte)1, (byte)2, Meggy.Color.GREEN );
        else
		  Meggy.setPixel( (byte)1, (byte)2, Meggy.Color.RED );	     
	    
	    if( ( (byte)3+2) == 5 )
		  Meggy.setPixel( (byte)1, (byte)2, Meggy.Color.GREEN );
        else
		  Meggy.setPixel( (byte)1, (byte)2, Meggy.Color.RED );	      
	      
	    if((byte)(3+2) == (byte)5)
		  Meggy.setPixel( (byte)3, (byte)2, Meggy.Color.GREEN );
        else
		  Meggy.setPixel( (byte)3, (byte)2, Meggy.Color.RED );	      
 
	    // minus        
	    if((0-512) == (512-1024) )	        
		  Meggy.setPixel( (byte)0, (byte)3, Meggy.Color.GREEN );
        else
		  Meggy.setPixel( (byte)0, (byte)3, Meggy.Color.RED );
 	      
	    if( ((byte)0-32) == (512-544) )	        
		  Meggy.setPixel( (byte)1, (byte)3, Meggy.Color.GREEN );
        else
          Meggy.setPixel( (byte)1, (byte)3, Meggy.Color.RED );
	      
	    if( (0-(byte)32) == (512-544) )	        
		  Meggy.setPixel( (byte)2, (byte)3, Meggy.Color.GREEN );
        else
		  Meggy.setPixel( (byte)2, (byte)3, Meggy.Color.RED );

 	    if( (byte)((byte)0-(byte)32) == (byte)(512-544) )	        
 	      Meggy.setPixel( (byte)3, (byte)3, Meggy.Color.GREEN );
 	    else
 		  Meggy.setPixel( (byte)3, (byte)3, Meggy.Color.RED );

	    // equals (mixed types)
	    if( ((byte)32) == 32 )	        
		  Meggy.setPixel( (byte)0, (byte)4, Meggy.Color.GREEN );
        else
          Meggy.setPixel( (byte)0, (byte)4, Meggy.Color.RED );
	    
	    	
	    if( -32 == (byte)-32)	        
		  Meggy.setPixel( (byte)1, (byte)4, Meggy.Color.GREEN );
        else
		  Meggy.setPixel( (byte)1, (byte)4, Meggy.Color.RED );
	   
	    	
	    if( Meggy.getPixel( (byte)1,(byte)4 ) == Meggy.Color.GREEN )
	      Meggy.setPixel( (byte)2, (byte)4, Meggy.Color.GREEN );
        else
		  Meggy.setPixel( (byte)2, (byte)4, Meggy.Color.RED );
	    
	    // no getButton in Meggy
	    
	    if( Meggy.checkButton(Meggy.Button.A) )
			  Meggy.setPixel( (byte)3, (byte)4, Meggy.Color.GREEN );
	    else
			  Meggy.setPixel( (byte)3, (byte)4, Meggy.Color.RED );
	    
	    }
}
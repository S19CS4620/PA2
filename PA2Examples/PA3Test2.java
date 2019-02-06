/*
Tests delay and the negation operator.
*/
import meggy.Meggy;

class PA3Test2
{
	public static void main (String[] args)
	{
		Meggy.setPixel((byte)6,(byte)6,Meggy.Color.YELLOW);

		if(!(Meggy.getPixel((byte)6,(byte)6)==Meggy.Color.BLUE))
			{ 
			Meggy.delay(1000);
			Meggy.setPixel((byte)7,(byte)7,Meggy.Color.RED);
			}
	}
}

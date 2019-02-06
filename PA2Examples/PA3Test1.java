/* Tests If/Else conditions. Also tests checkButton
 to get user input and getPixel to check the color of a pixel.
The application allows you to sort of alternate between colors. 
*/
import meggy.Meggy;

class PA3Test1
{
	public static void main (String[] args)
	{
		while(true)
		{
		    if(Meggy.checkButton(Meggy.Button.A))
			{
				if(Meggy.getPixel((byte)5,(byte)5)==Meggy.Color.RED)
					{ 
					Meggy.setPixel((byte)7,(byte)7,Meggy.Color.YELLOW);
					}
				else
					{ 
					Meggy.setPixel((byte)7,(byte)7,Meggy.Color.ORANGE);
					}
 
			}

			else if (Meggy.checkButton(Meggy.Button.B))
				
		   		{ Meggy.setPixel((byte)7,(byte)7,Meggy.Color.RED );}
				
		}
	}
}

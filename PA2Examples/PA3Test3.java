/*
* Simple Program which prints A or B based on which button is pressed
* But if Button other than A/B is pressed then it displays C and exit while loop;
*/

import meggy.Meggy;
class PA3Test3{

public static void main (String [] args){

Meggy.setPixel((byte)1,(byte)3,Meggy.Color.GREEN);
Meggy.setPixel((byte)1,(byte)4,Meggy.Color.GREEN);
Meggy.setPixel((byte)2,(byte)3,Meggy.Color.GREEN);
Meggy.setPixel((byte)2,(byte)4,Meggy.Color.GREEN);
Meggy.setPixel((byte)3,(byte)3,Meggy.Color.GREEN);
Meggy.setPixel((byte)3,(byte)4,Meggy.Color.GREEN); //Display ! on screen
Meggy.setPixel((byte)5,(byte)3,Meggy.Color.GREEN);
Meggy.setPixel((byte)5,(byte)4,Meggy.Color.GREEN);
Meggy.setPixel((byte)6,(byte)3,Meggy.Color.GREEN);
Meggy.setPixel((byte)6,(byte)4,Meggy.Color.GREEN);
Meggy.setPixel((byte)0,(byte)0,Meggy.Color.GREEN);
while(Meggy.getPixel((byte)0,(byte)0)==Meggy.Color.GREEN)
{
	if(Meggy.checkButton(Meggy.Button.A)){
		Meggy.setPixel((byte)1,(byte)3,Meggy.Color.ORANGE);
		Meggy.setPixel((byte)1,(byte)4,Meggy.Color.ORANGE);
		Meggy.setPixel((byte)2,(byte)2,Meggy.Color.ORANGE);
		Meggy.setPixel((byte)2,(byte)5,Meggy.Color.ORANGE);
		Meggy.setPixel((byte)3,(byte)2,Meggy.Color.ORANGE);
		Meggy.setPixel((byte)3,(byte)5,Meggy.Color.ORANGE);
		Meggy.setPixel((byte)4,(byte)2,Meggy.Color.ORANGE);
		Meggy.setPixel((byte)4,(byte)5,Meggy.Color.ORANGE);
		Meggy.setPixel((byte)5,(byte)2,Meggy.Color.ORANGE);//Printing 'A' on Screen
		Meggy.setPixel((byte)5,(byte)5,Meggy.Color.ORANGE);
		Meggy.setPixel((byte)6,(byte)2,Meggy.Color.ORANGE);
		Meggy.setPixel((byte)6,(byte)5,Meggy.Color.ORANGE);
		Meggy.setPixel((byte)2,(byte)2,Meggy.Color.ORANGE);
		Meggy.setPixel((byte)2,(byte)5,Meggy.Color.ORANGE);
		Meggy.setPixel((byte)3,(byte)3,Meggy.Color.ORANGE);
		Meggy.setPixel((byte)3,(byte)4,Meggy.Color.ORANGE);
		
	}else{
		if(Meggy.checkButton(Meggy.Button.B)){
			Meggy.setPixel((byte)1,(byte)3,Meggy.Color.RED);
			Meggy.setPixel((byte)1,(byte)4,Meggy.Color.RED);
			Meggy.setPixel((byte)2,(byte)2,Meggy.Color.RED);
			Meggy.setPixel((byte)2,(byte)5,Meggy.Color.RED);
			Meggy.setPixel((byte)3,(byte)2,Meggy.Color.RED);
			Meggy.setPixel((byte)3,(byte)5,Meggy.Color.RED);
			Meggy.setPixel((byte)4,(byte)2,Meggy.Color.RED);
			Meggy.setPixel((byte)4,(byte)5,Meggy.Color.RED);
			Meggy.setPixel((byte)5,(byte)2,Meggy.Color.RED);//Printing 'B' on Screen
			Meggy.setPixel((byte)5,(byte)5,Meggy.Color.RED);
			Meggy.setPixel((byte)6,(byte)2,Meggy.Color.RED);
			Meggy.setPixel((byte)6,(byte)5,Meggy.Color.RED);
			Meggy.setPixel((byte)2,(byte)2,Meggy.Color.RED);
			Meggy.setPixel((byte)2,(byte)5,Meggy.Color.RED);
			Meggy.setPixel((byte)3,(byte)3,Meggy.Color.RED);
			Meggy.setPixel((byte)3,(byte)4,Meggy.Color.RED);
			
		}else{
			Meggy.setPixel((byte)4,(byte)4,Meggy.Color.GREEN);
			Meggy.setPixel((byte)4,(byte)5,Meggy.Color.GREEN);
			Meggy.setPixel((byte)4,(byte)6,Meggy.Color.GREEN);
			Meggy.setPixel((byte)5,(byte)4,Meggy.Color.GREEN); // C
			Meggy.setPixel((byte)6,(byte)4,Meggy.Color.GREEN);
			Meggy.setPixel((byte)7,(byte)4,Meggy.Color.GREEN);
			Meggy.setPixel((byte)7,(byte)5,Meggy.Color.GREEN);
			Meggy.setPixel((byte)7,(byte)6,Meggy.Color.GREEN);
		}
		
	}
	Meggy.setPixel((byte)0,(byte)0,Meggy.Color.GREEN);

	Meggy.delay(1000);
	if(Meggy.getPixel((byte)7,(byte)6)==Meggy.Color.GREEN){
		Meggy.setPixel((byte)4,(byte)2,Meggy.Color.GREEN);
		Meggy.setPixel((byte)5,(byte)2,Meggy.Color.GREEN);
		Meggy.setPixel((byte)4,(byte)1,Meggy.Color.GREEN); //If C is displayed display dot on screen
		Meggy.setPixel((byte)4,(byte)1,Meggy.Color.GREEN);
		Meggy.setPixel((byte)0,(byte)0,Meggy.Color.DARK); // Make 0,0 Pixel dark and end program
		Meggy.delay(1000);
	}
}

}

}//Class
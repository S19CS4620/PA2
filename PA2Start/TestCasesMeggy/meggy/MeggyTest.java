/**
 * MeggyRegressionTest.java
 *
 * usage from Eclipse:
 *   right mouse click on MeggyTest.java file and Run As a JUnit test.
 *   
 * usage from the command line: 
 *   cd MeggyTestCases/
 *   javac -cp meggy/junit-4.8.2.jar:. meggy/MeggyTest.java
 *   java -cp meggy/junit-4.8.2.jar:. org.junit.runner.JUnitCore meggy.MeggyTest
 *
 * This suit of JUnit tests is for the Meggy interface in the meggy
 * package.  After any modifications to the Meggy file, these tests should
 * be run.
 *
 * 1/3/11, MMS
 *
 **/
package meggy;

import org.junit.Test;
import static org.junit.Assert.*;

public class MeggyTest {

	@Test public void colorEnumTest() {
        System.out.println("=============================");
        System.out.println("Checking the color constants.");
        System.out.println(Meggy.Color.DARK);
        System.out.println(Meggy.Color.RED);
        System.out.println(Meggy.Color.ORANGE);
        System.out.println(Meggy.Color.YELLOW);
        System.out.println(Meggy.Color.GREEN);
        System.out.println(Meggy.Color.BLUE);
        System.out.println(Meggy.Color.VIOLET);
        System.out.println(Meggy.Color.WHITE);
        System.out.println("DONE checking the color constants.");
        System.out.println("=============================");

	}
	
	@Test public void toneEnumTest() {
        System.out.println("=============================");
        System.out.println("Checking the tone constants.");
        System.out.println(Meggy.Tone.C3);
        System.out.println(Meggy.Tone.Cs3);
        System.out.println(Meggy.Tone.D3);
        System.out.println(Meggy.Tone.Ds3);
        System.out.println(Meggy.Tone.E3);
        System.out.println(Meggy.Tone.F3);
        System.out.println(Meggy.Tone.Fs3);
        System.out.println(Meggy.Tone.G3);
        System.out.println(Meggy.Tone.Gs3);
        System.out.println(Meggy.Tone.A3);
        System.out.println(Meggy.Tone.As3);
        System.out.println(Meggy.Tone.B3);
        System.out.println("DONE checking the tone constants.");
        System.out.println("=============================");

	}
	
	@Test public void buttonEnumTest() {
        System.out.println("=============================");
        System.out.println("Checking the button constants.");
        System.out.println(Meggy.Button.B);
        System.out.println(Meggy.Button.A);
        System.out.println(Meggy.Button.Up);
        System.out.println(Meggy.Button.Down);
        System.out.println(Meggy.Button.Left);
        System.out.println(Meggy.Button.Right);
        System.out.println("DONE checking the button constants.");
        System.out.println("=============================");
	}
	
	@Test(expected=MeggyException.class)
	public void setPixelxlbTest()
	{
		Meggy.setPixel((byte)-1, (byte)0, Meggy.Color.GREEN);
	}
	
	@Test(expected=MeggyException.class)
	public void setPixelxubTest()
	{
		Meggy.setPixel((byte)8, (byte)0, Meggy.Color.GREEN);
	}
	
	@Test(expected=MeggyException.class)
	public void setPixelylbTest()
	{
		Meggy.setPixel((byte)4, (byte)-1, Meggy.Color.GREEN);
	}
	
	@Test(expected=MeggyException.class)
	public void setPixelyubTest()
	{
		Meggy.setPixel((byte)7, (byte)8, Meggy.Color.GREEN);
	}
	
	@Test(expected=MeggyException.class)
	public void getPixelxlbTest()
	{
		Meggy.getPixel((byte)-1, (byte)0);
	}
	
	@Test(expected=MeggyException.class)
	public void getPixelxubTest()
	{
		Meggy.getPixel((byte)8, (byte)0);
	}
	
	@Test(expected=MeggyException.class)
	public void getPixelylbTest()
	{
		Meggy.getPixel((byte)4, (byte)-1);
	}
	
	@Test(expected=MeggyException.class)
	public void getPixelyubTest()
	{
		Meggy.getPixel((byte)7, (byte)8);
	}
	
	@Test public void getPixelTest() {
		// what is default enum value in an array?
		System.out.println(Meggy.getPixel((byte)0,(byte)0));
		assertTrue(Meggy.getPixel((byte)3,(byte)4)==Meggy.Color.DARK);
	}
	
    @Test public void getsetTest() {
        System.out.println("=============================");
        System.out.println("Checking setPixel and getPixel.");
        int tmp;
        byte x=0;
        while (x<8) {
            byte y=0;
            while (y<8) {
                tmp = (y+x) % 8;
                if (tmp==0) {
                    Meggy.setPixel( x, y, Meggy.Color.DARK );
                } else if (tmp==1) {
                    Meggy.setPixel( x, y, Meggy.Color.RED );
                } else if (tmp==2) {
                    Meggy.setPixel( x, y, Meggy.Color.ORANGE );
                } else if (tmp==3) {
                    Meggy.setPixel( x, y, Meggy.Color.YELLOW );
                } else if (tmp==4) {
                    Meggy.setPixel( x, y, Meggy.Color.GREEN );
                } else if (tmp==5) {
                    Meggy.setPixel( x, y, Meggy.Color.BLUE );
                } else if (tmp==6) {
                    Meggy.setPixel( x, y, Meggy.Color.VIOLET );
                } else {
                    Meggy.setPixel( x, y, Meggy.Color.WHITE );
                }
                y++;
            }
            x++;
        }
        
        x=0;
        while (x<8) {
            byte y=0;
            while (y<8) {
                tmp = (y+x) % 8;
                if (tmp==0) {
                    Meggy.Color clr = Meggy.getPixel(x,y);
                    assertTrue(clr == Meggy.Color.DARK);
                } else if (tmp==1) {
                    Meggy.Color clr = Meggy.getPixel(x,y);
                    assertTrue(clr == Meggy.Color.RED);
                } else if (tmp==2) {
                    Meggy.Color clr = Meggy.getPixel(x,y);
                    assertTrue(clr == Meggy.Color.ORANGE);
                } else if (tmp==3) {
                    Meggy.Color clr = Meggy.getPixel(x,y);
                    assertTrue(clr == Meggy.Color.YELLOW);
                } else if (tmp==4) {
                    Meggy.Color clr = Meggy.getPixel(x,y);
                    assertTrue(clr == Meggy.Color.GREEN);
                } else if (tmp==5) {
                    Meggy.Color clr = Meggy.getPixel(x,y);
                    assertTrue(clr == Meggy.Color.BLUE);
                } else if (tmp==6) {
                    Meggy.Color clr = Meggy.getPixel(x,y);
                    assertTrue(clr == Meggy.Color.VIOLET);
                } else {
                    Meggy.Color clr = Meggy.getPixel(x,y);
                    assertTrue("ERROR: Expecting WHITE and got "+ clr+"\n", 
                    		   clr == Meggy.Color.WHITE);
                } 
                y++;
            }
            x++;
        }
        
        System.out.println("DONE checking setPixel and getPixel.");
        System.out.println("=============================");
    }

	
	@Test(expected=MeggyException.class)
	public void setAUXlbTest()
	{
		Meggy.setAuxLEDs(-1);
	}
	
	@Test(expected=MeggyException.class)
	public void setAUXubTest()
	{
		Meggy.setAuxLEDs(256);
	}
	
    
	@Test(expected=MeggyException.class)
	public void toneStartFailTest()
	{
		Meggy.toneStart(Meggy.Tone.D3, 0);
	}

	@Test
	public void toneStartTest()
	{
		Meggy.toneStart(Meggy.Tone.D3, 20);
	}

	/*@Test
	public void checkButtonTest() {
		assertTrue(Meggy.checkButton(Meggy.Button.A));
		assertTrue(Meggy.checkButton(Meggy.Button.B));
		assertTrue(Meggy.checkButton(Meggy.Button.Up));
		assertTrue(Meggy.checkButton(Meggy.Button.Down));
		assertTrue(Meggy.checkButton(Meggy.Button.Left));
		assertTrue(Meggy.checkButton(Meggy.Button.Right));
	}*/
	
	@Test(expected=MeggyException.class)
	public void delayFailTest()
	{
		Meggy.delay(0);
	}

	@Test
	public void delayTest()
	{
		Meggy.delay(42);
	}

}

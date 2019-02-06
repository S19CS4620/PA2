/**
 * Meggy.java
 *
 * The Java-only definition of the meggy interface for use in the MeggyJava
 * language.  See the grammar for the MeggyJava language at 
 * http://www.cs.colostate.edu/~cs453/yr2011/MeggyJavaInfo/meggy-java-grammar.html
 *
 * NOTES:
 *  - Java does not have unsigned types and the MeggyJrSimple and MeggyJr
 *    libraries do use unsigned types.  For the Java-only package I am 
 *    going to use signed bytes for things like the x,y coordinates because
 *    they don't need all 256 positive values.  For constants like colors 
 *    we use enumerated types.  For number of milliseconds using integers
 *    even though that will restrict the range somewhat.
 *
 * 12/27/10, 1/4/11, MMS
 * Fall 2010, started by Ryan Moore
 **/

package meggy;


// Imports
import java.io.*;
import java.util.*;


public final class Meggy
{
    /** Specifies LED color, MJ compiler will translate to MeggyJrSimple 
     *  color index.
     */
    static public enum Color { DARK,
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        BLUE,
        VIOLET,
        WHITE }


    /** Specifies which tone, MJ compiler will translate to MeggyJrSimple 
     * tone constants.
     */
    static public enum Tone { C3,
        Cs3,
        D3,
        Ds3,
        E3,
        F3,
        Fs3,
        G3,
        Gs3,
        A3,
        As3,
        B3 }

    /** Specifies which button, MJ compiler will translate to MeggyJrSimple 
     * button constants.
     */
    static public enum Button { B,
        A,
        Up,
        Down,
        Left,
        Right }

    /** The private array that stores the current color settings in the screen.
     */
    static private final byte sScreenSize = 8;
    static private final Color[][] sScreenBuffer
    = {{Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK},
        {Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK},
        {Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK},
        {Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK},
        {Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK},
        {Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK},
        {Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK},
        {Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK,Color.DARK}
    };
    //    = new Color[sScreenSize][sScreenSize];

    // Max value for the bit array
    static private final int sMaxBitArrayForLEDs = 255;

    /** Input file with parameters for the run.
     **/
    static private boolean sAlreadyInit = false;
    
    static private int sMaxCalls = 0;          // Max number of calls to this interface before halting
    static private boolean sDelaySim = true;   // Are we simulating delays in Java.

    // A list of button press sets.  Each phase has a set.  Phases are
    // occur between delay calls.
    static private LinkedList<HashSet<Meggy.Button>> sButtonPresses 
    = new LinkedList<HashSet<Meggy.Button>>();
    static private int sCurrPhase = 0;

    static private void init() {
        sAlreadyInit = true;
        
        HashSet<Meggy.Button> currSet;
        
        // If you run the MeggyJava programs from the command line
        // then your user.dir should be the directory the file is in.
        // If you run it in Eclipse, your user.dir may be something different
        // and you might have to change the relative path for arg_opts below.
        //System.out.println(System.getProperty("user.dir"));

        sButtonPresses.add(currSet = new HashSet<Meggy.Button>());    // zeroth phase
        try {
            // When run on command line
            Scanner sc = new Scanner( new File("meggy/arg_opts") );
            
            // When run from within Eclipse
            //Scanner sc = new Scanner( new File("TestCasesMeggy/meggy/arg_opts") );
            String line = sc.nextLine();
            sMaxCalls = Integer.valueOf( line );
            sDelaySim = Boolean.parseBoolean( sc.nextLine() );
            //System.out.println("Steps=" + sMaxCalls); // debug only
            //System.out.println("Delay=" + sDelaySim); // debug only
            // Parse and run commands
            while(sc.hasNextLine()){
                String st = sc.nextLine().trim();
                //System.out.println( st ); // debug only
                if (st.equals("delay")) {
                    sButtonPresses.add(currSet = new HashSet<Meggy.Button>());
                } else {
                    currSet.add(Meggy.Button.valueOf(st));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }   


    /** private constructor, MeggyJava programs don't instantiate an instance
     * IOW, the Meggy class is really just a module wrapper for
     * the interface and a single global array of pixel values.
     * Meggy object instances should not be created.
     */
    private Meggy()
    {
    }

    /**
     * Sets the pixel at position x,y to the given color and
     * prints a gradeable message to indicate as such to 
     * stdout.  Also checks input value ranges.
     *
     * The coordinate system starts at the lower left corner
     * of the device at <0,0>
     * 
     * @param x is the horizontal coordinate, indicates column
     * @param y is the vertical coordinate, indicates row
     * @param meggyColor is the color to for the pixel
     **/
    public static void setPixel(byte x, byte y, Color meggyColor)
    {
        if (!sAlreadyInit) { init(); }
        sMaxCalls--; if (sMaxCalls<0) { System.exit(0); }
        
        // Check that all input values fall within possible ranges.
        if (!(0<=x && x<sScreenSize)) throw new MeggyException("x coordinate out of bounds, x = "+x);
        if (!(0<=y && y<sScreenSize)) throw new MeggyException("y coordinate out of bounds, y = "+y);

        // Set pixel in screen.
        sScreenBuffer[x][y] = meggyColor;

        // Print a gradeable output message.
        System.out.println("Setting pixel ("+x+","+y+") to " + meggyColor);
    }

    /**
     * Gets the pixel color at position x,y and
     * prints a gradeable message to indicate as such to 
     * stdout.  Also checks input value ranges.
     *
     * The coordinate system starts at the lower left corner
     * of the device at <0,0>
     * 
     * @param x is the horizontal coordinate
     * @param y is the vertical coordinate
     **/
    public static Color getPixel( byte x, byte y )
    {
        if (!sAlreadyInit) { init(); }
        sMaxCalls--; if (sMaxCalls<0) { System.exit(0); }

        // Check that all input values fall within possible ranges.
        if (!(0<=x && x<sScreenSize)) throw new MeggyException("x coordinate out of bounds, x = "+x);
        if (!(0<=y && y<sScreenSize)) throw new MeggyException("y coordinate out of bounds, y = "+y);

        // Print a gradeable output message.
        System.out.println("Getting pixel ("+x+","+y+") ==>" 
                + sScreenBuffer[x][y]);

        // Get pixel value.
        return sScreenBuffer[x][y];
    }

    /**
     * Given a number from 0 to 255, this routine sets the
     * corresponding auxiliary lights by treating the
     * number like a bit array.  The least significant bit
     * represents the left-most auxiliary light.
     * 
     * @param bitarray value between 0 and 255
     **/
    public static void setAuxLEDs( int bitarray )
    {
        if (!sAlreadyInit) { init(); }
        sMaxCalls--; if (sMaxCalls<0) { System.exit(0); }

        // Check that all input values fall within possible ranges.
        if (!(0<=bitarray && bitarray<=sMaxBitArrayForLEDs)) 
            throw new MeggyException("bitarray out of bounds, bitarray = "+bitarray);

        // Print a gradeable output message.
        System.out.print(
                "Setting auxiliary LEDs from left to right as follows: ");
        for (int i=1; i<=128; i=i*2) {
            // check if a given bit is set
            if ((bitarray & i)!=0) { 
                System.out.print(" 1 ");
            } else {
                System.out.print(" 0 ");
            }
        }
        System.out.println();

    }


    /**
     * Plays the specified tone for a specified amount of time.
     *
     * @param t which tone to play
     * @param duration_ms duration of the tone in milliseconds
     **/
    public static void toneStart( Tone t, int duration_ms )
    {
        if (!sAlreadyInit) { init(); }
        sMaxCalls--; if (sMaxCalls<0) { System.exit(0); }

        // Check that the duration is positive.
        if (!(0<duration_ms)) 
            throw new MeggyException("duration must be positive, duration_ms="
                    +duration_ms);

        // Print a gradeable output message.
        System.out.println("Playing tone "+ t + " for "
                + duration_ms + " milliseconds");

    }

    /**
     * Always indicates that the given button has been pressed.
     * 
     * Since these routines are only being used for grading this
     * simplifying assumption will enable deterministic grading.
     *
     * @param b which button to check
     **/
    public static boolean checkButton( Button b )
    {
        if (!sAlreadyInit) { init(); }
        sMaxCalls--; if (sMaxCalls<0) { System.exit(0); }

        // Do we have a phase for the current phase?
        // && Check to see if it's a button press for this phase
        if (sButtonPresses.size()>sCurrPhase && 
            sButtonPresses.get(sCurrPhase).contains(b) ) 
        {
            // Print a gradeable output message.
            System.out.println("Checking button "+ b + " and returning true");
            return true;

        } else {
            // Print a gradeable output message.
            System.out.println("Checking button "+ b + " and returning false");
            return false;
        }
    }

    /**
     * Prints a gradeable delay message.
     *
     * @param duration_ms the number of milliseconds for the delay
     **/
    public static void delay( int duration_ms )
    {
        if (!sAlreadyInit) { init(); }
        sMaxCalls--; if (sMaxCalls<0) { System.exit(0); }

        // Keep track of phase we are in for pre-recorded button presses.
        sCurrPhase += 1;

        // Check that the duration is positive.
        if (!(0<duration_ms)) {
            throw new MeggyException("duration must be positive, duration_ms="
                    +duration_ms);
        }
        
        // Print a gradeable output message.
        System.out.println("Delaying for "+ duration_ms + " milliseconds");

        // Only perform delay if flag is set
        if(sDelaySim) {
            try { Thread.sleep(duration_ms); }
            catch(InterruptedException e) { e.printStackTrace(); }
        }

    }

}

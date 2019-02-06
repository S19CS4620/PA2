/**
 * PA4MazeSolver.java
 * 
 * Maze canonical example for PA4. 
 * Initializes a maze that should have at least one path from <1,6> to <6,1>.
 * Puts a point at <1,6> and navigates maze with a recursive function.
 *      Walls are VIOLET, non-walls are the default DARK
 *      Solution path is BLUE
 *      Portions of path that didn't work are YELLOW. *
 * The stack size is bound because there are a constant number of pixels 
 * on the LED screen.    
 *   
 * MMS, 1/13/11
 */

import meggy.Meggy;

class PA4MazeSolver {

    public static void main(String[] whatever){
        // Only want to construct one instance of class
        new Solver().run();
    }
}

class Solver {
    
    // no maze walls, the solver should check boundaries of LED screen
    public void initMaze1() {
    }
    
    // Example with only a single path.
    public void initMaze2() {
        this.mazeRow((byte)0, (byte)7, (byte)7);  // top row
        this.mazeRow((byte)0, (byte)5, (byte)5);  // partial of 2 rows under
        this.mazeCol((byte)7, (byte)0, (byte)7);  // rightmost col
        this.mazeCol((byte)5, (byte)0, (byte)5);  // partial of 2 cols to the left       
    }
    
    // Cooler example
    public void initMazeCool() {
        this.mazeRow((byte)0, (byte)7, (byte)7);  // top row
        this.mazeRow((byte)0, (byte)7, (byte)0);  // bottom row
        this.mazeCol((byte)7, (byte)0, (byte)7);  // rightmost col
        this.mazeCol((byte)0, (byte)0, (byte)7);  // leftmost col
        
        // 2,5 to 5,5
        this.mazeRow((byte)2, (byte)5, (byte)5);
        // 2,2 to 2,5
        this.mazeCol((byte)2, (byte)2, (byte)5);
        // 2,2 to 5,2
        this.mazeRow((byte)2, (byte)5, (byte)2);
        
        Meggy.setPixel((byte)5, (byte)1, Meggy.Color.VIOLET);

    }
    
    public void run() {
        this.initMazeCool();
        
        this.move((byte)1,(byte)6,(byte)6,(byte)1);
        
    }
    
    public boolean inBounds(byte x, byte y) {
        return ((byte)(0-1) < x) && (x < (byte)8) && ((byte)(0-1) < y) && (y < (byte)8);
    }
    
    public boolean isDark(byte x, byte y) {
        return this.inBounds(x,y) && (Meggy.getPixel(x, y) == Meggy.Color.DARK);
    }
    
    public boolean isBLUE(byte x, byte y) {
        return this.inBounds(x,y) && (Meggy.getPixel(x, y) == Meggy.Color.BLUE);
    }
    
    public void findTargetOrMove(byte nextX, byte nextY, byte targetX, byte targetY) {
        // If target then turn target BLUE and fall to end of function.
        if (nextX==targetX && nextY==targetY ) { 
            Meggy.setPixel(nextX, nextY, Meggy.Color.BLUE);  
        }
        // if is not target then move there to continue search
        else { 
            this.move(nextX,nextY,targetX,targetY);
        }        
    }
    
    
    // Makes currentX and currentY BLUE.
    // Will attempt to move the BLUE path to any open neighboring
    // DARK LED.  If can't do that then will backtrack with 
    // a YELLOW path.  Searches neighbors in this order:
    //      south, east, north, west
    public void move(byte currentX, byte currentY, byte targetX, byte targetY) {
        Meggy.delay(256);
        Meggy.setPixel(currentX, currentY, Meggy.Color.BLUE);

        // Is south neighbor dark? 
        if (this.isDark(currentX,(byte)(currentY-(byte)1))) {
            this.findTargetOrMove(currentX, (byte)(currentY-(byte)1), 
                                  targetX, targetY);
            
        } else {
            // Is east neighbor dark? 
            if (this.isDark((byte)(currentX+(byte)1),currentY)) {
                this.findTargetOrMove((byte)(currentX+(byte)1), currentY, 
                                      targetX, targetY);
            
            } else {
                // Is north neighbor dark? 
                if (this.isDark(currentX,(byte)(currentY+(byte)1))) {
                    this.findTargetOrMove(currentX, (byte)(currentY+(byte)1), 
                            targetX, targetY);
                
                } else {
                    // Is west neighbor dark?
                    if (this.isDark((byte)(currentX-(byte)1),currentY)) {
                        this.findTargetOrMove((byte)(currentX-(byte)1), currentY, 
                                targetX, targetY);
                    
                    } 
                    // Did not find a DARK neighbor so need to try backtracking.
                    // This must be in a nested if otherwise if we happened to find
                    // the target above we might also backtrack.
                    // For backtracking we look for a BLUE neighbor
                    // and then turn ourselves yellow before moving there.
                    // If don't find a BLUE neighbor will fall to end.
                    else {
                        // Is south neighbor BLUE? 
                        if (this.isBLUE(currentX,(byte)(currentY-(byte)1))) {
                            Meggy.setPixel(currentX,currentY,
                                           Meggy.Color.YELLOW);
                            this.move(currentX,(byte)(currentY-(byte)1),
                                      targetX, targetY);
                            
                        } else {
                            // Is east neighbor BLUE? 
                            if (this.isBLUE((byte)(currentX+(byte)1),currentY)) {
                                Meggy.setPixel(currentX,currentY,
                                               Meggy.Color.YELLOW);
                                this.move((byte)(currentX+(byte)1),currentY,
                                          targetX, targetY);
                            
                            } else {
                                // Is north neighbor BLUE? 
                                if (this.isBLUE(currentX,(byte)(currentY+(byte)1))) {
                                    Meggy.setPixel(currentX,currentY,
                                                   Meggy.Color.YELLOW);
                                    this.move((byte)(currentX),(byte)(currentY+(byte)1),
                                              targetX, targetY);
                                
                                } else {
                                    // Is west neighbor BLUE?
                                    if (this.isBLUE((byte)(currentX-(byte)1),currentY)) {
                                        Meggy.setPixel(currentX,currentY,
                                                       Meggy.Color.YELLOW);
                                        this.move((byte)(currentX-(byte)1),currentY,
                                                  targetX, targetY);
                                    }
                                    // else there is nothing we can do
                                    // just fall to return
                                    else {}
                                }
                            }
                        }
                    }   
                }                
            }
        }
    }
    
    // Starting and stopping at the given columns,
    // make the given row a maze border.
    // Assuming that startcol, endcol, and row are in bounds.
    public void mazeRow(byte startcol, byte endcol, byte row) {
        Meggy.setPixel(startcol, row, Meggy.Color.VIOLET);
        if (startcol<endcol) {
            this.mazeRow((byte)(startcol+(byte)1), endcol, row);
        } else {}
    }
    // Starting and stopping at the given rows,
    // make the given col a maze border.
    // Assuming that startrow, endrow, and col are in bounds.
    public void mazeCol(byte col, byte startrow, byte endrow) {
        Meggy.setPixel(col, startrow, Meggy.Color.VIOLET);
        if (startrow<endrow) {
            this.mazeCol(col,(byte)(startrow+(byte)1), endrow);
        } else {}
    }

}

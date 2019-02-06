/**
 * PA5PaddleBall.java
 * 
 * Canonical example for PA5.
 * 
 * Paddle is a stencil of points.  
 * The Ball has a position and a previous position.  Will keep
 * going in the same direction unless it detects a collision
 * with the single paddle on bottom or other three edges.
 * Can move paddle left and right with Dpad.
 * See the Ball class in the init method for the starting
 * location and direction of the ball.
 * 
 * Hoping that the 453 students will expand on this example to 
 * give it points, a way for the ball to fall off the screen,
 * a way to inject a new ball using a pseudo random
 * number generator, etc.
 * 
 * New language features tested since PA5:
 *  -local variables
 *  -assignment statements
 *  -object declarations, allocations, and references
 *
 * MMS, 1/13/11
 */

import meggy.Meggy;

class PA5PaddleBall {

    public static void main(String[] whatever){
        // Only want to construct one instance of class
        new PaddleBallBoard().run();
    }
}

class PaddleBallBoard {
    public void run() {
        Ball b;
        Paddle p;
        
        b = new Ball();
        b.init();
        p = new Paddle();
        p.init();
       
        while (true) {
            if (Meggy.checkButton(Meggy.Button.Left)) {
                p.moveLeft();
            } else {
                if (Meggy.checkButton(Meggy.Button.Right)) {
                    p.moveRight();
                } else {}
            }
            
            b.move();
            Meggy.delay(256);
        }
    }
}

class Paddle {
    byte centerX;
    Meggy.Color color;
    
    public void init() {
        centerX = (byte)4;
        color = Meggy.Color.BLUE;
        this.drawPaddle(centerX);
    }
    
    public void drawPaddle(byte x) {
        // Light the stencil pattern for the paddle
        Meggy.setPixel((byte)(x-(byte)1), (byte)0, color);
        Meggy.setPixel(x, (byte)0, color);
        Meggy.setPixel((byte)(x+(byte)1), (byte)0, color);        
    }
    
    public void moveLeft() {
        // Only move if it won't take paddle off screen
        if (this.inBounds((byte)(centerX-(byte)2),(byte)0)) {
            Meggy.setPixel((byte)(centerX+(byte)1), (byte)0, Meggy.Color.DARK);
            centerX = (byte)(centerX-(byte)1);
            this.drawPaddle(centerX);            
        } else {}     
    }
    
    public void moveRight() {
        // Only move if it won't take paddle off screen
        if (this.inBounds((byte)(centerX+(byte)2),(byte)0)) {
            Meggy.setPixel((byte)(centerX-(byte)1), (byte)0, Meggy.Color.DARK);
            centerX = (byte)(centerX+(byte)1);
            this.drawPaddle(centerX);            
        } else {}       
    }
    
    public boolean inBounds(byte x, byte y) {
        return ((byte)(0-1) < x) && (x < (byte)8) && ((byte)(0-1) < y) && (y < (byte)8);
    }
}

/**
 * Ball is a single ORANGE LED that starts with direction in terms
 * of a current location and previous location.
 * The ball knows how to move itself including bouncing if it
 * detects a collision.
 * 
 * @author mstrout
 *
 */
class Ball {
    byte currentX;
    byte currentY;
    byte prevX;
    byte prevY;
    Meggy.Color ballColor;
    
    /**
     * initializes ball at the top center on a diagonal trajectory
     */
    public void init() {
        prevX = (byte)3;
        prevY = (byte)7;
        currentX = (byte)4;
        currentY = (byte)6;
        ballColor = Meggy.Color.ORANGE;
        Meggy.setPixel(currentX, currentY, ballColor);
    }
    
    public boolean inBounds(byte x, byte y) {
        return ((byte)(0-1) < x) && (x < (byte)8) && ((byte)(0-1) < y) && (y < (byte)8);
    }
    
    /**
     * We have a collision if the given x,y coordinate has a color
     * other than DARK.  This method assumes that x,y is within bounds.
     * 
     * @param x horizontal coordinate, left to right
     * @param y vertical coordinate, bottom to top
     * 
     * @return True if given coordinate would cause a collision.
     */
    public boolean collision(byte x, byte y) {
        return !(Meggy.Color.DARK == Meggy.getPixel(x, y));
    }
    
    public void move() {
        // find where next position should be
        byte nextX;
        byte nextY;
        byte deltaX;
        byte deltaY;
        nextX = (byte)((byte)(currentX-prevX)+currentX);
        nextY = (byte)((byte)(currentY-prevY)+currentY);
        
        // if something is at next position
        // then move ball in opposite direction
        if (this.inBounds(nextX, nextY) && !this.collision(nextX,nextY)) {
            // will use nextX, nextY computed above
        }
        // Otherwise, need to bounce
        // Want to bounce along the normal to the direction vector.
        // Could go either way, but one of the ways will probably lead
        // to another collision.  Therefore, try one and then try the other.
        else {
            deltaX = (byte)(currentX-prevX);
            deltaY = (byte)(currentY-prevY);
            
            // Try first normal to direction vector
            nextX = (byte)(currentX + deltaX);
            nextY = (byte)(currentY - deltaY);
            if (this.inBounds(nextX,nextY) && !this.collision(nextX, nextY)) {
                // the above nextX and next Y are good
            } else {
                // use the other normal to the current direction vector.
                nextX = (byte)(currentX - deltaX);
                nextY = (byte)(currentY + deltaY);

                if (this.inBounds(nextX,nextY) && !this.collision(nextX, nextY)) {
                    // the above nextX and next Y are good
                    
                } 
                // otherwise, bounce back on self
                else {
                    nextX = prevX;
                    nextY = prevY;
                }
            }
        }
        
        // move the ball to next position
        Meggy.setPixel(currentX,currentY,Meggy.Color.DARK);
        Meggy.setPixel(nextX, nextY, ballColor);
        prevX = currentX;
        prevY = currentY;
        currentX = nextX;
        currentY = nextY;
    }  
    
}

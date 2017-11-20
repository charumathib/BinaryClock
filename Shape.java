import javax.swing.*;
import java.awt.*;
import java.util.Timer;
/**
 * Shape defines either a circle or square 
 */
public class Shape extends JPanel {
    /** Denotes the start time. Used for finding duration. */
    long startTime = System.nanoTime(); 
    /** Denotes the end time. Used for finding duration. */
    long endTime;
    /** Denotes whether or not the current shape is a circle */
    boolean isCircle = true;
    /**
     * Creates either a circle or a square at a given position for a given color
     *
     * @param g Graphics Object
     * @param xPos determines the horizontal spacing between each object,and decides how far to the right
     * the first object starts
     * @param yPos determines spacing between each row
     * @param c Color object
     */
    public void paintShape(Graphics g, int xPos, int yPos, Color c){
        super.paintComponent(g);
        g.setColor(c);
        elapsed(5);
        if(isCircle){
            if(c == Color.cyan){//changes the color of the circles
                g.setColor(Color.yellow);
            }
            g.fillOval(xPos, yPos, 20, 20);
        }else{
            g.fillRect(xPos, yPos, 20, 20);

        } 
        repaint();
    }

    /**
     * Utility function that changes the value of <code>isCircle</code> if <code>time</code> <b>seconds</b> 
     * has elapsed
     *
     * @param time Lets user decide how much time, in seconds, needs to have elapsed in order for an action to be done
     */
    public void elapsed(int time){
        endTime = System.nanoTime();//gets current time
        long duration = (endTime - startTime)/1000000000;//converts time from nano-seconds to seconds
        if(duration >= time){
            isCircle = !isCircle;//changes object from square to circle or circle to square
            startTime = System.nanoTime();//resets the starting time
        }
    }
}
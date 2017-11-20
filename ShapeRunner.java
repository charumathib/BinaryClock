import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
/**
 * Creates a 6 X 3 array of shapes which light up in a manner corresponding to what time it is in binary
 */
public class ShapeRunner extends JPanel{
    /** Defines an array of shapes with a size of 6 denoting <b>hours</b> */
    Shape[] hours = new Shape[6];
    /** Defines an array of shapes with a size of 6 denoting <b>minutes</b> */
    Shape[] mins = new Shape[6];
    /** Defines an array of shapes with a size of 6 denoting <b>seconds</b> */
    Shape[] secs = new Shape[6];
    GregorianCalendar cal;
    /** Used to control the font for the displayed text */
    Font font;
    /** Denotes the start time. Used for finding duration. */
    long startTime = System.nanoTime();
    /** Denotes the end time. Used for finding duration. */
    long endTime;
    /** 
     * Initializes a 6 X 3 array of hours, minutes, and seconds
     */
    public ShapeRunner(){
        for(int i = 0; i < 6; i++){
            hours[i] = new Shape();
            mins[i] = new Shape();
            secs[i] = new Shape();            
        }
    }

    /**
     * Gets the time values in binary form, and sets the color of the shape accordingly. 
     * <li> <code>0</code> is <b>black</b> 
     * <li> <code>1</code> is <b>cyan</b> or <b>yellow</b>
     */
    public void paint(Graphics g){
        cal = new GregorianCalendar();
        String binaryHours = convertToBinary(cal.get(Calendar.HOUR_OF_DAY));
        String binaryMinutes = convertToBinary(cal.get(Calendar.MINUTE));
        String binarySeconds = convertToBinary(cal.get(Calendar.SECOND));
        writeText(g);
        printTime(g, hours, binaryHours, 1);//prints hours
        printTime(g, mins, binaryMinutes, 2);//prints minutes
        printTime(g, secs, binarySeconds, 3);//prints seconds
        if(elapsed (5)){//background changes to a random color every 5 seconds
            setBackground(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
        }
        repaint();
    }

    /**
     * Prints shapes of different colors based on the binary time value. 
     * <p>A binary value <code>1010</code> will print shapes as black, cyan, black, cyan </p>
     *
     * @param g Graphics object
     * @param shapes An array of shapes
     * @param binaryTime Time in binary format
     * @param row Row on the screen. Values are 1, 2, and 3
     */
    public void printTime(Graphics g, Shape[] shapes, String binaryTime, int row){
        int xPos = 500/7 + 20;//signifies where the left-most object starts
        Color c;
        for(int i = 0; i < binaryTime.length(); i++){
            c = Color.black;
            if(binaryTime.substring(i, i+1).equals("1")){
                c = Color.cyan;
            }
            shapes[i].paintShape(g, xPos, 500/4 * row, c);
            xPos += 50;//provides spacing between each shape
        }
    }

    /**
     * Converts a given number to it's binary representation
     *
     * @param time Time in a base-10 format
     * @return Binary representation of <code>time</code>
     */
    public String convertToBinary(int time){
        String binary = "";
        while(time > 0){
            if(time%2 == 0){
                binary += "0";
            }else{
                binary += "1";
            }
            time /= 2;
        } 
        binary = new StringBuffer(binary).reverse().toString();
        binary = String.format("%6s", binary).replace(" ", "0");//left pad with 0
        return binary;
    }

    /**
     * Writes text such as <b>Hours, Minutes, Seconds</b> and the <b>title</b> on the screen along
     * with the actual time
     *
     * @param g Graphics object
     */
    public void writeText(Graphics g){
        font = new Font("Haettenschweiler", Font.BOLD, 50);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("BINARY CLOCK", 120, 75);
        font = new Font("Haettenschweiler", Font.BOLD, 24);
        g.setFont(font);
        g.drawString(Integer.toString(cal.get(Calendar.HOUR_OF_DAY)), 27, 145);
        g.drawString(Integer.toString(cal.get(Calendar.MINUTE)), 27, 270);
        g.drawString(Integer.toString(cal.get(Calendar.SECOND)), 27, 395);
        g.drawString("Hours" , 397, 145);
        g.drawString("Minutes", 397, 270);
        g.drawString("Seconds", 397, 395);
        g.setColor(Color.red);
        font = new Font("Haettenschweiler", Font.BOLD, 50);
        g.setFont(font);
        g.drawString("BINARY CLOCK", 125, 75);
        font = new Font("Haettenschweiler", Font.BOLD, 24);
        g.setFont(font);
        g.drawString(Integer.toString(cal.get(Calendar.HOUR_OF_DAY)), 30, 145);
        g.drawString(Integer.toString(cal.get(Calendar.MINUTE)), 30, 270);
        g.drawString(Integer.toString(cal.get(Calendar.SECOND)), 30, 395);
        g.drawString("Hours" , 400, 145);
        g.drawString("Minutes", 400, 270);
        g.drawString("Seconds", 400, 395);
    }

    /**
     * Returns <code>true</code> if a certain amount of <code>time</code> in seconds has elapsed
     * @param time
     * @return true or false
     */
    public boolean elapsed(int time){
        endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000000;//converts nano-seconds to seconds
        if(duration >= time){
            startTime = System.nanoTime();
            return true;
        }
        return false;
    }
}

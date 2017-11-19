//create a 6 X 3 array of circles
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
public class Shape extends JPanel {
    long startTime = System.nanoTime();
    long endTime;
    boolean isCircle = true;
    public void paintShape(Graphics g, int xPos, int yPos, Color c){//creates one circle
        super.paintComponent(g);
        //int startTime
        g.setColor(c);
        elapsed(2);
        if(isCircle){
            if(c == Color.cyan){
                g.setColor(Color.yellow);
            }
            g.fillOval(xPos, yPos, 20, 20);
           
        }else{
            g.fillRect(xPos, yPos, 20, 20);
        }  
        repaint();
    }

    public void elapsed(int time){
        endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000000;
        if(duration >= time){
            isCircle = !isCircle;
            startTime = System.nanoTime();
        }
    }
}
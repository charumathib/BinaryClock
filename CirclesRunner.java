//creates the circles
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
public class CirclesRunner extends JPanel{
    Circle[] hours = new Circle[6];
    Circle[] mins = new Circle[6];
    Circle[] secs = new Circle[6];
    GregorianCalendar cal;
    Font font = new Font("Haettenschweiler", Font.BOLD, 24);
    int h, m, s;
    public CirclesRunner(){
        for(int i = 0; i < 6; i++){
            hours[i] = new Circle();
            mins[i] = new Circle();
            secs[i] = new Circle();            
        }
    }

    public void paint(Graphics g){

        //if the circle contains a 1 at a certain index, make the circle there cyan. Otherwise, leave it black
        cal = new GregorianCalendar();
        String binaryHours = convertToBinary(cal.get(Calendar.HOUR_OF_DAY));
        String binaryMinutes = convertToBinary(cal.get(Calendar.MINUTE));
        String binarySeconds = convertToBinary(cal.get(Calendar.SECOND));
        writeText(g);
        printTime(g, hours, binaryHours, 1);
        printTime(g, mins, binaryMinutes, 2);
        printTime(g, secs, binarySeconds, 3);
        setBackground(Color.magenta);
        repaint();
    }

    public void printTime(Graphics g, Circle[] circles, String time, int row){
        int xPos = 500/7 + 20;//screenlength + 250
        Color c;
        for(int i = 0; i < time.length(); i++){
            c = Color.black;
            if(time.substring(i, i+1).equals("1")){
                c = Color.cyan;
            }
            circles[i].paintShape(g, xPos, 500/4 * row, c);
            xPos += 50;
        }
    }

    public String convertToBinary(int h){//convert a given number to it's binary representation
        String binary = "";
        while(h > 0){
            if(h%2 == 0){
                binary += "0";
            }else{
                binary += "1";
            }
            h /= 2;
        } 
        binary = new StringBuffer(binary).reverse().toString();
        binary = String.format("%6s", binary).replace(" ", "0");
        return binary;
    }

    public void writeText(Graphics g){

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
}

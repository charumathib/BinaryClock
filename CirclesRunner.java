//creates the circles
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class CirclesRunner extends JPanel{
    Circle[] hours = new Circle[6];
    Circle[] mins = new Circle[6];
    Circle[] secs = new Circle[6];
    int h, m, s;
    public CirclesRunner(){

        for(int i = 0; i < 6; i++){
            hours[i] = new Circle();
        }
        for(int i = 0; i < 6; i++){
            mins[i] = new Circle();
        }
        for(int i = 0; i < 6; i++){
            secs[i] = new Circle();
        } 
    }

    public void paint(Graphics g){

        GregorianCalendar cal = new GregorianCalendar();
        h = cal.get(Calendar.HOUR_OF_DAY);
        m = cal.get(Calendar.MINUTE);
        s = cal.get(Calendar.SECOND);
        String binaryHours = convertToBinary(h);
        String binaryMinutes = convertToBinary(m);
        String binarySeconds = convertToBinary(s);
        
        //if the circle contains a 1 at a certain index, make the circle there black. Otherwise, leave it cyan

        int xPos = 500/5;
        for(int i = 0; i < binarySeconds.length(); i++){
            if(binaryHours.substring(i, i+1).equals("1")){
                hours[i].paint(g, xPos, 500/4 , Color.cyan);
            }else{
                hours[i].paint(g, xPos, 500/4, Color.black);
            }
            xPos += 50;
        }
        xPos = 500/5;
        for(int i = 0; i < binarySeconds.length(); i++){
            if(binaryMinutes.substring(i, i+1).equals("1")){
                mins[i].paint(g, xPos, 500/4 * 2, Color.cyan);
            }else{
                mins[i].paint(g, xPos, 500/4 * 2, Color.black);
            }
            xPos += 50;
        }
        xPos = 500/5;
        for(int i = 0; i < binarySeconds.length(); i++){
            if(binarySeconds.substring(i, i+1).equals("1")){
                secs[i].paint(g, xPos, 500/4 * 3, Color.cyan);
            }else{
                secs[i].paint(g, xPos, 500/4 * 3, Color.black);
            }
            xPos += 50;
        }

     

        repaint();
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
        new StringBuilder(binary).reverse().toString();
        if(binary.length() < 6){
            binary =  makeBinarySix(binary);
        }
        return binary;
    }

    public String makeBinarySix(String num){
        if(num.length() == 5) {
            return "0" + num;
        }
        else if (num.length() == 4) {
            return "00" + num;
        }
        else if(num.length() == 3){
            return "000" + num;
        } 
        else if(num.length() == 2){
            return "0000" + num;
        }
        else if(num.length() == 1){
            return "00000" + num;
        }
        return "000000";
    }
}

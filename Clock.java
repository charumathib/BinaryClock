//find a way to convert given times to binary
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class Clock {
    public Clock(){
        JFrame theGUI = new JFrame();
        theGUI.setTitle("First GUI Program");
        theGUI.setSize(500, 500);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = theGUI.getContentPane();
        CirclesRunner r = new CirclesRunner();
        pane.add(r);
        theGUI.setVisible(true);

    }

    public static void main (String [] args){
        System.out.println("\u000c");

    }

   
}
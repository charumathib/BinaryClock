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
        CirclesRunner cr = new CirclesRunner();
        pane.add(cr);
        theGUI.setVisible(true);

    }   
}
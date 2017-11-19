import java.util.*;
import javax.swing.*;
import java.awt.*;
/**
 * Main class
 */
public class Clock {
    public Clock(){
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Binary Clock - ATTENTION SEIZURE WARNING");
        theGUI.setSize(500, 500);
        theGUI.setResizable(false);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = theGUI.getContentPane();
        ShapeRunner sr = new ShapeRunner();
        pane.add(sr);
        theGUI.setVisible(true);

    }   
}
//create a 6 X 3 array of circles
import javax.swing.*;
import java.awt.*;

public class Circle extends JPanel {
    public void paintShape(Graphics g, int xPos, int yPos, Color c){//creates one circle
        super.paintComponent(g);
        g.setColor(c);
        g.fillOval(xPos, yPos, 20, 20);
        repaint();
    }
}
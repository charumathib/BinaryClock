import javax.swing.*;
import java.awt.*;

public abstract class Shape extends JPanel{
    
    public void paintShape(Graphics g, int xPos, int yPos, Color c) {
        super.paintComponent(g);
        g.setColor(c);  
        fillShape(g, xPos, yPos);
        repaint();
    }
    
    public abstract void fillShape(Graphics g, int xPos, int yPos);
    public abstract Shape getShape();
}

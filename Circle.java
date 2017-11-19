//create a 6 X 3 array of circles
import javax.swing.*;
import java.awt.*;

public class Circle extends Shape {

    public Circle() {         
    }
    
    public Circle getShape() { 
        return new Circle();
    }

    @Override
    public void fillShape(Graphics g, int xPos, int yPos){
        g.fillOval(xPos, yPos, 20, 20);
    }

}
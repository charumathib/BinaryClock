//create a 6 X 3 array of Squares
import javax.swing.*;
import java.awt.*;

public class Square extends Shape {

    public Square() {         
    }

    public Square getShape() { 
        return new Square();
    }
    
    @Override
    public void fillShape(Graphics g, int xPos, int yPos){
        g.fillRect(xPos, yPos, 20, 20);
    }
}
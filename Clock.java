//find a way to convert given times to binary
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Clock {

    ShapeRunner cr ; 

    public Clock(){

        JFrame theGUI = new JFrame();

        theGUI.setTitle("Binary Clock");
        theGUI.setSize(500, 500);
        theGUI.setResizable(false);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = theGUI.getContentPane();
        pane.setLayout(new FlowLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(200, 50));
        buttonPanel.add(createButton());

        cr = new ShapeRunner();
        cr.setPreferredSize(new Dimension(500, 400));

        pane.add(cr);
        pane.add(buttonPanel);

        theGUI.setVisible(true);

    }

    JToggleButton createButton() { 
        JToggleButton button = new JToggleButton("SWITCH SHAPE");
        ActionListener actionListener = new ActionListener() { 
                public void actionPerformed(ActionEvent event) { 
                    AbstractButton abstractButton = (AbstractButton) event.getSource();
                    ButtonModel buttonModel = abstractButton.getModel();
                    boolean selected = buttonModel.isSelected();
                    cr.changeShape() ; 
                }

            };

        button.addActionListener(actionListener); 
        return button;
    }

} 

package program5;

import javax.swing.*;
import java.awt.event.*;

public class swingexample {

    JLabel label;

   swingexample() {

        JFrame f = new JFrame("Image Button Example");

        // Label
        label = new JLabel();
        label.setBounds(50, 50, 400, 50);

        // Buttons with images (place images in same folder)
        JButton b1 = new JButton("Digital Clock", new ImageIcon("clock.png"));
        JButton b2 = new JButton("Hour Glass", new ImageIcon("hourglass.png"));

        b1.setBounds(50, 120, 200, 80);
        b2.setBounds(260, 120, 200, 80);

        // Event handling
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Digital Clock is pressed");
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Hour Glass is pressed");
            }
        });

        // Add components
        f.add(label);
        f.add(b1);
        f.add(b2);

        f.setSize(500, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new swingexample();
    }
}
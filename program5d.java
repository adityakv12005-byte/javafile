package program5;

import javax.swing.*;
import java.awt.event.*;

public class swingexample {

    JLabel label;

    swingexample() {

        JFrame f = new JFrame("Mouse Event Example");

        label = new JLabel("Perform Mouse Action");
        label.setBounds(50, 50, 300, 30);

        JButton btn = new JButton("Click Me");
        btn.setBounds(100, 120, 150, 50);

        // Mouse Listener
        btn.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    label.setText("Double Click Detected");
                } else {
                    label.setText("Single Click Detected");
                }
            }

            public void mousePressed(MouseEvent e) {
                label.setText("Mouse Pressed");
            }

            public void mouseReleased(MouseEvent e) {
                label.setText("Mouse Released");
            }

            public void mouseEntered(MouseEvent e) {
                // optional
            }

            public void mouseExited(MouseEvent e) {
                // optional
            }
        });

        f.add(label);
        f.add(btn);

        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new swingexample();
    }
}
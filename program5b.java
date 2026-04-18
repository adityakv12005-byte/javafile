package program5;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class swingexample {

    JLabel l1;

    swingexample() {

        JFrame f = new JFrame("Button Example");

        l1 = new JLabel();
        l1.setBounds(50, 50, 700, 100);
        l1.setFont(new Font("Lucida Calligraphy", Font.BOLD, 30));

        JButton b1 = new JButton("India");
        JButton b2 = new JButton("Sri Lanka");

        // Button 1
        b1.setBounds(50, 150, 120, 50);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("India is pressed");
            }
        });

        // Button 2
        b2.setBounds(200, 150, 120, 50);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("Sri Lanka is pressed");
            }
        });

        // Add components
        f.add(b1);
        f.add(b2);
        f.add(l1);

        // Frame settings
        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new swingexample();
    }
}
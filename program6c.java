package program5;

import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class swingexample extends JFrame {

    private JList<String> countryList;

    // Map for countries and capitals
    private Map<String, String> capitalMap = new HashMap<>();

    public swingexample() {

        // Frame setup
        setTitle("Country - Capital JList");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create model
        DefaultListModel<String> listModel = new DefaultListModel<>();

        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
        listModel.addElement("Canada");
        listModel.addElement("Denmark");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");
        listModel.addElement("Africa");
        listModel.addElement("Greenland");
        listModel.addElement("Singapore");

        // Capital mapping
        capitalMap.put("USA", "Washington D.C.");
        capitalMap.put("India", "New Delhi");
        capitalMap.put("Vietnam", "Hanoi");
        capitalMap.put("Canada", "Ottawa");
        capitalMap.put("Denmark", "Copenhagen");
        capitalMap.put("France", "Paris");
        capitalMap.put("Great Britain", "London");
        capitalMap.put("Japan", "Tokyo");
        capitalMap.put("Africa", "Addis Ababa");
        capitalMap.put("Greenland", "Nuuk");
        capitalMap.put("Singapore", "Singapore");

        // JList
        countryList = new JList<>(listModel);

        countryList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    String selected = countryList.getSelectedValue();

                    if (selected != null) {
                        System.out.println("Capital of " + selected +
                                " is: " + capitalMap.get(selected));
                    }
                }
            }
        });

        add(new JScrollPane(countryList));

        setVisible(true);
    }

    public static void main(String[] args) {
        new swingexample();
    }
}
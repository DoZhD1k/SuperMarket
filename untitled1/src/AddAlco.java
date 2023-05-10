import Class.Alco;
import Database.Packagedata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAlco extends Container {
    public AddAlco(){
        setSize(600, 400);
        setLayout(null);



        JLabel nameFromLabel = new JLabel("Name");
        nameFromLabel.setBounds(50, 100, 95, 30);
        add(nameFromLabel);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(150, 100, 95, 30);
        add(priceLabel);

        JLabel srokLabel = new JLabel("Storage period");
        srokLabel.setBounds(250, 100, 150, 30);
        add(srokLabel);

        JLabel countLabel = new JLabel("Count");
        countLabel.setBounds(350, 100, 95, 30);
        add(countLabel);

        JLabel litrLabel = new JLabel("Litr");
        litrLabel.setBounds(450, 100, 95, 30);
        add(litrLabel);
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(50, 190, 95, 30);
        add(ageLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(50, 150, 95, 30);
        add(nameField);

        JTextField priceField = new JTextField();
        priceField.setBounds(150, 150, 95, 30);
        add(priceField);

        JTextField srokField = new JTextField();
        srokField.setBounds(250, 150, 95, 30);
        add(srokField);

        JTextField countField = new JTextField();
        countField.setBounds(350, 150, 95, 30);
        add(countField);

        JTextField litrField = new JTextField();
        litrField.setBounds(450, 150, 95, 30);
        add(litrField);

        JTextField ageField = new JTextField();
        ageField.setBounds(50, 230, 95, 30);
        add(ageField);


        JButton findButton = new JButton("Add");
        findButton.setBounds(450, 230, 95, 30);
        add(findButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(275, 230, 150, 30);
        add(backButton);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Alco alco = new Alco(null, nameField.getText(), Integer.parseInt(priceField.getText()),srokField.getText(),Integer.parseInt(countField.getText()), Integer.parseInt(ageField.getText()),Double.parseDouble(litrField.getText()));
                Packagedata pd = new Packagedata("ADD ALCO", alco);
                Main.connect(pd);
                JOptionPane.showMessageDialog(null,"SUCCESSFUL");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addAlco.setVisible(false);
                MainFrame.adminMenu.setVisible(true);
            }
        });
    }
}



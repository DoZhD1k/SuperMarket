
import Database.Packagedata;
import Class.Food;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFood extends Container {
    public AddFood(){
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

        JLabel kgLabel = new JLabel("Sort");
        kgLabel.setBounds(450, 100, 95, 30);
        add(kgLabel);

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

        JTextField kgField = new JTextField();
        kgField.setBounds(450, 150, 95, 30);
        add(kgField);

        JButton findButton = new JButton("Add");
        findButton.setBounds(450, 200, 95, 30);
        add(findButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(250, 200, 150, 30);
        add(backButton);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Food alco = new Food(null,(String) nameField.getText(), Integer.parseInt(priceField.getText()),srokField.getText(),Integer.parseInt(countField.getText()),kgField.getText());
                Packagedata pd = new Packagedata("ADD FOOD", alco);
                Main.connect(pd);
                JOptionPane.showMessageDialog(null,"SUCCESSFUL");

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addFood.setVisible(false);
                MainFrame.adminMenu.setVisible(true);
            }
        });
    }
}



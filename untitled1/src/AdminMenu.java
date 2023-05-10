import Database.Packagedata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends Container {
    public static JTextArea textArea;

    public AdminMenu(){


        setSize(600, 400);
        setLayout(null);
    /*
        JTextArea textArea = new JTextArea();
        textArea.setBounds(70, 50, 240, 180);
        textArea.setEditable(false);
        add(textArea);

     */




        JButton addAlcoButton = new JButton("ADD DRINKS");
        addAlcoButton.setBounds(200, 20, 140, 30);
        add(addAlcoButton);

        JButton addFoodButton = new JButton("ADD FOOD");
        addFoodButton.setBounds(200, 70, 140, 30);
        add(addFoodButton);

        JButton addProduct = new JButton("ADD OTHER");
        addProduct.setBounds(200, 120, 140, 30);
        add(addProduct);

        JButton backButton = new JButton("EXIT");
        backButton.setBounds(200, 220, 140, 30);
        add(backButton);

        JButton flistButton = new JButton("LIST ");
        flistButton.setBounds(200, 170, 140, 30);
        add(flistButton);








        flistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.listMenu.setVisible(true);
                Main.frame.adminMenu.setVisible(false);
            }
        });



        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.menu.setVisible(true);
                Main.frame.adminMenu.setVisible(false);

            }
        });


        addAlcoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.frame.addAlco.setVisible(true);
                Main.frame.adminMenu.setVisible(false);
            }
        });

        addFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.frame.addFood.setVisible(true);
                Main.frame.adminMenu.setVisible(false);
            }
        });

        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.frame.addProduct.setVisible(true);
                Main.frame.adminMenu.setVisible(false);
            }
        });

    }
}



import Class.Customer;
import Database.Packagedata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Signup extends Container {
    public Signup(){
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel();
        label.setBounds(75, 50, 100, 100);
        add(label);

        JLabel nameLabel = new JLabel("NAME:");
        nameLabel.setBounds(125, 50, 100, 30);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(225, 50, 200, 30);
        add(nameField);

        JLabel surnameLabel = new JLabel("EMAIL:");
        surnameLabel.setBounds(125, 100, 100, 30);
        add(surnameLabel);

        JTextField surnameField = new JTextField();
        surnameField.setBounds(225, 100, 200, 30);
        add(surnameField);


        JLabel loginLabel = new JLabel("LOGIN:");
        loginLabel.setBounds(125, 150, 100, 30);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(225, 150, 200, 30);
        add(loginField);

        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setBounds(125, 200, 100, 30);
        add(passwordLabel);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(225, 200, 200, 30);
        add(passwordField);

        JLabel ageLabel = new JLabel("AGE:");
        ageLabel.setBounds(125, 250, 100, 30);
        add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setBounds(225, 250, 200, 30);
        add(ageField);

        JButton singButton = new JButton("Sing up");
        singButton.setBounds(125, 300, 140, 40);
        add(singButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(275, 300, 150, 40);
        add(backButton);

        singButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    Customer customer = new Customer(null,nameField.getText(), surnameField.getText(), loginField.getText(), passwordField.getText(),Integer.parseInt(ageField.getText()));
                    Packagedata pd = new Packagedata("ADD CUSTOMER", customer);
                    Main.connect(pd);
                    JOptionPane.showInternalMessageDialog(null, "SUCCESS");









                }catch (Exception a){
                    a.printStackTrace();
                }

                ageField.setText(null);
                nameField.setText(null);
                surnameField.setText(null);
                loginField.setText(null);
                passwordField.setText(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.signup.setVisible(false);
                Main.frame.menu.setVisible(true);
            }
        });

    }}

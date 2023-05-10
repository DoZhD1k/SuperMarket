import Database.DBManager;
import Database.Packagedata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static Database.DBManager.connection;
import Class.Customer;
public class Menu extends Container {
    public static Customer customer;

    public Menu(){
        setSize(600, 400);
        setLayout(null);

        JLabel loginLabel = new JLabel("LOGIN:");
        loginLabel.setBounds(125, 100, 100, 30);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(225, 100, 200, 30);
        add(loginField);

        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setBounds(125, 150, 100, 30);
        add(passwordLabel);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(225, 150, 200, 30);
        add(passwordField);

        JButton logInButton = new JButton("Log in");
        logInButton.setBounds(125, 200, 140, 40);
        add(logInButton);

        JButton signButton = new JButton("Sign in");
        signButton.setBounds(275, 200, 150, 40);
        add(signButton);


        JButton adminButton = new JButton("Admin");
        adminButton.setBounds(200, 250, 150, 40);
        add(adminButton);


        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Packagedata packagedata = new Packagedata("GET USER",loginField.getText() );
                    Main.connect(packagedata);
                    DBManager manager = new DBManager();
                    manager.connect();
                    PreparedStatement statement = connection.prepareStatement("" +
                            "SELECT * FROM user WHERE login = '" + loginField.getText() + "'" + "and password = '" + passwordField.getText() + "'");
                    ResultSet resultSet = statement.executeQuery();

                    /*
                    Packagedata pd = new Packagedata("GET CUSTOMER", loginField.getText());
                    Main.connect(pd);

                     */

                    if(resultSet.next()){
                        loginField.setText(null);
                        passwordField.setText(null);

                        Main.frame.menu.setVisible(false);
                        Main.frame.userMenu.setVisible(true);
                        JOptionPane.showInternalMessageDialog(null,"WELCOME");
                    }
                    else{
                        JOptionPane.showInternalMessageDialog(null,"Wrond login or password");
                    }

                }catch (Exception a){
                    a.printStackTrace();
                }

            }
        });


        signButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.signup.setVisible(true);
                Main.frame.menu.setVisible(false);
            }
        });



        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.adminMenu.setVisible(true);
                Main.frame.menu.setVisible(false);
            }

        });


    }
}

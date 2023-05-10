import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Class.Customer;
import Database.Packagedata;

public class UserMenu extends Container {
    public static Customer customer;
    public static JTextArea info;


    public UserMenu(){
        setSize(600, 400);
        setLayout(null);
        info = new JTextArea();
        info.setEditable(false);
        info.setBounds(100, 100, 400, 170);
        add(info);
        JLabel comp = new JLabel("YOUR CART:" );
        comp.setBounds(275, 70, 150, 20);
        add(comp);



        JButton compButton = new JButton("PRODUCTS");
        compButton.setBounds(350, 10, 150, 40);
        add(compButton);

        JButton listButton = new JButton("CARD LIST");
        listButton.setBounds(100, 10, 150, 40);
        add(listButton);


        JButton backButton = new JButton("EXIT");
        backButton.setBounds(225, 300, 150, 40);
        add(backButton);

        compButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.userMenu.setVisible(false);
                Main.frame.buyProduct.setVisible(true);

            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                info.setText(null);
                Packagedata pd = new Packagedata("LIST CARD",Menu.customer.getId());
                Main.connect(pd);
            }
        });


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.frame.userMenu.setVisible(false);
                Main.frame.menu.setVisible(true);

            }
        });



    }
}

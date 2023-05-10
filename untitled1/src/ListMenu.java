
import Database.Packagedata;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListMenu extends Container {
    public static JTextArea textArea;
    public ListMenu(){
        setSize(600, 400);
        setLayout(null);


        JButton alistButton = new JButton("LIST Alco");
        alistButton.setBounds(75, 50, 150, 30);
        add(alistButton);
        JButton flistButton = new JButton("LIST Food");
        flistButton.setBounds(225, 50, 150, 30);
        add(flistButton);
        JButton plistButton = new JButton("LIST Product");
        plistButton.setBounds(375, 50, 150, 30);
        add(plistButton);





        alistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                Packagedata pd = new Packagedata("LIST ALCO");
                Main.connect(pd);

            }
        });

        flistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                Packagedata pd = new Packagedata("LIST FOOD");
                Main.connect(pd);

            }
        });

        plistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                Packagedata pd = new Packagedata("LIST PRODUCT");
                Main.connect(pd);

            }
        });



        textArea = new JTextArea();
        textArea.setBounds(100, 90, 400, 170);
        add(textArea);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(100, 270, 400, 30);
        add(backButton);




        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.listMenu.setVisible(false);
                Main.frame.adminMenu.setVisible(true);
            }
        });
    }
}

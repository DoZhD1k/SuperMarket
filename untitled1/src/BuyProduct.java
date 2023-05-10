
import Database.Packagedata;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Class.Alco;
import Class.Product;

public class BuyProduct extends Container {
    public static Product product;
    public static Alco alco;
    public static JTextArea textArea;
    public BuyProduct(){
        setSize(600, 400);
        setLayout(null);


        JButton alistButton = new JButton("LIST DRINKS");
        alistButton.setBounds(75, 50, 150, 30);
        add(alistButton);
        JButton flistButton = new JButton("LIST FOOD");
        flistButton.setBounds(225, 50, 150, 30);
        add(flistButton);
        JButton plistButton = new JButton("LIST OTHER");
        plistButton.setBounds(375, 50, 150, 30);
        add(plistButton);

        JLabel numberLabel = new JLabel("ID: ");
        numberLabel.setBounds(100,325,100,30);
        add(numberLabel);

        JTextField numberField = new JTextField();
        numberField.setBounds(150, 325,100,30);
        add(numberField);


        JLabel countLabel = new JLabel("count: ");
        countLabel.setBounds(300,325,100,30);
        add(countLabel);

        JTextField countField = new JTextField();
        countField.setBounds(350, 325,100,30);
        add(countField);



        JButton buyButton = new JButton("Buy");
        buyButton.setBounds(400, 270, 100, 30);
        add(buyButton);






        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Packagedata pd5 = new Packagedata("GET COUNT",Integer.parseInt(numberField.getText()));
                Main.connect(pd5);

                Packagedata pd0 = new Packagedata("GET AGE",Integer.parseInt(numberField.getText()));
                Main.connect(pd0);
                System.out.println(Integer.parseInt(countField.getText()));
                System.out.println(product.getCount());
                if(Integer.parseInt(countField.getText())<= product.getCount()) {

                    if (Menu.customer.getAge() >= alco.getAge()) {
                        Packagedata pd = new Packagedata("ADD CARD", Menu.customer.getId(), Integer.parseInt(numberField.getText()), Integer.parseInt(countField.getText()));
                        Main.connect(pd);
                        Packagedata pd3 = new Packagedata("UPDATE PRODUCT", Integer.parseInt(numberField.getText()), Integer.parseInt(countField.getText()));
                        Main.connect(pd3);
                        JOptionPane.showMessageDialog(null, "SUCCESSFUL");
                    } else {
                        JOptionPane.showMessageDialog(null, "This " + alco.getAge() + "+ ");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, " Limited number of products");
                }





            }
        });



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
        textArea.setEditable(false);
        add(textArea);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(100, 270, 150, 30);
        add(backButton);




        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.buyProduct.setVisible(false);
                Main.frame.userMenu.setVisible(true);
            }
        });
    }
}

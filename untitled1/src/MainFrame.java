import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public static Menu menu;
    public static Signup signup;



    public static UserMenu userMenu;
    public static AddAlco addAlco;
    public static AddFood addFood;
    public static AddProduct addProduct;
    public static ListMenu listMenu;

    public static BuyProduct buyProduct;
    public static AdminMenu adminMenu;
    public MainFrame(){
        setSize(600, 400);
        setTitle("First GUI APP");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        menu = new Menu();
        menu.setLocation(0,0);
        add(menu);

        signup = new Signup();
        signup.setVisible(false);
        signup.setLocation(0,0);
        add(signup);

        buyProduct = new BuyProduct();
        buyProduct.setVisible(false);
        buyProduct.setLocation(0,0);
        add(buyProduct);

        addAlco = new AddAlco();
        addAlco.setVisible(false);
        addAlco.setLocation(0,0);
        add(addAlco);

        addFood = new AddFood();
        addFood.setVisible(false);
        addFood.setLocation(0,0);
        add(addFood);

        addProduct = new AddProduct();
        addProduct.setVisible(false);
        addProduct.setLocation(0,0);
        add(addProduct);

        listMenu = new ListMenu();
        listMenu.setVisible(false);
        listMenu.setLocation(0,0);
        add(listMenu);




        userMenu = new UserMenu();
        userMenu.setVisible(false);
        userMenu.setLocation(0,0);
        add(userMenu);


        adminMenu = new AdminMenu();
        adminMenu.setVisible(false);
        adminMenu.setLocation(0,0);
        add(adminMenu);









    }
}

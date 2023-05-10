package Database;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import Class.*;

import javax.swing.*;

public class DBManager  {
    public static Connection connection = null;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/smarket?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


/*
    public void addCard(Alco ticket,int customer_id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO card (id, customer_id,name, price, srok,count, age, litre) " +
                    "VALUES (NULL, ?, customer_id, ?, ?, ?, ?,?,?,?)");
            statement.setInt(1, customer_id);
            statement.setString(3, ticket.getName());
            statement.setInt(4, ticket.getPrice());
            statement.setString(5, ticket.getSrok());
            statement.setInt(6, ticket.getCount());
            statement.setInt(7, ticket.getAge());
            statement.setDouble(8, ticket.getL());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

 */



    public void updateProduct(Integer id, int number) {
        try{
            PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM product WHERE id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int count = resultSet.getInt("count");
                if(number>count){
                    break;
                }else {
                    statement = connection.prepareStatement("" + "UPDATE product SET count=? WHERE id=?");

                    statement.setInt(2, id);
                    statement.setInt(1, count-number);
                    statement.executeUpdate();
                    statement.close();
                }
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }





    public void addCard(int customer_id, int product_id, int count) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO cart (id, customer_id,product_id, count) " +
                    "VALUES (NULL, ?,?,?)");
            statement.setInt(1, customer_id);
            statement.setInt(2, product_id);
            statement.setInt(3, count);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getAllCart(Integer idka){
        ArrayList<Product> productList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cart WHERE customer_id = '" + idka + "'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                int count = resultSet.getByte("count");
                productList.add(getProduct(id,count));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }


    public Product getProduct(Integer idka, int count){
        Product product = new Product();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE id = '" + idka + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String srok = resultSet.getString("srok");
                product = new Product(id, name, price,srok, count);
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    public Product getProductCount(Integer idka){
        Product product = new Product();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE id = '" + idka + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String srok = resultSet.getString("srok");
                int count = resultSet.getInt("count");
                product = new Product(id, name, price,srok, count);
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    public Alco getAcloAge(Integer idka){
        Alco product = new Alco();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE id = '" + idka + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                int age = resultSet.getInt("age");
                product = new Alco(age);
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }








    public void addUser(Customer customer) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO user (id, login, password, name, surname, age) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?)");
            statement.setString(1, customer.getLogin());
            statement.setString(2, customer.getPassword());
            statement.setString(3, customer.getName());
            statement.setString(4, customer.getSurname());
            statement.setInt(5, customer.getAge());
            statement.executeUpdate();

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*

    public ArrayList<Ticket> FindTicket(String genre){
        ArrayList<Ticket> TicketList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ticket WHERE type ='" + genre + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String time = resultSet.getString("time");
                int price = resultSet.getInt("price");
                int day = resultSet.getInt("day");
                String month = resultSet.getString("month");
                int place = resultSet.getInt("place");
                int age = resultSet.getInt("age");

                TicketList.add(new Ticket(id, type, name, time, price, day, month, place, age));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return TicketList;
    }


    public ArrayList<Ticket> getAllTicket(){
        ArrayList<Ticket> TicketList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ticket");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String time = resultSet.getString("time");
                int price = resultSet.getInt("price");
                int day = resultSet.getInt("day");
                String month = resultSet.getString("month");
                int place = resultSet.getInt("place");
                int age = resultSet.getInt("age");

                TicketList.add(new Ticket(id, type, name, time, price, day, month, place, age));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return TicketList;
    }

    public Ticket getTicket(int idClient){
        Ticket ticket = new Ticket();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ticket where id='" + idClient + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String time = resultSet.getString("time");
                int price = resultSet.getInt("price");
                int day = resultSet.getInt("day");
                String month = resultSet.getString("month");
                int place = resultSet.getInt("place");
                int age = resultSet.getInt("age");

                ticket = new  Ticket(id, type, name, time, price, day, month, place, age);            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ticket;
    }

     */



    public Customer getUser(String login) {
        Customer customer = new Customer();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user where login='" + login + "'");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                customer = new Customer(id,age);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return customer;
    }





    public void addAlco(Alco alco) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO product (id, name, price, srok ,count, age,l,typeid )" +
                    "VALUES (NULL, ?, ?, ?, ?,?,?,1)");
            statement.setString(1, alco.getName());
            statement.setInt(2, alco.getPrice());
            statement.setString(3, alco.getSrok());
            statement.setInt(4, alco.getCount());
            statement.setInt(5, alco.getAge());
            statement.setDouble(6,alco.getL());
            statement.executeUpdate();

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addFood(Food food) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO product (id, name, price, srok ,count, kg, typeid) " +
                    "VALUES (NULL, ?, ?, ?, ?,?,2)");
            statement.setString(1, food.getName());
            statement.setInt(2, food.getPrice());
            statement.setString(3, food.getSrok());
            statement.setInt(4, food.getCount());
            statement.setString(5, food.getKg());
            statement.executeUpdate();

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addProduct(Product food) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO product (id, name, price, srok ,count,typeid) " +
                    "VALUES (NULL, ?, ?, ?, ?,3)");
            statement.setString(1, food.getName());
            statement.setInt(2, food.getPrice());
            statement.setString(3, food.getSrok());
            statement.setInt(4, food.getCount());
            statement.executeUpdate();

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
    public void deleteTicket(Integer id){
        try{
            PreparedStatement statement = connection.prepareStatement("" + "DELETE FROM ticket WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
  /*

 */


    public ArrayList<Alco> getAllAlco() {
        ArrayList<Alco> alcoArrayList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE typeid = '" + 1 + "'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String srok = resultSet.getString("srok");
                int count = resultSet.getInt("count");
                double l = resultSet.getDouble("l");
                int age = resultSet.getInt("age");
                alcoArrayList.add(new Alco(id, name, price, srok, count, age,l));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alcoArrayList;
    }

    public ArrayList<Food> getAllFood() {
        ArrayList<Food> foodArrayList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE typeid = '" + 2 + "'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String srok = resultSet.getString("srok");
                int count = resultSet.getInt("count");
                String kg = resultSet.getString("kg");

                foodArrayList.add(new Food(id, name, price, srok, count,kg));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foodArrayList;
    }

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE typeid = '" + 3 + "'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String srok = resultSet.getString("srok");
                int count = resultSet.getInt("count");

                arrayList.add(new Product(id, name, price, srok, count));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }




}


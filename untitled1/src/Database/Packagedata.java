package Database;
import Class.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Packagedata implements Serializable {
    private String operationType;
    private Customer customer;
    private Alco alco;

    private Food food;

    private Product product;

    private Integer id_product;
    private int id_user;
    private int count;

    public Packagedata(String operationType, int id_user) {
        this.operationType = operationType;
        this.id_user = id_user;
    }

    public Packagedata(String operationType, int id_user, int id_product, int count) {
        this.operationType = operationType;
        this.id_product = id_product;
        this.id_user = id_user;
        this.count = count;
    }

    public Packagedata(String operationType, int id_product, int id_user) {
        this.operationType = operationType;
        this.id_product = id_product;
        this.id_user = id_user;
    }

    public Packagedata(String operationType, String login) {
        this.operationType = operationType;
        this.login = login;
    }

    private String login;

    private ArrayList<Customer> customers;

    private ArrayList<Alco> alcoArrayList;

    private ArrayList<Food> foodArrayList;

    private ArrayList<Product> productArrayList;

    public Packagedata() {
    }

    public Packagedata(String operationType, Alco alco) {
        this.operationType = operationType;
        this.alco = alco;
    }

    public Packagedata(String operationType, Food food) {
        this.operationType = operationType;
        this.food = food;
    }

    public Packagedata(String operationType, Product product) {
        this.operationType = operationType;
        this.product = product;
    }

    public Packagedata(String operationType) {
        this.operationType = operationType;
    }



    public Packagedata(String operationType, Customer customer) {
        this.operationType = operationType;
        this.customer = customer;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Alco getAlco() {
        return alco;
    }

    public void setAlco(Alco alco) {
        this.alco = alco;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ArrayList<Alco> getAlcoArrayList() {
        return alcoArrayList;
    }

    public void setAlcoArrayList(ArrayList<Alco> alcoArrayList) {
        this.alcoArrayList = alcoArrayList;
    }

    public ArrayList<Food> getFoodArrayList() {
        return foodArrayList;
    }

    public void setFoodArrayList(ArrayList<Food> foodArrayList) {
        this.foodArrayList = foodArrayList;
    }

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

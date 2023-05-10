package Server;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import Class.*;
import Database.*;
public class ServerThread extends Thread{
    private Socket socket;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try{
            DBManager manager = new DBManager();
            manager.connect();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Packagedata data = null;

            while((data = ((Packagedata)inputStream.readObject())) != null) {
                if (data.getOperationType().equals("ADD CUSTOMER")) {
                    Customer customer = data.getCustomer();
                    manager.addUser(customer);
                    break;
                }
               else if (data.getOperationType().equals("ADD ALCO")) {
                    Alco alco = data.getAlco();
                    manager.addAlco(alco);
                    break;
                }
                else if (data.getOperationType().equals("ADD FOOD")) {
                    Food food = data.getFood();
                    manager.addFood(food);
                    break;
                }
                else if (data.getOperationType().equals("ADD CARD")) {
                    int customer_id = data.getId_user();
                    int product_id = data.getId_product();
                    int count = data.getCount();
                    manager.addCard(customer_id,product_id, count);
                    break;
                }
                else if (data.getOperationType().equals("ADD PRODUCT")) {
                    Product food = data.getProduct();
                    manager.addProduct(food);
                    break;
                }

                else if(data.getOperationType().equals("LIST ALCO")){
                    ArrayList<Alco> arrayAlco = manager.getAllAlco();
                    Packagedata alcolist = new Packagedata();
                    alcolist.setAlcoArrayList(arrayAlco);
                    outputStream.writeObject(alcolist);
                    break;
                }
                else if(data.getOperationType().equals("GET USER")){
                    Customer customer = manager.getUser(data.getLogin());
                    Packagedata ticketlist = new Packagedata();
                    ticketlist.setCustomer(customer);
                    outputStream.writeObject(ticketlist);
                    break;
                }
                else if(data.getOperationType().equals("GET AGE")){
                    Alco customer = manager.getAcloAge(data.getId_user());
                    Packagedata ticketlist = new Packagedata();
                    ticketlist.setAlco(customer);;
                    outputStream.writeObject(ticketlist);
                    break;
                }
                else if(data.getOperationType().equals("GET COUNT")){
                    Product customer = manager.getProductCount(data.getId_user());
                    Packagedata ticketlist = new Packagedata();
                    ticketlist.setProduct(customer);;
                    outputStream.writeObject(ticketlist);
                    break;
                }
                else if(data.getOperationType().equals("LIST FOOD")){
                    ArrayList<Food> arrayAlco = manager.getAllFood();
                    Packagedata alcolist = new Packagedata();
                    alcolist.setFoodArrayList(arrayAlco);
                    outputStream.writeObject(alcolist);
                    break;
                }
                else if(data.getOperationType().equals("LIST PRODUCT")){
                    ArrayList<Product> arrayAlco = manager.getAllProduct();
                    Packagedata alcolist = new Packagedata();
                    alcolist.setProductArrayList(arrayAlco);
                    outputStream.writeObject(alcolist);
                    break;
                }
                else if(data.getOperationType().equals("UPDATE PRODUCT")){
                    int idServer = data.getId_product();
                    int count = data.getId_user();
                    manager.updateProduct(idServer, count);
                    break;
                }
                else if(data.getOperationType().equals("LIST CARD")){
                    ArrayList<Product> arrayTicket = manager.getAllCart(data.getId_user());
                    Packagedata ticketlist = new Packagedata();
                    ticketlist.setProductArrayList(arrayTicket);
                    outputStream.writeObject(ticketlist);
                    break;
                }
                /*
                else if(data.getOperationType().equals("LIST TICKET")){
                    ArrayList<Ticket> arrayTicket = manager.getAllTicket();
                    Packagedata ticketlist = new Packagedata();
                    ticketlist.setTickets(arrayTicket);
                    outputStream.writeObject(ticketlist);
                    break;
                }
                else if(data.getOperationType().equals("LIST CARD")){
                    ArrayList<Ticket> arrayTicket = manager.getCard(data.getId());
                    Packagedata ticketlist = new Packagedata();
                    ticketlist.setTickets(arrayTicket);
                    outputStream.writeObject(ticketlist);
                    break;
                }
                else if(data.getOperationType().equals("GET TICKET")){
                    Ticket arrayTicket = manager.getTicket(data.getId());
                    Packagedata ticketlist = new Packagedata();
                    ticketlist.setTicket(arrayTicket);
                    outputStream.writeObject(ticketlist);
                    break;
                }
                else if(data.getOperationType().equals("GET USER")){
                    User user = manager.getUser(data.getLogin());
                    Packagedata userlist = new Packagedata();
                    userlist.setUser(user);
                    outputStream.writeObject(userlist);
                    break;
                }
                else if(data.getOperationType().equals("ADD CARD")){
                    Ticket ticket= data.getTicket();
                    int id = data.getId();
                    manager.addCard(ticket,id);
                    break;
                }
                else if(data.getOperationType().equals("FIND TICKET")){
                    String genre = data.getLogin();
                    ArrayList<Ticket> arrayTicket = manager.FindTicket(genre);
                    Packagedata ticketlist = new Packagedata();
                    ticketlist.setTickets(arrayTicket);
                    outputStream.writeObject(ticketlist);
                    break;
                }

                 */
                inputStream.close();
                outputStream.close();
                socket.close();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

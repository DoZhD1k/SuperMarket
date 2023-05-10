package Class;

import java.io.Serializable;

public class Food extends Product implements Serializable {
    private String kg;

    public Food(Integer id, String name, int price, String srok, int count, String kg) {
        super(id, name, price, srok, count);
        this.kg = kg;
    }

    public String getKg() {
        return kg;
    }

    public void setKg(String kg) {
        this.kg = kg;
    }

    @Override
    public String toString() {
        return  getId() + ") " + getName() + ", price: " + getPrice() + ", kg: " +
                 ", count :"+ getCount() + kg + ", ST: " + getSrok();

    }
}

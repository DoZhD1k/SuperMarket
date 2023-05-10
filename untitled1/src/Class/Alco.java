package Class;

import java.io.Serializable;

public class Alco extends Product implements Serializable {
    private int age;
    private double l;

    public Alco() {
    }

    public Alco(int age) {
        this.age = age;
    }

    public Alco(Integer id, String name, int price, String srok, int count, int age, double l) {
        super(id, name, price, srok, count);
        this.age = age;
        this.l = l;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    @Override
    public String toString() {
        return getId() + ") " + getName() + " litre: " + l + " price: " +
                getPrice() + " " + age +
                "+ " + " Count: " +  getCount();
    }
}

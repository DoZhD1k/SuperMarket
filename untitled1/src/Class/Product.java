package Class;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer id;
    private String name;
    private int price;

    private String srok;
    private int count;

    public Product(Integer id, String name, int price, String srok, int count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.srok = srok;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSrok() {
        return srok;
    }

    public void setSrok(String srok) {
        this.srok = srok;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return   id + ") " +name + " price: " +
                 price +  "tg " +
                "ST: " + srok  +
                " count: "  + count;

    }
}

package chap18;

import java.io.Serializable;

public class Product implements Serializable {
    public static final long serialVersionUID=2L;

    private String id;
    private int price;

    public Product(String id, int price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", price=" + price +
                '}';
    }
}

package modules;

import enumclasses.GarnmentType;
import enumclasses.Size;
import enumclasses.Textile;

import java.util.Date;

public class Garnment extends Product{
    private Size size;
    private Textile textile;
    private GarnmentType garnmentType;

    public Garnment(String name, String brand, double price,
                    int stock, Date purchaseDate, int discount,
                    Size size, Textile textile, GarnmentType garnmentType) {
        super(name, brand, price, stock, purchaseDate, discount);
        this.size = size;
        this.textile = textile;
        this.garnmentType = garnmentType;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "size=" + size +
                ", textile=" + textile +
                ", garnmentType=" + garnmentType +
                '}';
    }
}

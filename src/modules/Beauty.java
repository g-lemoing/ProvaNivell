package modules;

import enumclasses.Season;

import java.util.Date;

public class Beauty extends Product{
    private boolean vegan;
    private Season season;

    public Beauty(String name, String brand, double price,
                  int stock, Date purchaseDate, int discount,
                  boolean vegan, Season season) {
        super(name, brand, price, stock, purchaseDate, discount);
        this.vegan = vegan;
        this.season = season;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "vegan=" + vegan +
                ", season=" + season +
                '}';
    }
}

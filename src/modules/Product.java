package modules;

import java.util.Date;

public class Product {
    private static int autoID = 1;
    private int id;
    private String name;
    private String brand;
    private double price;
    private int stock;
    private Date purchaseDate;
    private int discount;

    public Product(String name, String brand, double price, int stock, Date purchaseDate, int discount) {
        this.id = autoID;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
        this.purchaseDate = purchaseDate;
        this.discount = discount;
        autoID++;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", purchaseDate=" + purchaseDate +
                ", discount=" + discount +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public int getStockQty() {
        return stock;
    }

    public void setStockQty(int stock) {
        this.stock = stock;
    }
}

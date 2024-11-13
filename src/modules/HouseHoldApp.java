package modules;

import java.util.Date;

public class HouseHoldApp extends Product{
    private int powerConsum;
    private Date manufDate;
    private int capacity;
    private static final int MONTH_WARRANTY = 18;


    public HouseHoldApp(String name, String brand, double price, int stock,
                        Date purchaseDate, int discount, int powerConsum,
                        Date manufDate, int capacity) {
        super(name, brand, price, stock, purchaseDate, discount);
        this.powerConsum = powerConsum;
        this.manufDate = manufDate;
        this.capacity = capacity;
    }

    public static int getWarranty() {
        return MONTH_WARRANTY;
    }

    @Override
    public String toString() {
        return super.toString() + "HouseHoldApp{" +
                "powerConsum=" + powerConsum +
                ", manufDate=" + manufDate +
                ", capacity=" + capacity +
                '}';
    }
}

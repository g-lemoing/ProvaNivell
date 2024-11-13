package modules;

import enumclasses.BatteryCapacity;

import java.util.Date;

public class ElectComponents extends Product{
    private BatteryCapacity batteryCapacity;
    private String screenDef;
    private static final int MONTH_WARRANTY = 9;

    public ElectComponents(String name, String brand, double price,
                           int stock, Date purchaseDate, int discount,
                           String screenDef, BatteryCapacity batteryCapacity) {
        super(name, brand, price, stock, purchaseDate, discount);
        this.batteryCapacity = batteryCapacity;
        this.screenDef = screenDef;
    }

    public static int getWarranty() {
        return MONTH_WARRANTY;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "batteryCapacity=" + batteryCapacity +
                ", pulgadas='" + screenDef + '\'' +
                '}';
    }
}

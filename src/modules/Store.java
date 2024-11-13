package modules;

import enumclasses.*;
import exceptions.ProductNotFoundException;

import java.util.*;

import static modules.Menu.readProductType;

public class Store {
    private List<Product> products;

    public Store() {
        this.products = new ArrayList<>();
    }

    public Product createProduct(){
        Product product = null;

        String name = Menu.menuAskString("Entre el nombre del producto: ");
        String brand = Menu.menuAskString("Entre la marca del producto: ");
        double price = Menu.askDouble("Entre el precio (formato decimal) del producto: ");
        int stockQty = Menu.askInt("Entre el stock del producto: ");
        Date purchaseDate = Menu.askDate("Entre la fecha de compra del producto (formato 'yyyy-MM-dd'): ");
        int discount = Menu.askInt("Entre el porcentaje de descuento (entero) del producto: ");

        switch (readProductType()){

            case 0:
                Size size = Menu.menuAskSize("Entre la talla del producto: [XS, S, M, L, XL, XXL]");
                Textile textileType = Menu.menuAskTextile("Tipo de tejido: [Algodon, Lana, Poliester, Seda]");
                GarnmentType garnmentType = Menu.menuAskGarnmentType("Tipo de prenda: [Tops, Pantalones, RopaInterior]");
                product = new Garnment(name, brand, price, stockQty, purchaseDate, discount,
                        size, textileType, garnmentType);
                break;
            case 1:
                int powerConsum = Menu.askInt("Consumo en W del aparato: ");
                Date manufDate = Menu.askDate("Fecha de fabricación del producto (formato 'yyyy-MM-dd'): ");
                int capacity = Menu.askInt("Capacidad de carga en kg en lavadoras: ");
                product = new HouseHoldApp(name, brand, price, stockQty, purchaseDate, discount,
                        powerConsum, manufDate, capacity);
                break;
            case 2:
                String imageResol = Menu.menuAskString("Resolución de imagen en pulgadas: ");
                BatteryCapacity batteryCapacity = Menu.menuAskBattery("Capacidad de la batería: [_2500mAH, _3000mAH, _4000mAH]: ");
                product = new ElectComponents(name, brand, price, stockQty, purchaseDate, discount,
                        imageResol, batteryCapacity);
                break;
            case 3:
                boolean vegan = Menu.askYesNo("¿Este producto es vegano? (Sí --> S, No --> N");
                Season season = Menu.menuAskSeason("Temporada de uso del producto [PRIMAVERA, VERANO, OTOÑO, INVIERNO]: ");
                product = new Beauty(name, brand, price, stockQty, purchaseDate, discount,
                        vegan, season);
                break;
            default:
        }
        return product;
    }
    public void addProduct(Product product){
        products.add(product);
        System.out.println("Se ha añadido a la tienda el producto\n" + product.toString());
    }

    public List<Product> productList(){
        return this.products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .toList();
    }

    public void deleteProduct(int id) throws ProductNotFoundException {
        Product product = getProductById(id);
        if (product == null){
            throw new ProductNotFoundException("El producto indicado no existe.");
        }
        else{
            this.products.remove(product);
            System.out.println("Producto " + product.getId() + " eliminado de la tienda");
        }
    }

    public Product getProductById(int id){
        return this.products.stream().
                filter(product -> product.getId() == id)
                .findFirst().orElse(null);
    }

    public void calculateWarranty(int id){
        Product product = this.getProductById(id);
        Calendar c = Calendar.getInstance();
        if (product != null){
            c.setTime(product.getPurchaseDate());
            if(product instanceof ElectComponents){
                c.add(Calendar.MONTH, ElectComponents.getWarranty() );
            }else if(product instanceof HouseHoldApp){
                c.add(Calendar.MONTH, HouseHoldApp.getWarranty());
            }
            else {
                System.out.println("Este tipo de producto no dispone de garantía");
                return;
            }
        }else {
            System.out.println("Producto no encontrado");
            return;
        }
        System.out.println("La garantía del producto " + product
                + " vence el día : " + c.getTime());
    }

    public void setDiscount(){
        int id = Menu.askInt("Entre el id del producto al que desea aplicar un descuento: ");
        Product product = this.getProductById(id);
        if (product == null){
            System.out.println("Este producto no existe");
            return;
        }
        int discount = Menu.askInt("Entre el descuento (entero) a aplicar a este producto: ");
        if (discount< 0 || discount > 100){
            System.out.println("Valor de descuento incorrecto, se espera un valor entre 0 y 100");
            return;
        }
        product.setDiscount(discount);
        System.out.println("Descuento aplicado con éxito al producto " + id);
    }

    public void getDiscountProducts(){
        List<Product> discountProducts = this.products.stream()
                .filter(product -> product.getDiscount() > 0).toList();
        if(discountProducts.isEmpty()){
            System.out.println("No existen productos con descuento en este momento.");
        }else {
            System.out.println("Los productos con descuento son:");
            discountProducts.forEach(System.out::println);
        }
    }
    public void getProductStock(){
        int id = Menu.askInt("Entre el id del producto que quieres consultar el stock: ");
        Product product = this.getProductById(id);
        if (product == null){
            System.out.println("Este producto no existe");
        }
        else {
            int stockQty = product.getStockQty();
            if (stockQty <= 0 ){
                System.out.println("El producto solicitado no tiene stock.");
            }else {
                System.out.println("El producto solicitado tiene " + stockQty + " unidades en stock.");
            }
        }
    }
    public void addProductStock(){
        int id = Menu.askInt("Entre el id del producto al que desea añadir stock: ");
        Product product = this.getProductById(id);
        if (product == null){
            System.out.println("Este producto no existe");
        }
        else {
            int stock = Menu.askInt("Unidades de stock a añadir: ");
            if(stock > 0){
                product.setStockQty(product.getStockQty() + stock);
                System.out.println("El nuevo stock es: " + product.getStockQty());
            }else {
                System.out.println("La operación no se puede llevar a cabo, las unidades a añadir son negativas.");
            }
        }
    }

    public void substractProductStock(){
        int id = Menu.askInt("Entre el id del producto al que desea restar stock: ");
        Product product = this.getProductById(id);
        if (product == null){
            System.out.println("Este producto no existe");
        }
        else {
            int stock = Menu.askInt("Unidades de stock a restar (unidades actuales = " + product.getStockQty() + "): ");
            if(stock < 0 ){
                System.out.println("La operación no se puede realizar, las unidades a restar son negativas.");
            }else {
                if (stock > product.getStockQty()){
                    stock = product.getStockQty();
                    System.out.println("Sólo se descontarán las unidades disponibles.");
                }
                product.setStockQty(product.getStockQty() - stock);
                System.out.println("El nuevo stock es: " + product.getStockQty());
            }
        }
    }

    public void listProducts(){
        this.products.forEach(System.out::println);
    }
}

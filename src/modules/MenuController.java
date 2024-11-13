package modules;

import exceptions.ProductNotFoundException;

import java.util.List;

import static modules.Menu.askInt;
import static modules.Menu.readOption;

public class MenuController {
    public static boolean selMenu(Store store){

        switch (readOption()){
            case 0:
                System.out.println("Gracias por usar esa aplicación!");
                return true;
            case 1:
                Product product = store.createProduct();
                store.addProduct(product);
                break;
            case 2:
                System.out.println("Lista de productos ordenados de menor a mayor precio");
                List<Product> productList = store.productList();
                productList.forEach(System.out::println);
                break;

            case 3:
                try{
                    store.listProducts();
                    store.deleteProduct(askInt("Entre el id del producto a eliminar: "));
                } catch (ProductNotFoundException e) {
                    System.out.println("El producto no existe.");
                }
                break;
            case 4:
                store.calculateWarranty(askInt("Entre el id del producto del cual quiere fecha de garantía"));
                break;
            case 5:
                store.setDiscount();
                break;
            case 6:
                store.getDiscountProducts();
                break;
            case 7:
                store.getProductStock();
                break;
            case 8:
                store.addProductStock();
                break;
            case 9:
                store.substractProductStock();
                break;
            default:

        }
        return false;
    }


}

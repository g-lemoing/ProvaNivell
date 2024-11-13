package main;

import modules.MenuController;
import modules.Store;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        boolean exit;
        do {
            exit = MenuController.selMenu(store);
        }while(!exit);
    }
}

package modules;

import enumclasses.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayMenu(){
        final String[] options = {"Salir de la aplicación",
                "Crear producto",
                "Listar productos de mayor a menor precio",
                "Eliminar producto",
                "Calcular fecha vencimiento de la garantía",
                "Aplicar rebajas a productos",
                "Mostrar productos en rebajas",
                "Consultar stock de un producto",
                "Aumentar stock a producto",
                "Quitar stock a producto"
        };
        System.out.println("\n---- MENÚ PRINCIPAL TIENDA CORTE IRLANDÉS ----");
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + ". " + options[i]);
        }
        System.out.println("Tu selección >> ");
    }

    public static void displayProductType(){
        final String[] options = {"Ropa",
                "Electrodomésticos",
                "Componentes electronicos",
                "Belleza",
        };
        System.out.println("---- SELECCIONA TIPO PRODUCTO ----");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.println("Tu selección: ");
    }

    public static byte readOption() {
        byte option;
        do {
            try{
                displayMenu();
                option = scanner.nextByte();
            } catch (InputMismatchException e) {
                option = -1;
            }finally {
                scanner.nextLine();
            }
        }while (option < 0 || option > 9);
        return option;
    }

    public static byte readProductType() {
        byte option;
        do {
            try{
                displayProductType();
                option = (byte) (scanner.nextByte() - 1);
            } catch (InputMismatchException e) {
                option = -1;
            }finally {
                scanner.nextLine();
            }
        }while (option < 0 || option > 3);
        return option;
    }

    public static int askInt(String message){
        int id = -1;
        do{
            System.out.println(message);
            try{
                id = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Valor entrado incorrecto");
                e.getMessage();
            }
            finally {
                scanner.nextLine();
            }

        }while (id == -1 );
        return id;
    }

    public static String menuAskString(String message){
        String name = "";
        do{
            System.out.println(message);
            name = scanner.nextLine();
        }while (name.isEmpty());
        return name;
    }

    public static double askDouble(String message){
        double price = -1;
        do{
            System.out.println(message);
            try {
                price = scanner.nextDouble();
            }catch (InputMismatchException e){
                System.out.println("El valor entrado tiene que ser un decimal superior a 0.");
                price = -1;
            }
            finally {
                scanner.nextLine();
            }
        }while (price <= 0);
        return price;
    }

    public static Date askDate(String message){
        String dateStr;
        Date date = null;
        do{
            System.out.println(message);
            try {
                dateStr = scanner.nextLine();
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                date = formatter.parse(dateStr);
            } catch (ParseException e) {
                System.out.println("Formato de fecha incorrecto, formato esperado: 'yyyy-MM-dd'");
            }
        }while (date == null);
        return date;
    }

    public static BatteryCapacity menuAskBattery(String message){
        String input;
        BatteryCapacity capacity = null;
        boolean isCorrect = false;
        do{
            System.out.println(message);
            try {
                input = scanner.nextLine();
                capacity = BatteryCapacity.valueOf(input);
                isCorrect = true;
            }catch (IllegalArgumentException e){
                System.out.println("La capacidad indicada no forma parte de los valores posibles.");
            }
        }while (!isCorrect);
        return capacity;
    }

    public static GarnmentType menuAskGarnmentType(String message){
        String input;
        GarnmentType garnmentType = null;
        boolean isCorrect = false;
        do{
            System.out.println(message);
            try {
                input = scanner.nextLine();
                garnmentType = GarnmentType.valueOf(input);
                isCorrect = true;
            }catch (IllegalArgumentException e){
                System.out.println("El tipo de prenda indicada no forma parte de los valores posibles.");
            }
        }while (!isCorrect);
        return garnmentType;
    }

    public static Season menuAskSeason(String message){
        String input;
        Season season = null;
        boolean isCorrect = false;
        do{
            System.out.println(message);
            try {
                input = scanner.nextLine();
                season = Season.valueOf(input);
                isCorrect = true;
            }catch (IllegalArgumentException e){
                System.out.println("La temporada indicada no forma parte de los valores posibles.");
            }
        }while (!isCorrect);
        return season;
    }

    public static Size menuAskSize(String message){
        String input;
        Size size = null;
        boolean isCorrect = false;
        do{
            System.out.println(message);
            try {
                input = scanner.nextLine();
                size = Size.valueOf(input);
                isCorrect = true;
            }catch (IllegalArgumentException e){
                System.out.println("La talla indicada no forma parte de los valores posibles.");
            }
        }while (!isCorrect);
        return size;
    }

    public static Textile menuAskTextile(String message){
        String input;
        Textile textile = null;
        boolean isCorrect = false;
        do{
            System.out.println(message);
            try {
                input = scanner.nextLine();
                textile = Textile.valueOf(input);
                isCorrect = true;
            }catch (IllegalArgumentException e){
                System.out.println("El tipo de téxtil indicado no forma parte de los valores posibles.");
            }
        }while (!isCorrect);
        return textile;
    }

    public static boolean askYesNo(String message){
        String result;
        do{
            System.out.println(message);
            result = scanner.nextLine().toUpperCase();
        }while (!result.matches("[SN]") );
        return result.equals("S");
    }
}

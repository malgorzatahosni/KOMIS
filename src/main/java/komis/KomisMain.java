package komis;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KomisMain {

    static List<Car> cars = new ArrayList<Car>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("WITAJ W KOMISIE! MENU:");
        System.out.println("1. Dodaj nowy samochód.");
        System.out.println("2. Wyświetl listę samochodów.");
        System.out.println("3. Usuń samochód.");
        System.out.println("Podaj nr działania: 1, 2 lub 3:");
        int firstMove = scanner.nextInt();

        System.out.println("Wybrałeś opcję: " + firstMove);

        switch (firstMove) {
            case 1:
                createNewCar();
                break;
            case 2:
                System.out.println("Lista:");
                System.out.println(cars.toString());
                System.out.println();
                System.out.println("Co dalej?");
                System.out.println("1: posortuj i wyświetl.");
                System.out.println("2: filtruj i wyświetl.");
                int secondMove = scanner.nextInt();
                break;
            case 3:
                System.out.println("Podaj, który samochód chcesz usunąć?");
                System.out.println("Lista:");
                System.out.println(cars.toString());
                break;
        }

    }

    public static void createNewCar() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Podaj kolor samochodu:");
        String color = scanner1.nextLine();
        System.out.println("Podaj cenę:");
        BigDecimal price = scanner1.nextBigDecimal();
        System.out.println("Podaj ilość drzwi:");
        int doors = scanner1.nextInt();
        scanner1.nextLine();
        System.out.println("Podaj markę samochodu:");
        String name = scanner1. nextLine();
        System.out.println("Podaj rok produkcji:");
        int year = scanner1.nextInt();
        Car car = new Car(color, price, doors, name, year);
        cars.add(car);
    }

}

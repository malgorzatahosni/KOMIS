package komis;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KomisMain {

    static List<Car> cars = new ArrayList<>();

    static List<Car> soldCars = new ArrayList<>();

    public static void main(String[] args) {

        cars.add(new Car("blue", new BigDecimal("11000"), 3, "SEAT", 2017));
        cars.add(new Car("blue", new BigDecimal("10000"), 5, "FIAT", 2010));
        cars.add(new Car("red", new BigDecimal("17000"), 3, "HONDA", 2015));
        cars.add(new Car("red", new BigDecimal("15000"), 5, "VOLVO", 2008));
        cars.add(new Car("yellow", new BigDecimal("20000"), 4, "RENAULT", 2012));

        menu();

    }

     public static void menu() {

            Scanner scanner = new Scanner(System.in);

            System.out.println("WITAJ W KOMISIE! MENU:");
            System.out.println("1. Dodaj nowy samochód.");
            System.out.println("2. Wyświetl listę samochodów.");
            System.out.println("3. Usuń samochód.");
            System.out.println("4. Wyświetl stan konta.");
            System.out.println("Podaj nr działania: 1, 2, 3 lub 4:");
            int firstMove = scanner.nextInt();

            System.out.println("Wybrałeś opcję: " + firstMove);

            switch (firstMove) {
                case 1:
                    System.out.println("Ile samochodów chcesz dodać?");
                    int numberOfCars = scanner.nextInt();
                    for (int i = 0; i < numberOfCars; i++) {
                        createNewCar();
                        System.out.println("Dodałeś nowy samochód");
                    }
                    System.out.println();
                case 2:
                    System.out.println("Oto lista samochodów:");
                    System.out.println(cars.toString());
                    System.out.println();
                    System.out.println("Co robisz dalej?");
                    System.out.println("1: posortuj i wyświetl.");
                    System.out.println("2: filtruj i wyświetl.");
                    int secondMove = scanner.nextInt();
                    if (secondMove == 1) {
                        System.out.println("Po jakim parametrze chcesz sortować?");
                        System.out.println("1: Cena");
                        System.out.println("2: Rok produkcji");
                        System.out.println("Wpisz 1 lub 2.");
                        int thirdMove = scanner.nextInt();
                        if (thirdMove == 1) {
                            sortByPrice();
                        } else {
                            sortByYear();
                        }
                    } else {
                        System.out.println("Podaj filtr:");
                        System.out.println("1: kolor BLUE");
                        System.out.println("2: kolor RED");
                        System.out.println("3: 3-drzwiowe");
                        System.out.println("4: 4- i 5-drzwiowe");
                        System.out.println("5: Młodsze niż 5 lat");
                        System.out.println("Wpisz 1, 2, 3, 4 lub 5");
                        int fourthMove = scanner.nextInt();
                        switch (fourthMove) {
                            case 1:
                                filterByColorBlue();
                                break;
                            case 2:
                                filterByColorRed();
                                break;
                            case 3:
                                filterBy3Doors();
                                break;
                            case 4:
                                filterBy4And5Doors();
                                break;
                            case 5:
                                filterByYear();
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Podaj, który samochód chcesz usunąć z listy?");
                    System.out.println("Lista:");
                    System.out.println(cars.toString());
                    System.out.println("Podaj nr samochodu na liście");
                    int carNumber = scanner.nextInt();
                    soldCars.add(cars.get(carNumber));
                    cars.remove(carNumber);
                    System.out.println("Usunięto samochód");
                    menu();
                case 4:
                    accountBalance();
                    menu();
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

    public static void sortByPrice() {
        cars.sort(new SortByPriceComparator());
        System.out.println(cars.toString());
    }

    public static void sortByYear() {
        cars.sort(new SortByPriceComparator());
        System.out.println(cars.toString());
    }

    public static void filterByColorBlue() {
        cars.stream()
                .filter(cars -> cars.getColor().equals("blue"))
                .forEach(System.out::println);
    }
    public static void filterByColorRed () {
        cars.stream()
                .filter(cars -> cars.getColor().equals("red"))
                .forEach(System.out::println);
    }
    public static void filterBy3Doors() {
        cars.stream()
                .filter(cars -> cars.getDoors() == 3)
                .forEach(System.out::println);
    }
    public static void filterBy4And5Doors() {
        cars.stream()
                .filter(cars-> cars.getDoors() >= 4)
                .forEach(System.out::println);
    }
    public static void filterByYear() {
        cars.stream()
                .filter(cars -> 2019 - cars.getYear() <= 5)
                .forEach(System.out::println);
    }
    public static void accountBalance() {
        soldCars.stream()
                .map(Car::getPrice)
                .reduce(BigDecimal::add)
                .ifPresent(System.out::println);
    }

}

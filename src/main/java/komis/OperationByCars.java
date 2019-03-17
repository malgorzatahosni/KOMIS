package komis;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class OperationByCars {

    public static List<Car> cars = new ArrayList<>();
    public static List<Car> soldCars = new ArrayList<>();
    public static String color;
    public static List<Integer> filters = new ArrayList<>();

    public static void createNewCar() {
        Scanner scanner1 = new Scanner(System.in);
        chooseColor();
        System.out.println("Podaj cenę:");
        BigDecimal price = scanner1.nextBigDecimal();
        System.out.println("Podaj ilość drzwi: 3, 4 lub 5");
        int doors = scanner1.nextInt();
        scanner1.nextLine();
        System.out.println("Podaj markę samochodu:");
        String name = scanner1. nextLine();
        System.out.println("Podaj rok produkcji:");
        int year = scanner1.nextInt();
        Car car = new Car(color, price, doors, name, year);
        cars.add(car);
    }
    public static void removeCar() {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Podaj, który samochód chcesz usunąć z listy?");
        System.out.println("Lista:");
        System.out.println(cars.toString());
        System.out.println("Podaj nr samochodu na liście");
        int carNumber = scanner2.nextInt();
        soldCars.add(cars.get(carNumber));
        cars.remove(carNumber);
        System.out.println("Usunięto samochód");
    }
    public static void chooseColor() {
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Podaj kolor samochodu:");
        System.out.println("1: blue");
        System.out.println("2: red");
        System.out.println("3: yellow");
        System.out.println("4: green");
        System.out.println("5: black");
        System.out.println("6: white");
        System.out.println("7: other");
        System.out.println("Podaj 1, 2, 3, 4, 5, 6 lub 7");
        int carColor = scanner3.nextInt();
        if (carColor > 7 || carColor < 1) {
            System.out.println("Podałeś złą wartość. Spróbuj jeszcze raz.");
            chooseColor();
        } else {
            switch (carColor) {
                case 1:
                    color = "blue";
                    break;
                case 2:
                    color = "red";
                    break;
                case 3:
                    color = "yellow";
                    break;
                case 4:
                    color = "green";
                    break;
                case 5:
                    color = "black";
                    break;
                case 6:
                    color = "white";
                    break;
                case 7:
                    color = "other";
                    break;
            }
        }
    }
    public static void sortByPrice() {
        cars.sort(new SortByPriceComparator());
        System.out.println(cars.toString());
    }

    public static void sortByYear() {
        cars.sort(new SortByPriceComparator());
        System.out.println(cars.toString());
    }
    public static void sortByDoors() {
        cars.sort(new SortByDoorsComparator());
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
    public static void sortAndFilterYearAndPrice() {
        cars.stream()
                .filter(cars -> 2019 - cars.getYear() <= 5)
                .sorted(new SortByPriceComparator())
                .forEach(System.out::println);
    }
    public static void sortAndFilterDoorsAndYear() {
        cars.stream()
                .filter(cars->cars.getDoors() >= 4)
                .sorted(new SortByYearComparator())
                .forEach(System.out::println);
    }
    public static void chooseManyVariables() {
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Po ilu zmiennych chcesz filtrować (max 4)?");
        int iloscZmiennych = scanner4.nextInt();
        if (iloscZmiennych > 4 || iloscZmiennych < 1) {
            System.out.println("Nieprawidłowa wartość. Spróbuj ponownie.");
            chooseManyVariables();
        } else {
            for (int i = 0; i < iloscZmiennych; i++) {
                System.out.println("Podaj nr zmiennej:");
                System.out.println("1: kolor");
                System.out.println("2. marka");
                System.out.println("3. ilość drzwi");
                System.out.println("4. młodsze niż 5 lat");
                int filtr = scanner4.nextInt();
                filters.add(filtr);
            }
        }
        filtrowanie(filters);
    }
    public static void filtrowanie(List<Integer> filters) {
        Scanner scanner6 = new Scanner(System.in);
        List<Car> afterFilterCars = cars;
        for (int zmienna: filters) {
            switch (zmienna) {
                case 1:
                    System.out.println("Podaj kolor: blue, red, yellow, white, black, other");
                    String chosenColor = scanner6.nextLine();
                    afterFilterCars = afterFilterCars.stream()
                            .filter(cars -> cars.getColor().equals(chosenColor))
                            .collect(Collectors.toList());
                    break;
                case 2:
                    System.out.println("Podaj markę, która Cię interesuje.");
                    String choosenName = scanner6.nextLine();
                    afterFilterCars = afterFilterCars.stream()
                            .filter(cars -> cars.getName().equals(choosenName))
                            .collect(Collectors.toList());
                    break;
                case 3:
                    System.out.println("Podaj ilość drzwi: 3, 4 lub 5");
                    int choosenDoors = scanner6.nextInt();
                    if (choosenDoors < 3 || choosenDoors > 5) {
                        System.out.println("Podana wartość jest niepoprawna. Spróbuj ponownie.");
                        filtrowanie(filters);
                    } else {
                        afterFilterCars = afterFilterCars.stream()
                                .filter(cars -> cars.getDoors() == choosenDoors)
                                .collect(Collectors.toList());
                        break;
                    }
                case 4:
                    afterFilterCars = afterFilterCars.stream()
                            .filter(cars -> 2019 - cars.getYear() <= 5)
                            .collect(Collectors.toList());
                    break;
            }
        }
        System.out.println(afterFilterCars);
    }
}

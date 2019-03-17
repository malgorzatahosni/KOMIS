package komis;

import java.math.BigDecimal;
import java.util.Scanner;

import static komis.OperationByCars.cars;


public class KomisMain {


    public static void main(String[] args) {

        cars.add(new Car("blue", new BigDecimal("11000"), 3, "SEAT", 2017));
        cars.add(new Car("blue", new BigDecimal("10000"), 5, "FIAT", 2010));
        cars.add(new Car("red", new BigDecimal("17000"), 3, "HONDA", 2015));
        cars.add(new Car("red", new BigDecimal("15000"), 5, "VOLVO", 2008));
        cars.add(new Car("yellow", new BigDecimal("20000"), 4, "RENAULT", 2012));

        System.out.println("WITAJ W KOMISIE!");
        menu();

    }

     public static void menu() {

            Scanner scanner = new Scanner(System.in);

            System.out.println("MENU:");
            System.out.println("1. Dodaj nowy samochód.");
            System.out.println("2. Wyświetl listę samochodów.");
            System.out.println("3. Usuń samochód.");
            System.out.println("4. Wyświetl stan konta.");
            System.out.println("5. Zakończ.");
            System.out.println("Podaj nr działania: 1, 2, 3, 4 lub 5:");
            int firstMove = scanner.nextInt();

            System.out.println("Wybrałeś opcję: " + firstMove);

            switch (firstMove) {
                case 1:
                    System.out.println("Ile samochodów chcesz dodać?");
                    int numberOfCars = scanner.nextInt();
                    for (int i = 0; i < numberOfCars; i++) {
                        OperationByCars.createNewCar();
                        System.out.println("Dodałeś nowy samochód");
                    }
                    System.out.println();
                    backToMenu();
                    break;
                case 2:
                    System.out.println("Lista samochodów:");
                    System.out.println(cars.toString());
                    System.out.println();
                    System.out.println("Co robisz dalej?");
                    System.out.println("1: posortuj i wyświetl.");
                    System.out.println("2: filtruj i wyświetl.");
                    System.out.println("3: filtruj i sortuj");
                    System.out.println("4: użyj kilku filtrów");
                    int secondMove = scanner.nextInt();
                    switch (secondMove) {
                        case 1:
                            System.out.println("Po jakim parametrze chcesz sortować?");
                            System.out.println("1: Cena");
                            System.out.println("2: Rok produkcji");
                            System.out.println("3. Ilość drzwi");
                            System.out.println("Wpisz 1, 2 lub 3.");
                            int thirdMove = scanner.nextInt();
                            switch (thirdMove) {
                                case 1:
                                    OperationByCars.sortByPrice();
                                    backToMenu();
                                    break;
                                case 2:
                                    OperationByCars.sortByYear();
                                    backToMenu();
                                    break;
                                case 3:
                                    OperationByCars.sortByDoors();
                                    backToMenu();
                                    break;
                            }
                        case 2:
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
                                    OperationByCars.filterByColorBlue();
                                    backToMenu();
                                    break;
                                case 2:
                                    OperationByCars.filterByColorRed();
                                    backToMenu();
                                    break;
                                case 3:
                                    OperationByCars.filterBy3Doors();
                                    backToMenu();
                                    break;
                                case 4:
                                    OperationByCars.filterBy4And5Doors();
                                    backToMenu();
                                    break;
                                case 5:
                                    OperationByCars.filterByYear();
                                    backToMenu();
                                    break;
                            }
                        case 3:
                            System.out.println("Podaj filtr i parametr");
                            System.out.println("1. Młodsze niż 5 lat, sortuj po cenie");
                            System.out.println("2. 4- i 5- drzwiowe, sortuj po roku");
                            System.out.println("Wybierz 1 lub 2.");
                            int sixthMove = scanner.nextInt();
                            switch (sixthMove) {
                                case 1:
                                    OperationByCars.sortAndFilterYearAndPrice();
                                    backToMenu();
                                    break;
                                case 2:
                                    OperationByCars.sortAndFilterDoorsAndYear();
                                    backToMenu();
                                    break;
                            }
                        case 4:
                            OperationByCars.chooseManyVariables();
                            backToMenu();
                            break;
                    }
                    break;
                case 3:
                    OperationByCars.removeCar();
                    backToMenu();
                case 4:
                    OperationByCars.accountBalance();
                    backToMenu();
                case 5:
                    System.out.println("KONIEC");
                    System.exit(1);
            }
        }
    public static void backToMenu() {
        System.out.println("Gotowe. Co robisz dalej?");
        menu();
    }
}

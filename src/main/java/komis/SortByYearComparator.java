package komis;

import java.util.Comparator;

public class SortByYearComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        int year1 = o1.getYear();
        int year2 = o2.getYear();
        return year1 - year2;
    }
}

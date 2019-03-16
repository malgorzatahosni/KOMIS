package komis;

import java.util.Comparator;

public class SortByPriceComparator implements Comparator<Car> {
    public int compare(Car o1, Car o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}

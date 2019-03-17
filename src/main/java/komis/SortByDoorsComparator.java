package komis;

import java.util.Comparator;

public class SortByDoorsComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        int car1 = o1.getDoors();
        int car2 = o2.getDoors();
        return car1 - car2;
    }
}

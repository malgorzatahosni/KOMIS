package komis;

import java.math.BigDecimal;

public class Car {
    private String color;
    private BigDecimal price;
    private int doors;
    private String name;
    private int year;

    public Car(String color, BigDecimal price, int doors, String name, int year) {
        this.color = color;
        this.price = price;
        this.doors = doors;
        this.name = name;
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color= '" + color + '\'' +
                ", price= " + price +
                ", doors= " + doors +
                ", name= '" + name + '\'' +
                ", year= " + year +
                '}' + '\n';
    }
}

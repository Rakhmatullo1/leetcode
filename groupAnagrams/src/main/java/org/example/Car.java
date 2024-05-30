package org.example;

import java.util.Objects;

public class Car {
    private String color;

    public Car() {
    }

    public Car(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}

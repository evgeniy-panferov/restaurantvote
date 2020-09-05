package ru.restarauntvote.to;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class DishTo {

    private int price;

    private String description;

    @ConstructorProperties({"price", "description"})
    public DishTo(int price, String description) {
        this.price = price;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishTo dishTo = (DishTo) o;
        return price == dishTo.price &&
                Objects.equals(description, dishTo.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, description);
    }
}

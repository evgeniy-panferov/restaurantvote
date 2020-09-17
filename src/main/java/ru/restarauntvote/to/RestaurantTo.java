package ru.restarauntvote.to;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.Objects;

public class RestaurantTo {

    protected final int id;

    protected final String name;

    private final List<DishTo> menu;

    @ConstructorProperties({"id", "name", "menu"})
    public RestaurantTo(int id, String name, List<DishTo> menu) {
        this.id = id;
        this.name = name;
        this.menu = menu;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<DishTo> getMenu() {
        return menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantTo that = (RestaurantTo) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(menu, that.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, menu);
    }
}

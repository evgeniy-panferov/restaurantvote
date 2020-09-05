package ru.restarauntvote.util;

import ru.restarauntvote.model.Dish;
import ru.restarauntvote.to.DishTo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DishUtil {

    public static DishTo createTo(Dish dish) {
        return new DishTo(dish.getPrice(), dish.getDescription());
    }

    public static List<DishTo> createListTo(Collection<Dish> dishes) {
        return dishes.stream()
                .map(dish -> createTo(dish))
                .collect(Collectors.toList());
    }
}

package ru.restarauntvote.util;

import ru.restarauntvote.model.Restaurant;
import ru.restarauntvote.to.RestaurantTo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantUtil {

    public static RestaurantTo createTo(Restaurant restaurant) {
        return new RestaurantTo(restaurant.getName(), DishUtil.createListTo(restaurant.getMenu()));
    }

    public static List<RestaurantTo> createListTo(Collection<Restaurant> restaurants) {
        return restaurants.stream()
                .map(restaurant -> createTo(restaurant))
                .collect(Collectors.toList());
    }
}

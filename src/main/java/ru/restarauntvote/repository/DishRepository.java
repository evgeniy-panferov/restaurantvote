package ru.restarauntvote.repository;

import ru.restarauntvote.model.Dish;

import java.util.List;

public interface DishRepository {

    List<Dish> getByRestaurant();

    Dish save(Dish dish, int dishId);

    int delete(int dishId, int restaurantId);
}

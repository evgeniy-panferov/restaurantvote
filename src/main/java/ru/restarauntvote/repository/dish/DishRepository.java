package ru.restarauntvote.repository.dish;

import ru.restarauntvote.model.Dish;

import java.util.List;

public interface DishRepository {

    Dish get(int id, int restaurantId);

    List<Dish> getAllByRestaurantId(int restaurantId);

    Dish save(Dish dish, int restaurantId);

    boolean delete(int id, int restaurantId);
}

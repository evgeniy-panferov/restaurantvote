package ru.restarauntvote.repository;

import ru.restarauntvote.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    List<Restaurant> getAll();

    Restaurant save(Restaurant restaurant, int restaurantId);

    int delete (int restaurantId);
}

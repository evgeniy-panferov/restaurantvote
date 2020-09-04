package ru.restarauntvote.repository.restaurant;

import ru.restarauntvote.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    Restaurant get(int id);

    List<Restaurant> getAll();

    boolean delete(int id);
}

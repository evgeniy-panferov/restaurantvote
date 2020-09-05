package ru.restarauntvote.repository.restaurant;

import ru.restarauntvote.model.Restaurant;
import ru.restarauntvote.to.RestaurantTo;

import java.util.List;

public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    Restaurant get(int id);

    List<RestaurantTo> getAll();

    boolean delete(int id);
}

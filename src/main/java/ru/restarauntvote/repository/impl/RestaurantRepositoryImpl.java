package ru.restarauntvote.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restarauntvote.model.Restaurant;
import ru.restarauntvote.repository.RestaurantRepository;
import ru.restarauntvote.repository.datajpa.DataRestaurantRepository;

import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private final DataRestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantRepositoryImpl(DataRestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAll() {
        return null;
    }

    @Override
    public Restaurant save(Restaurant restaurant, int restaurantId) {
        return null;
    }

    @Override
    public int delete(int restaurantId) {
        return 0;
    }
}

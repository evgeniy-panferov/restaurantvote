package ru.restarauntvote.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restarauntvote.model.Dish;
import ru.restarauntvote.repository.DishRepository;
import ru.restarauntvote.repository.datajpa.DataDishRepository;
import ru.restarauntvote.repository.datajpa.DataRestaurantRepository;

import java.util.List;

@Repository
public class DishRepositoryImpl implements DishRepository {

    private final DataDishRepository dishRepository;
    private final DataRestaurantRepository restaurantRepository;

    @Autowired
    public DishRepositoryImpl(DataDishRepository dishRepository, DataRestaurantRepository restaurantRepository) {
        this.dishRepository = dishRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Dish> getByRestaurant() {
        return null;
    }

    @Override
    public Dish save(Dish dish, int dishId) {
        return null;
    }

    @Override
    public int delete(int dishId, int restaurantId) {
        return 0;
    }
}

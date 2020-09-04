package ru.restarauntvote.repository.restaurant;

import org.springframework.stereotype.Repository;
import ru.restarauntvote.model.Restaurant;

import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private final CrudRestaurantRepository crudRestaurantRepository;

    public RestaurantRepositoryImpl(CrudRestaurantRepository crudRestaurantRepository) {
        this.crudRestaurantRepository = crudRestaurantRepository;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        if (!restaurant.isNew() && get(restaurant.getId()) == null) {
            return null;
        }

        return crudRestaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant get(int id) {
        return crudRestaurantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Restaurant> getAll() {
        return crudRestaurantRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        return crudRestaurantRepository.delete(id) != 0;
    }
}

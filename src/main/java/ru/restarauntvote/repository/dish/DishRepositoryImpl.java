package ru.restarauntvote.repository.dish;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.restarauntvote.model.Dish;
import ru.restarauntvote.repository.restaurant.CrudRestaurantRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DishRepositoryImpl implements DishRepository {

    private final CrudDishRepository crudDishRepository;
    private final CrudRestaurantRepository crudRestaurantRepository;

    public DishRepositoryImpl(CrudDishRepository crudDishRepository, CrudRestaurantRepository crudRestaurantRepository) {
        this.crudDishRepository = crudDishRepository;
        this.crudRestaurantRepository = crudRestaurantRepository;
    }

    @Override
    public Dish get(int id, int restaurantId) {
        return crudDishRepository.findById(id)
                .filter(dish -> dish.getRestaurant().getId() == restaurantId)
                .orElse(null);
    }

    @Override
    public List<Dish> getAllByRestaurantId(int restaurantId) {
        return crudDishRepository.getAllByRestaurantId(restaurantId);
    }

    @Override
    @Transactional
    public Dish save(Dish dish, int restaurantId) {
        dish.setRestaurant(crudRestaurantRepository.findById(restaurantId).orElse(null));
        dish.setDate(LocalDateTime.now());
        return crudDishRepository.save(dish);
    }

    @Override
    public void delete(int id, int restaurantId) {
        crudDishRepository.delete(id, restaurantId);
    }
}

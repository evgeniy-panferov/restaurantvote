package ru.restarauntvote.repository.dish;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.restarauntvote.model.Dish;
import ru.restarauntvote.model.Restaurant;
import ru.restarauntvote.repository.restaurant.CrudRestaurantRepository;

import java.time.LocalDateTime;
import java.util.List;

import static ru.restarauntvote.util.ValidationUtil.checkNotFound;

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
        Restaurant restaurant = crudRestaurantRepository.findById(restaurantId).orElse(null);
        checkNotFound(restaurant, String.format("Restaurant with id : %s not found", restaurantId));
        if (!dish.isNew() && get(dish.getId(), restaurantId) == null) {
            return null;
        }
        dish.setRestaurant(restaurant);
        dish.setDate(LocalDateTime.now());
        return crudDishRepository.save(dish);
    }

    @Override
    public boolean delete(int id, int restaurantId) {
        return crudDishRepository.delete(id, restaurantId) != 0;
    }
}

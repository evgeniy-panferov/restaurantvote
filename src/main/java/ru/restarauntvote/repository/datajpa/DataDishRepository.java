package ru.restarauntvote.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.restarauntvote.model.Dish;

import java.util.List;

public interface DataDishRepository extends JpaRepository<Dish, Integer> {

    List<Dish> getByRestaurant();

    Dish save(Dish dish, int dishId);

    int delete(int dishId, int restaurantId);
}

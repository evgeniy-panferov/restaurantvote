package ru.restarauntvote.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.restarauntvote.model.Restaurant;

import java.util.List;

public interface DataRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    List<Restaurant> getAll();

    Restaurant save(Restaurant restaurant, int restaurantId);

    int delete (int restaurantId);

}

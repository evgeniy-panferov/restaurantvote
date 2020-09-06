package ru.restarauntvote.web.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.restarauntvote.model.Restaurant;
import ru.restarauntvote.repository.restaurant.RestaurantRepository;
import ru.restarauntvote.to.RestaurantTo;

import javax.validation.Valid;
import java.util.List;

import static ru.restarauntvote.util.ValidationUtil.*;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    private static final Logger log = LoggerFactory.getLogger(RestaurantController.class);

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Cacheable(value = "restaurants")
    @GetMapping(value = "get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RestaurantTo> getAll() {
        log.info("getAll restaurants");
        return restaurantRepository.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant get(@PathVariable int id) {
        log.info("get restaurant, id - {}", id);
        return checkNotFound(restaurantRepository.get(id), String.format("Restaurant with id : %s not found", id));
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    @PostMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void create(@Valid @RequestBody Restaurant restaurant) {
        log.info("create restaurant - {}", restaurant);
        checkNew(restaurant);
        restaurantRepository.save(restaurant);
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    @PutMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Restaurant restaurant) {
        log.info("update restaurant - {}", restaurant);
        checkNotFound(restaurantRepository.save(restaurant), String.format("Restaurant - %s with id : %s not found",
                restaurant.getName(), restaurant.getId()));
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete restaurant, id - {}", id);
        checkNotFoundWithId(restaurantRepository.delete(id), id);
    }
}
